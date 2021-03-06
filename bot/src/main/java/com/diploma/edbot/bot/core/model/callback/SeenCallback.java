package com.diploma.edbot.bot.core.model.callback;

import com.diploma.edbot.bot.core.model.constant.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeenCallback extends CallbackEvent {

    @JsonProperty("user_id")
    private String userId;

    public SeenCallback() {
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public SeenCallback(Object source, Long customTimestamp, String messageToken, String userId) {
        super(source, EventType.SEEN, customTimestamp, messageToken);
        this.userId = userId;
    }
}
