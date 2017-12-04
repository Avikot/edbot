package com.diploma.edbot.bot.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Contact {

    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
