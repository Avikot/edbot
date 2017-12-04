package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.SubscribedCallback;
import org.springframework.context.ApplicationListener;

public class OnSubscribedEventListener implements ApplicationListener<SubscribedCallback> {
    @Override
    public void onApplicationEvent(SubscribedCallback subscribedCallback) {

    }
}
