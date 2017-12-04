package com.diploma.edbot.bot.core.model.constants;

public enum MessageType {

    TEXT("text"),
    PICTURE("picture"),
    VIDEO("video"),
    FILE("file"),
    CONTACT("contact"),
    URL("url"),
    STICKER("sticker"),
    CAROUSEL("rich_media"),
    LOCATION("location");

    private String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
