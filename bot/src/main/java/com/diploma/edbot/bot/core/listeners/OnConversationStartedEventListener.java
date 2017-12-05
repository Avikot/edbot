package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.ConversationStartedCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnConversationStartedEventListener implements ApplicationListener<ConversationStartedCallback> {

    @Override
    public void onApplicationEvent(ConversationStartedCallback event) {

    }
}
