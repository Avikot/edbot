package com.edbot.diploma.bot.core.model.callbacks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallbackEvent extends ApplicationEvent {

    @JsonProperty("event")
    private String event;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("message_token")
    private String messageToken;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CallbackEvent(Object source, String event, String timestamp, String messageToken) {
        super(source);
        this.event = event;
        this.timestamp = timestamp;
        this.messageToken = messageToken;
    }

//    public CallbackEvent(String event, String timestamp, String messageToken) {
//        this.event = event;
//        this.timestamp = timestamp;
//        this.messageToken = messageToken;
//    }
}
