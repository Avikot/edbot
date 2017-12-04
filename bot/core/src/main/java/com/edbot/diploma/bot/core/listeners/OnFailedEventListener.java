package com.edbot.diploma.bot.core.listeners;

import com.edbot.diploma.bot.core.model.callbacks.FailedCallback;
import org.springframework.context.ApplicationListener;

public class OnFailedEventListener implements ApplicationListener<FailedCallback> {
    @Override
    public void onApplicationEvent(FailedCallback failedCallback) {

    }
}
