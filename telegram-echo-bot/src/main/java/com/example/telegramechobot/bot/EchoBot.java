package com.example.telegramechobot.bot;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class EchoBot extends TelegramLongPollingBot{
    private final TelegramBotConfig config;
    private final IncomingMessageGateway incomingMessageGateway;

    public EchoBot(
        TelegramBotConfig config,
        IncomingMessageGateway incomingMessageGateway) {
        
        super(config.getToken());
        this.config = config;
        this.incomingMessageGateway = incomingMessageGateway;
    }

    @Override
    public void onUpdateReceived(Update update) {
        incomingMessageGateway.sendUpdate(update);
    }

    @ServiceActivator(inputChannel = "outcomingMessagesChannel")
    public void sendMessage(SendMessage sendMessage){
        try {
             execute(sendMessage);                        //Actually sending the message
        } catch (TelegramApiException e) {
             throw new RuntimeException(e);      //Any error will be printed here
        }
     }

    @Override
    public String getBotUsername() {
        return config.getUsername();
    }    
}
