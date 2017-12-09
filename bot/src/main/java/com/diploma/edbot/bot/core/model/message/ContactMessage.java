package com.diploma.edbot.bot.core.model.message;

import com.diploma.edbot.bot.core.model.Contact;
import com.diploma.edbot.bot.core.model.Sender;
import com.diploma.edbot.bot.core.model.constant.MessageType;
import lombok.Data;

@Data
public class ContactMessage extends Message {

    private Contact contact;

    public ContactMessage(String receiver, String trackingData, String minApiVersion, Sender sender, Contact contact) {
        super(MessageType.CONTACT, receiver, trackingData, minApiVersion, sender);
        this.contact = contact;
    }

    @Override
    public void setType(String type) {
        super.setType(MessageType.CONTACT.getType());
    }
}
