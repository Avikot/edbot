package com.edbot.diploma.bot.core.listeners;

import com.edbot.diploma.bot.core.model.callbacks.SeenCallback;
import org.springframework.context.ApplicationListener;

public class OnSeenEventListener implements ApplicationListener<SeenCallback> {
    @Override
    public void onApplicationEvent(SeenCallback seenCallback) {

    }
}
