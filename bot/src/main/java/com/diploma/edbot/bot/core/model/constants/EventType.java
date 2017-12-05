package com.diploma.edbot.bot.core.model.constants;

import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.isEmpty;

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

    public static EventType byDenom(String denom) {
        if (isEmpty(denom)) {
            return null;
        }

        return Stream.of(EventType.class.getEnumConstants())
                .filter(type -> type.getEventType().equals(denom))
                .findAny()
                .orElse(null);
    }
}
