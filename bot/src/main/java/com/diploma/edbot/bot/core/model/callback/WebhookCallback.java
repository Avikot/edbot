package com.diploma.edbot.bot.core.model.callback;

import com.diploma.edbot.bot.core.model.constant.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookCallback extends CallbackEvent {

    public WebhookCallback() {
    }

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
