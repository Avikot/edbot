package com.diploma.edbot.bot.ai;

import com.diploma.edbot.bot.BotProfile;
import com.diploma.edbot.bot.core.model.Sender;
import com.diploma.edbot.bot.core.model.callback.CallbackEvent;
import com.diploma.edbot.bot.core.model.callback.ConversationStartedCallback;
import com.diploma.edbot.bot.core.model.callback.MessageCallback;
import com.diploma.edbot.bot.core.model.message.Message;
import com.diploma.edbot.bot.core.model.message.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EdBotMessageResolvingService implements BotMessageResolvingService {

    @Autowired
    private BotProfile botProfile;

    @Override
    public Message resolveMessage(CallbackEvent event) {
        if (event instanceof ConversationStartedCallback) {
            ConversationStartedCallback conversationStarted = (ConversationStartedCallback) event;
            return buildWelcomeMessage(conversationStarted);
        } else if (event instanceof MessageCallback) {
            MessageCallback messageCallback = (MessageCallback) event;
            Message message = messageCallback.getMessage();
            String type = message.getType();

            if (type.equals("text")) {
                TextMessage textMessage = (TextMessage) message;

                String text = textMessage.getText();

                if (text.equals("Yes")) {
                    return new TextMessage(message.getReceiver(), message.getTrackingData(), message.getMinApiVersion(), message.getSender(), "You say YES");
                } else {
                    return new TextMessage(message.getReceiver(), message.getTrackingData(), message.getMinApiVersion(), message.getSender(), "You say NO");
                }
            }
        }

        return null;
    }

    private TextMessage buildWelcomeMessage(ConversationStartedCallback event) {
        return new TextMessage(null,
                UUID.randomUUID().toString(),
                "1",
                new Sender(botProfile),
                event.getUser().getName() + ", Ласкаво проимо до " + botProfile.getName() + "!");
    }
}
