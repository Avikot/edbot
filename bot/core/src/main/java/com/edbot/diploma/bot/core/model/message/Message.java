package com.edbot.diploma.bot.core.model.message;

import com.edbot.diploma.bot.core.model.constants.MessageType;
import com.edbot.diploma.bot.core.model.Sender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {

    private String type;
    private String receiver;

    @JsonProperty("tracking_date")
    private String trackingData;

    @JsonProperty("min_api_version")
    private String minApiVersion;

    private Sender sender;

    public Message(MessageType type, String receiver, String trackingData, String minApiVersion, Sender sender) {
        this.type = type.getType();
        this.receiver = receiver;
        this.trackingData = trackingData;
        this.minApiVersion = minApiVersion;
        this.sender = sender;
    }
}
