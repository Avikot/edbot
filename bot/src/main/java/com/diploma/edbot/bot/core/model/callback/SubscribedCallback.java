package com.diploma.edbot.bot.core.model.callback;

import com.diploma.edbot.bot.core.model.User;
import com.diploma.edbot.bot.core.model.constant.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribedCallback extends CallbackEvent {

    @JsonProperty("user")
    private User user;

    public SubscribedCallback() {
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public SubscribedCallback(Object source, Long customTimestamp, String messageToken, User user) {
        super(source, EventType.SUBSCRIBED, customTimestamp, messageToken);
        this.user = user;
    }
}
