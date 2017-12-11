package com.diploma.edbot.bot.core.model;

import com.diploma.edbot.bot.BotProfile;
import lombok.Data;

@Data
public class Sender {

    private String name;
    private String avatar;

    public Sender(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public Sender(BotProfile botProfile) {
        this.name = botProfile.getName();
        this.avatar = botProfile.getAvatar();
    }
}
