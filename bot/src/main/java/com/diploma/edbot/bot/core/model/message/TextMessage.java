package com.diploma.edbot.bot.core.model.message;

import com.diploma.edbot.bot.core.model.constant.MessageType;
import com.diploma.edbot.bot.core.model.Sender;
import lombok.Data;

@Data
public class TextMessage extends Message {

    private String text;

    public TextMessage(String receiver, String trackingData, String minApiVersion, Sender sender, String text) {
        super(MessageType.TEXT, receiver, trackingData, minApiVersion, sender);
        this.text = text;
    }

    @Override
    public void setType(String type) {
        super.setType(MessageType.TEXT.getType());
    }
}
