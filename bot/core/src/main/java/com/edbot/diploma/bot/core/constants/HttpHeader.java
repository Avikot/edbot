package com.edbot.diploma.bot.core.constants;

public enum HttpHeader {

    AUTH_TOKEN_HEADER("X-Viber-Auth-Token"),
    SIGNATURE_HEADER("X-Viber-Content-Signature");

    private String headerName;

    HttpHeader(String headerName) {
        this.headerName = headerName;
    }

    HttpHeader() {
        this(null);
    }

    public String getHeaderName() {
        return headerName;
    }
}
