package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.SeenCallback;
import org.springframework.context.ApplicationListener;

public class OnSeenEventListener implements ApplicationListener<SeenCallback> {
    @Override
    public void onApplicationEvent(SeenCallback seenCallback) {

    }
}
