package com.diploma.edbot.bot.core.model.callback;

import com.diploma.edbot.bot.core.model.constant.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsubscribedCallback extends CallbackEvent {

    @JsonProperty("user_id")
    private String userId;

    public UnsubscribedCallback() {
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public UnsubscribedCallback(Object source, Long customTimestamp, String messageToken, String userId) {
        super(source, EventType.UNSUBSCRIBED, customTimestamp, messageToken);
        this.userId = userId;
    }
}
