package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.MessageCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnMessageEventListener implements ApplicationListener<MessageCallback> {

    //TODO message typed listener

    @Override
    public void onApplicationEvent(MessageCallback messageCallback) {

    }
}
