package com.example.staxeventreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class StaxeventreaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaxeventreaderApplication.class, args);
    }

}
