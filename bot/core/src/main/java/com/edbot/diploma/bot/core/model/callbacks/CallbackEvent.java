package com.edbot.diploma.bot.core.model.callbacks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackEvent {

    @JsonProperty("event")
    private String event;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("message_token")
    private String messageToken;

    public CallbackEvent(String event, String timestamp, String messageToken) {
        this.event = event;
        this.timestamp = timestamp;
        this.messageToken = messageToken;
    }
}
