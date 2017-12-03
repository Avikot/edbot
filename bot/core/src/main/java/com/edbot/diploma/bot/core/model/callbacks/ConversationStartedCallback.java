package com.edbot.diploma.bot.core.model.callbacks;

import com.edbot.diploma.bot.core.model.User;
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

    public ConversationStartedCallback(String event, String timestamp, String messageToken, String type, String context, User user, Boolean subscribed) {
        super(event, timestamp, messageToken);
        this.type = type;
        this.context = context;
        this.user = user;
        this.subscribed = subscribed;
    }
}
