package com.edbot.diploma.bot.core.model.message;

import com.edbot.diploma.bot.core.constants.MessageType;
import com.edbot.diploma.bot.core.model.Location;
import com.edbot.diploma.bot.core.model.Sender;
import lombok.Data;

@Data
public class LocationMessage extends Message {

    private Location location;

    public LocationMessage(String receiver, String trackingData, String minApiVersion, Sender sender, Location location) {
        super(MessageType.LOCATION, receiver, trackingData, minApiVersion, sender);
        this.location = location;
    }
}
