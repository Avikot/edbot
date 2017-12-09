package com.diploma.edbot.bot.core.model.message;

import com.diploma.edbot.bot.core.model.Sender;
import com.diploma.edbot.bot.core.model.constant.MessageType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FileMessage extends Message {

    private String media;
    private String size;

    @JsonProperty("file_name")
    private String fileName;

    public FileMessage(String receiver, String trackingData, String minApiVersion, Sender sender, String media, String size, String fileName) {
        super(MessageType.FILE, receiver, trackingData, minApiVersion, sender);
        this.media = media;
        this.size = size;
        this.fileName = fileName;
    }

    @Override
    public void setType(String type) {
        super.setType(MessageType.FILE.getType());
    }
}
