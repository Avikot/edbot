package com.diploma.edbot.bot.core.listener;

import com.diploma.edbot.bot.core.model.callback.UnsubscribedCallback;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OnUnsubscribedEventListener implements ApplicationListener<UnsubscribedCallback> {
    @Override
    public void onApplicationEvent(UnsubscribedCallback unsubscribedCallback) {

    }
}
