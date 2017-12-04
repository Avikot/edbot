package com.edbot.diploma.bot.core.model.callbacks;

import com.edbot.diploma.bot.core.model.constants.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookCallback extends CallbackEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param event
     * @param customTimestamp
     * @param messageToken
     */
    public WebhookCallback(Object source, String event, String customTimestamp, String messageToken) {
        super(source, EventType.WEBHOOK, customTimestamp, messageToken);
    }
}
