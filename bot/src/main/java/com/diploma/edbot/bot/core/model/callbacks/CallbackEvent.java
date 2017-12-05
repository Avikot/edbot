package com.diploma.edbot.bot.core.model.callbacks;

import com.diploma.edbot.bot.core.model.constants.EventType;
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
    private Long customTimestamp;

    @JsonProperty("message_token")
    private String messageToken;

    public CallbackEvent() {
        super(CallbackEvent.class);
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CallbackEvent(Object source, EventType event, Long customTimestamp, String messageToken) {
        super(source);
        this.event = event.getEventType();
        this.customTimestamp = customTimestamp;
        this.messageToken = messageToken;
    }
}
