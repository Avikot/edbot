package com.diploma.edbot.bot.core.listener;

import com.diploma.edbot.bot.core.model.callback.WebhookCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OnWebhookEventListener implements ApplicationListener<WebhookCallback> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(WebhookCallback webhookCallback) {
        logger.info("Webhook event received: " + new Date(webhookCallback.getCustomTimestamp()));
    }
}
