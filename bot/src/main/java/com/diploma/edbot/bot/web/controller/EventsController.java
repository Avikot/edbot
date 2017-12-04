package com.diploma.edbot.bot.web.controller;

import com.diploma.edbot.bot.core.model.callbacks.FailedCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/receive-event", method = RequestMethod.POST)
    public ResponseEntity receiveEvent(@RequestBody String body) {

        FailedCallback failedCallback = new FailedCallback(FailureCallback.class, System.currentTimeMillis(), "12345", "12345", "Wow wow, stop it");

        applicationEventPublisher.publishEvent(failedCallback);

        return ResponseEntity.ok("Failure!");
    }
}
