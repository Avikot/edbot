package com.edbot.diploma.bot.core.model.callbacks;

import com.edbot.diploma.bot.core.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribedCallback extends CallbackEvent {

    @JsonProperty("user")
    private User user;

    public SubscribedCallback(Object source, String event, String timestamp, String messageToken, User user) {
        super(source, event, timestamp, messageToken);
        this.user = user;
    }
}
