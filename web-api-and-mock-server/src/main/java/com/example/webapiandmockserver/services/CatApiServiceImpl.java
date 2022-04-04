package com.example.webapiandmockserver.services;

import com.example.webapiandmockserver.dtos.FactDto;
import io.netty.handler.logging.LogLevel;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import javax.annotation.PostConstruct;

@Service
public class CatApiServiceImpl implements CatApiService {
    private WebClient webClient;

    @PostConstruct
    void initWebClient() {
        // Это нужно если хочется, чтобы в логах детально отображались запросы к API и ответы
        HttpClient httpClient = HttpClient
                .create()
                .wiretap("reactor.netty.http.client.HttpClient",
                        LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);

        webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("https://catfact.ninja/")
                .build();
    }

    @Override
    public String getFact() {
        return webClient
                .get()
                .uri("/fact")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FactDto.class)
                .map(FactDto::fact)
                .block();
    }
}
