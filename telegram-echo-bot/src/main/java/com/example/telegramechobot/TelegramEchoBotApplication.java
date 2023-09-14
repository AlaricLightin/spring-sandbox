package com.example.telegramechobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.example.telegramechobot.bot.EchoBot;
import com.example.telegramechobot.bot.TelegramBotConfig;

@SpringBootApplication
@EnableConfigurationProperties(TelegramBotConfig.class)
public class TelegramEchoBotApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TelegramEchoBotApplication.class, args);

		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(ctx.getBean(EchoBot.class));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
