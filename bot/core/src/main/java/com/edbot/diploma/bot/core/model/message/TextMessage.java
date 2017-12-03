package com.edbot.diploma.bot.core.model.message;

import com.edbot.diploma.bot.core.constants.MessageType;
import com.edbot.diploma.bot.core.model.Sender;
import lombok.Data;

@Data
public class TextMessage extends Message {

    private String text;

    public TextMessage(String receiver, String trackingData, String minApiVersion, Sender sender, String text) {
        super(MessageType.TEXT, receiver, trackingData, minApiVersion, sender);
        this.text = text;
    }
}
