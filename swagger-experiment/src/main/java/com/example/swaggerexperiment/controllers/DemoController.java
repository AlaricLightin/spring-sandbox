package com.example.swaggerexperiment.controllers;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/path/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", ref = "#/components/responses/demoException")
    })
    public ResultDto getResult(@PathVariable("id") int id) throws DemoException {
        if (id < 100)
            return new ResultDto(id);
        else
            throw new DemoException(id);
    }

    @GetMapping("/helloworld")
    public String getHelloWorld() {
        return "Hello, world!";
    }
}
