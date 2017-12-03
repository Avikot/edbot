package com.edbot.diploma.bot.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("country")
    private String country;

    @JsonProperty("language")
    private String language;

    @JsonProperty("api_version")
    private String apiVersion;
}
