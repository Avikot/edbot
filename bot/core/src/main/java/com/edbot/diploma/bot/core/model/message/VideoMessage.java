package com.edbot.diploma.bot.core.model.message;

import com.edbot.diploma.bot.core.constants.MessageType;
import com.edbot.diploma.bot.core.model.Sender;
import lombok.Data;

@Data
public class VideoMessage extends Message {

    private String media;
    private String size;
    private String duration;
    private String thumbnail;

    public VideoMessage(String receiver, String trackingData, String minApiVersion, Sender sender, String media, String size, String duration, String thumbnail) {
        super(MessageType.VIDEO, receiver, trackingData, minApiVersion, sender);
        this.media = media;
        this.size = size;
        this.duration = duration;
        this.thumbnail = thumbnail;
    }
}
