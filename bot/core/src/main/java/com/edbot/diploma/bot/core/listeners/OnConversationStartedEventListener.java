package com.edbot.diploma.bot.core.listeners;

import com.edbot.diploma.bot.core.model.callbacks.ConversationStartedCallback;
import org.springframework.context.ApplicationListener;

public class OnConversationStartedEventListener implements ApplicationListener<ConversationStartedCallback> {

    @Override
    public void onApplicationEvent(ConversationStartedCallback event) {

    }
}
