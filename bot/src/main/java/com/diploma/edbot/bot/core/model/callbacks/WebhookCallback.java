package com.diploma.edbot.bot.core.model.callbacks;

import com.diploma.edbot.bot.core.model.constants.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookCallback extends CallbackEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public WebhookCallback(Object source, Long customTimestamp, String messageToken) {
        super(source, EventType.WEBHOOK, customTimestamp, messageToken);
    }
}
