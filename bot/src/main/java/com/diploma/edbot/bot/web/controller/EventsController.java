package com.diploma.edbot.bot.web.controller;

import com.diploma.edbot.bot.Signature;
import com.diploma.edbot.bot.core.model.callbacks.CallbackEvent;
import com.diploma.edbot.bot.core.model.callbacks.ConversationStartedCallback;
import com.diploma.edbot.bot.core.model.callbacks.DeliveredCallback;
import com.diploma.edbot.bot.core.model.callbacks.FailedCallback;
import com.diploma.edbot.bot.core.model.callbacks.MessageCallback;
import com.diploma.edbot.bot.core.model.callbacks.SeenCallback;
import com.diploma.edbot.bot.core.model.callbacks.SubscribedCallback;
import com.diploma.edbot.bot.core.model.callbacks.UnsubscribedCallback;
import com.diploma.edbot.bot.core.model.callbacks.WebhookCallback;
import com.diploma.edbot.bot.core.model.constants.ConstantValues;
import com.diploma.edbot.bot.core.model.constants.HttpHeader;
import com.diploma.edbot.bot.core.model.constants.ViberUrl;
import com.diploma.edbot.bot.core.model.response.WebhookResponse;
import com.diploma.edbot.bot.web.exceptions.AccessDeniedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class EventsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public EventsController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @RequestMapping(value = "/receive-event", method = RequestMethod.POST)
    public ResponseEntity receiveEvent(@RequestBody String body,
                                       HttpServletRequest request) throws IOException, SignatureException {

        String signature = request.getHeader(HttpHeader.SIGNATURE_HEADER.getValue());
        isValidContentSignature(body, signature);

        CallbackEvent callbackEvent = identifyEvent(body);
        applicationEventPublisher.publishEvent(callbackEvent);

        return ResponseEntity.ok((System.currentTimeMillis()));
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        logger.info((new Date()).toString());

        return String.valueOf(System.currentTimeMillis());
    }

    @RequestMapping(value = "/send_webhook", method = RequestMethod.POST)
    public ResponseEntity<WebhookResponse> sendWebhook(@RequestBody String webhookAsString,
                                      HttpServletRequest request) throws SignatureException {
        String tokenUsername = request.getHeader(HttpHeader.AUTH_TOKEN_HEADER.getValue());
        isAccessDenied(tokenUsername, webhookAsString);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WebhookResponse> responseEntity
                = restTemplate.postForEntity(ViberUrl.VIBER_URL.getValue() + ViberUrl.WEBHOOK_PATH.getValue(), webhookAsString, WebhookResponse.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }

    private void isAccessDenied(String tokenUsername, String webHook) {
        String base64EncodedUsernameToken
                = Base64.getEncoder().encodeToString((ConstantValues.MY_USERNAME + ":" + HttpHeader.TOKEN_VALUE).getBytes());

        if (!base64EncodedUsernameToken.equals(tokenUsername)) {
            logger.warn("Invalid access token by setting WebHook: " + webHook);
            throw new AccessDeniedException("Access Denied!");
        }
    }

    private void isValidContentSignature(String body, String signature) throws SignatureException {

        Signature hmacSignature = Signature.getInstance(HttpHeader.TOKEN_VALUE.getValue());
        String checkSignature = hmacSignature.calculateRFC2104HMAC(body);

        if (!Objects.equals(checkSignature, signature)) {
            throw new IllegalArgumentException("Invalid Signature");
        }
    }
    private CallbackEvent identifyEvent(String body) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        HashMap result = mapper.readValue(body, HashMap.class);
        String type = (String) result.get("event");

        switch (type) {
            case "conversation_started":
                return mapper.readValue(body, ConversationStartedCallback.class);
            case "webhook":
                return mapper.readValue(body, WebhookCallback.class);
            case "subscribed":
                return mapper.readValue(body, SubscribedCallback.class);
            case "unsubscribed":
                return mapper.readValue(body, UnsubscribedCallback.class);
            case "delivered":
                return mapper.readValue(body, DeliveredCallback.class);
            case "seen":
                return mapper.readValue(body, SeenCallback.class);
            case "failed":
                return mapper.readValue(body, FailedCallback.class);
            case "message":
                return mapper.readValue(body, MessageCallback.class);
            default:
                return new FailedCallback(body, System.currentTimeMillis(), "0", "0", "Failed to recognize event");

        }
    }
}
