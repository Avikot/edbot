package com.diploma.edbot.bot.core.listener;

import com.diploma.edbot.bot.core.model.callback.ConversationStartedCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnConversationStartedEventListener implements ApplicationListener<ConversationStartedCallback> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ConversationStartedCallback event) {
        logger.info("User started conversation, name={}, id={}", event.getUser().getName(), event.getUser().getId());


    }
}
