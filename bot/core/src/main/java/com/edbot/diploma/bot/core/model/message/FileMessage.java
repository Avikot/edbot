package com.edbot.diploma.bot.core.model.message;

import com.edbot.diploma.bot.core.constants.MessageType;
import com.edbot.diploma.bot.core.model.Sender;
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
}
