package com.diploma.edbot.bot.core.model.message;

import com.diploma.edbot.bot.core.model.Sender;
import com.diploma.edbot.bot.core.model.constants.MessageType;
import lombok.Data;

@Data
public class PictureMessage extends Message {

    private String text;
    private String media;
    private String thumbnail;

    public PictureMessage(String receiver, String trackingData, String minApiVersion, Sender sender, String text, String media, String thumbnail) {
        super(MessageType.PICTURE, receiver, trackingData, minApiVersion, sender);
        this.text = text;
        this.media = media;
        this.thumbnail = thumbnail;
    }

    @Override
    public void setType(String type) {
        super.setType(MessageType.PICTURE.getType());
    }
}
