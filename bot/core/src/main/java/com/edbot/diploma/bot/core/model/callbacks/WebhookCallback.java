package com.edbot.diploma.bot.core.model.callbacks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookCallback extends CallbackEvent {

    public WebhookCallback(String event, String timestamp, String messageToken) {
        super("webhook", timestamp, messageToken);
    }
}
