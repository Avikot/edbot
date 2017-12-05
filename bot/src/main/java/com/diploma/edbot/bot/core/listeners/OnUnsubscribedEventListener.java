package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.UnsubscribedCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnUnsubscribedEventListener implements ApplicationListener<UnsubscribedCallback> {
    @Override
    public void onApplicationEvent(UnsubscribedCallback unsubscribedCallback) {

    }
}
