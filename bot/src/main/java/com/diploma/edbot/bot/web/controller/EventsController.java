package com.diploma.edbot.bot.web.controller;

import com.diploma.edbot.bot.core.model.callbacks.CallbackEvent;
import com.diploma.edbot.bot.core.model.callbacks.ConversationStartedCallback;
import com.diploma.edbot.bot.core.model.callbacks.DeliveredCallback;
import com.diploma.edbot.bot.core.model.callbacks.FailedCallback;
import com.diploma.edbot.bot.core.model.callbacks.MessageCallback;
import com.diploma.edbot.bot.core.model.callbacks.SeenCallback;
import com.diploma.edbot.bot.core.model.callbacks.SubscribedCallback;
import com.diploma.edbot.bot.core.model.callbacks.UnsubscribedCallback;
import com.diploma.edbot.bot.core.model.callbacks.WebhookCallback;
import com.diploma.edbot.bot.core.model.constants.EventType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@RestController
public class EventsController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/receive-event", method = RequestMethod.POST)
    public ResponseEntity receiveEvent(@RequestBody String body) throws IOException {

        CallbackEvent callbackEvent = identifyEvent(body);

        applicationEventPublisher.publishEvent(callbackEvent);

//        FailedCallback failedCallback = new FailedCallback(FailureCallback.class, System.currentTimeMillis(), "12345", "12345", "Wow wow, stop it");

//        applicationEventPublisher.publishEvent(failedCallback);

        return ResponseEntity.ok((System.currentTimeMillis()));
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        logger.info((new Date()).toString());

        return String.valueOf(System.currentTimeMillis());
    }

    private CallbackEvent identifyEvent(String body) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String,Object> result = mapper.readValue(body, HashMap.class);
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
