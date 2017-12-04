package com.edbot.diploma.bot.core.listeners;

import com.edbot.diploma.bot.core.model.callbacks.UnsubscribedCallback;
import org.springframework.context.ApplicationListener;

public class OnUnsubscribedEventListener implements ApplicationListener<UnsubscribedCallback> {
    @Override
    public void onApplicationEvent(UnsubscribedCallback unsubscribedCallback) {

    }
}
