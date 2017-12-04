package com.edbot.diploma.bot.core.model.constants;

public enum  EventType {

    WEBHOOK("webhook"),
    CONVERSATION_STARTED("conversation_started"),
    SUBSCRIBED("subscribed"),
    UNSUBSCRIBED("unsubscribed"),
    DELIVERED("delivered"),
    SEEN("seen"),
    FAILED("failed"),
    MESSAGE("message");

    private String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
