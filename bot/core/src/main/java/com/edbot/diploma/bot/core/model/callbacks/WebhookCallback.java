package com.edbot.diploma.bot.core.model.callbacks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookCallback extends CallbackEvent {

    public WebhookCallback(Object source, String event, String timestamp, String messageToken) {
        super(source, "webhook", timestamp, messageToken);
    }
}
