package com.diploma.edbot.bot.core.listener;

import com.diploma.edbot.bot.core.model.callback.FailedCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OnFailedEventListener implements ApplicationListener<FailedCallback> {

    Logger logger = LoggerFactory.getLogger(OnFailedEventListener.class);

    @Override
    public void onApplicationEvent(FailedCallback failedCallback) {
        String desc = failedCallback.getDesc();
        String userId = failedCallback.getUserId();
        Date date = new Date(failedCallback.getCustomTimestamp());

        logger.error("Failed sending message for user: [" + userId + "], cause: " + desc + ", at: " + date.toString());
    }
}
