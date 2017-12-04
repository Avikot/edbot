package com.diploma.edbot.bot.core.model.message;

import com.diploma.edbot.bot.core.model.constants.MessageType;
import com.diploma.edbot.bot.core.model.Sender;
import lombok.Data;

@Data
public class UrlMessage extends Message {

    private String media;

    public UrlMessage(String receiver, String trackingData, String minApiVersion, Sender sender, String media) {
        super(MessageType.URL, receiver, trackingData, minApiVersion, sender);
        this.media = media;
    }

    @Override
    public void setType(String type) {
        super.setType(MessageType.URL.getType());
    }
}
