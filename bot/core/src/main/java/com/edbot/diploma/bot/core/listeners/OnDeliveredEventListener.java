package com.edbot.diploma.bot.core.listeners;

import com.edbot.diploma.bot.core.model.callbacks.DeliveredCallback;
import org.springframework.context.ApplicationListener;

public class OnDeliveredEventListener implements ApplicationListener<DeliveredCallback> {
    @Override
    public void onApplicationEvent(DeliveredCallback deliveredCallback) {

    }
}
