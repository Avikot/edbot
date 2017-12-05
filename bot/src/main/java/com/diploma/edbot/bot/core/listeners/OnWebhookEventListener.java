package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.WebhookCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnWebhookEventListener implements ApplicationListener<WebhookCallback> {

    @Override
    public void onApplicationEvent(WebhookCallback webhookCallback) {

    }
}
