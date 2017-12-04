package com.edbot.diploma.bot.core.listeners;

import com.edbot.diploma.bot.core.model.callbacks.SubscribedCallback;
import org.springframework.context.ApplicationListener;

public class OnSubscribedEventListener implements ApplicationListener<SubscribedCallback> {
    @Override
    public void onApplicationEvent(SubscribedCallback subscribedCallback) {

    }
}
