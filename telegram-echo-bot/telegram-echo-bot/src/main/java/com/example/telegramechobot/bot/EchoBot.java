package com.example.telegramechobot.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class EchoBot extends TelegramLongPollingBot{
    private final TelegramBotConfig config;

    public EchoBot(TelegramBotConfig config) {
        super(config.getToken());
        this.config = config;   
    }

    @Override
    public void onUpdateReceived(Update update) {
        String messageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        sendText(chatId, messageText);
    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                         .chatId(who.toString()) //Who are we sending a message to
                         .text(what).build();    //Message content
        try {
             execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
             throw new RuntimeException(e);      //Any error will be printed here
        }
     }

    @Override
    public String getBotUsername() {
        return config.getUsername();
    }    
}
