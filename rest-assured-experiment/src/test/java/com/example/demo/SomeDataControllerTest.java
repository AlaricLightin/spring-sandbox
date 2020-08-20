package com.example.demo;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

class SomeDataControllerTest {
    @InjectMocks
    SomeDataController controller;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void initRestAssured() {
        RestAssuredMockMvc.standaloneSetup(controller);
    }

    @Test
    void shouldGetSomeData() {
        SomeData[] someData = given()
                .when()
                    .get("/somedata")
                .then()
                    .statusCode(OK.value())
                .extract().body().as(SomeData[].class);

        assertThat(Arrays.asList(someData))
                .containsExactly(new SomeData(1, "text1"), new SomeData(2, "text2"));
    }

}