package com.edbot.diploma.bot.core.model.callbacks;

import com.edbot.diploma.bot.core.model.User;
import com.edbot.diploma.bot.core.model.constants.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationStartedCallback extends CallbackEvent {

    @JsonProperty("type")
    private String type;

    @JsonProperty("context")
    private String context;

    @JsonProperty("user")
    private User user;

    @JsonProperty("subscribed")
    private Boolean subscribed;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public ConversationStartedCallback(Object source, String customTimestamp, String messageToken, String type, String context, User user, Boolean subscribed) {
        super(source, EventType.CONVERSATION_STARTED, customTimestamp, messageToken);
        this.type = type;
        this.context = context;
        this.user = user;
        this.subscribed = subscribed;
    }
}
