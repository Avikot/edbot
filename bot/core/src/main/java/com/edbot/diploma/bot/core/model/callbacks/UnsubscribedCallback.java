package com.edbot.diploma.bot.core.model.callbacks;

import com.edbot.diploma.bot.core.model.constants.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsubscribedCallback extends CallbackEvent {

    @JsonProperty("user_id")
    private String userId;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param event
     * @param customTimestamp
     * @param messageToken
     */
    public UnsubscribedCallback(Object source, String event, String customTimestamp, String messageToken, String userId) {
        super(source, EventType.UNSUBSCRIBED, customTimestamp, messageToken);
        this.userId = userId;
    }
}
