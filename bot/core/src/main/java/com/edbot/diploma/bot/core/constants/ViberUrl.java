package com.edbot.diploma.bot.core.constants;

public enum  ViberUrl {

    VIBER_URL("https://chatapi.viber.com/pa/"),
    WEBHOOK_PATH("set_webhook"),
    SEND_MESSAGE("send_message");

    private String value;

    ViberUrl(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
