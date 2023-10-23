package com.example.telegramechobot.bot;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.telegram.telegrambots.meta.api.objects.Update;

@MessagingGateway
interface IncomingMessageGateway {
    @Gateway(requestChannel = "incomingUpdatesChannel")
    void sendUpdate(Update update);
}
