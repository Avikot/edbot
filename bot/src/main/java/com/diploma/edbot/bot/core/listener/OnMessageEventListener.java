package com.diploma.edbot.bot.core.listener;

import com.diploma.edbot.bot.core.model.callback.MessageCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnMessageEventListener implements ApplicationListener<MessageCallback> {

    //TODO message typed listener

    @Override
    public void onApplicationEvent(MessageCallback messageCallback) {

    }
}
