package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.DeliveredCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnDeliveredEventListener implements ApplicationListener<DeliveredCallback> {
    @Override
    public void onApplicationEvent(DeliveredCallback deliveredCallback) {

    }
}
