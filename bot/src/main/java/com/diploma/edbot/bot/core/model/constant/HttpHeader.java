package com.diploma.edbot.bot.core.model.constant;

public enum HttpHeader {

    AUTH_TOKEN_HEADER("X-Viber-Auth-Token"),
    SIGNATURE_HEADER("X-Viber-Content-Signature"),

    TOKEN_VALUE("46cecdc54767d771-9894fecfa8bc6e11-56c9a48618c79b50");

    private String value;

    HttpHeader(String value) {
        this.value = value;
    }

    HttpHeader() {
        this(null);
    }

    public String getValue() {
        return value;
    }
}
