package com.example.telegramechobot.bot;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
class HandleService {
    
    @ServiceActivator(inputChannel = "incomingUpdatesChannel", outputChannel = "outcomingMessagesChannel")
    SendMessage handle(Update update) {
        String messageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        return SendMessage.builder()
            .chatId(chatId)
            .text(messageText)
            .build();
    }
}
