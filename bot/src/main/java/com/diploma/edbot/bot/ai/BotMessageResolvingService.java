package com.diploma.edbot.bot.ai;

import com.diploma.edbot.bot.core.model.callback.CallbackEvent;
import com.diploma.edbot.bot.core.model.message.Message;

public interface BotMessageResolvingService {

    Message resolveMessage(CallbackEvent event);
}
