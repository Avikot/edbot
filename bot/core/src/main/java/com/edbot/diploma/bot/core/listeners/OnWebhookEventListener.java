package com.edbot.diploma.bot.core.listeners;

import com.edbot.diploma.bot.core.model.callbacks.WebhookCallback;
import org.springframework.context.ApplicationListener;

public class OnWebhookEventListener implements ApplicationListener<WebhookCallback> {
    @Override
    public void onApplicationEvent(WebhookCallback webhookCallback) {

    }
}
