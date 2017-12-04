package com.diploma.edbot.bot.core.model.callbacks;

import com.diploma.edbot.bot.core.model.Sender;
import com.diploma.edbot.bot.core.model.constants.EventType;
import com.diploma.edbot.bot.core.model.message.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageCallback<T extends Message> extends CallbackEvent {

    private Sender sender;
    private T message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source          the object on which the event initially occurred (never {@code null})
     * @param customTimestamp
     * @param messageToken
     */
    public MessageCallback(Object source, Long customTimestamp, String messageToken, Sender sender, T message) {
        super(source, EventType.MESSAGE, customTimestamp, messageToken);
        this.sender = sender;
        this.message = message;
    }
}
