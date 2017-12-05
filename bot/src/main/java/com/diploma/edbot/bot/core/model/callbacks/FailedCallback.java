package com.diploma.edbot.bot.core.model.callbacks;

import com.diploma.edbot.bot.core.model.constants.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FailedCallback extends CallbackEvent {

    @JsonProperty("user_id")
    private String userId;

    private String desc;

    public FailedCallback() {
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public FailedCallback(Object source, Long customTimestamp, String messageToken, String userId, String desc) {
        super(source, EventType.FAILED, customTimestamp, messageToken);
        this.userId = userId;
        this.desc = desc;
    }
}
