package com.diploma.edbot.bot.core.listener;

import com.diploma.edbot.bot.core.model.callback.ConversationStartedCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnConversationStartedEventListener implements ApplicationListener<ConversationStartedCallback> {

    @Override
    public void onApplicationEvent(ConversationStartedCallback event) {

    }
}
