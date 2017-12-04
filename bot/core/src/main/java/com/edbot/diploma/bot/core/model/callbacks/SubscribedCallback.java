package com.edbot.diploma.bot.core.model.callbacks;

import com.edbot.diploma.bot.core.model.User;
import com.edbot.diploma.bot.core.model.constants.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribedCallback extends CallbackEvent {

    @JsonProperty("user")
    private User user;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param event
     * @param customTimestamp
     * @param messageToken
     */
    public SubscribedCallback(Object source, String event, String customTimestamp, String messageToken, User user) {
        super(source, EventType.SUBSCRIBED, customTimestamp, messageToken);
        this.user = user;
    }
}
