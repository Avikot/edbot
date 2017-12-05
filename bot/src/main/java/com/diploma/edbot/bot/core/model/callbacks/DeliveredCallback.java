package com.diploma.edbot.bot.core.model.callbacks;

import com.diploma.edbot.bot.core.model.constants.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeliveredCallback extends CallbackEvent {

    @JsonProperty("user_id")
    private String userId;

    public DeliveredCallback() {
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public DeliveredCallback(Object source, Long customTimestamp, String messageToken, String userId) {
        super(source, EventType.DELIVERED, customTimestamp, messageToken);
        this.userId = userId;
    }
}
