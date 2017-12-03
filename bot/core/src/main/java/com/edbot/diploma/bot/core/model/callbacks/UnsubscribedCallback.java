package com.edbot.diploma.bot.core.model.callbacks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsubscribedCallback extends CallbackEvent {

    @JsonProperty("user_id")
    private String userId;

    public UnsubscribedCallback(String event, String timestamp, String messageToken, String userId) {
        super(event, timestamp, messageToken);
        this.userId = userId;
    }
}
