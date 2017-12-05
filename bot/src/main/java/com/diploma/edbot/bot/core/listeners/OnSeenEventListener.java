package com.diploma.edbot.bot.core.listeners;

import com.diploma.edbot.bot.core.model.callbacks.SeenCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Component
public class OnSeenEventListener implements ApplicationListener<SeenCallback> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(SeenCallback seenCallback) {

        RestTemplate restTemplate = new RestTemplate();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ResponseEntity<String> string = restTemplate.getForEntity("http://127.0.0.1:8080/test", String.class);

        logger.info((string.getBody()));

    }
}
