package com.edbot.diploma.bot.core.model.message;

import com.edbot.diploma.bot.core.model.constants.MessageType;
import com.edbot.diploma.bot.core.model.Sender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StickerMessage extends Message {

    @JsonProperty("sticker_id")
    private String stickerId;

    public StickerMessage(String receiver, String trackingData, String minApiVersion, Sender sender, String stickerId) {
        super(MessageType.STICKER, receiver, trackingData, minApiVersion, sender);
        this.stickerId = stickerId;
    }

    @Override
    public void setType(String type) {
        super.setType(MessageType.STICKER.getType());
    }
}
