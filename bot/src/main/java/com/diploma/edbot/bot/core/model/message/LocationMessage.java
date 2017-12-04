package com.diploma.edbot.bot.core.model.message;

import com.diploma.edbot.bot.core.model.Location;
import com.diploma.edbot.bot.core.model.Sender;
import com.diploma.edbot.bot.core.model.constants.MessageType;
import lombok.Data;

@Data
public class LocationMessage extends Message {

    private Location location;

    public LocationMessage(String receiver, String trackingData, String minApiVersion, Sender sender, Location location) {
        super(MessageType.LOCATION, receiver, trackingData, minApiVersion, sender);
        this.location = location;
    }

    @Override
    public void setType(String type) {
        super.setType(MessageType.LOCATION.getType());
    }
}
