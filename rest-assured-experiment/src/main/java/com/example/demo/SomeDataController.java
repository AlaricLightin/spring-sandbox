package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SomeDataController {
    @GetMapping("/somedata")
    public List<SomeData> getData() {
        return Arrays.asList(new SomeData(1, "text1"), new SomeData(2, "text2"));
    }
}
