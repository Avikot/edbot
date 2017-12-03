package com.edbot.diploma.bot.core.model.message;

import lombok.Data;

import java.util.List;

@Data
public class Webhook {

    private String url;
    private List<String> eventTypes;
}
