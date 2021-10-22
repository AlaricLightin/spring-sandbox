package com.example.securityandvue;

import io.restassured.authentication.FormAuthConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @LocalServerPort
    private int port;

    @Test
    void shouldGetResource() {
        given()
                .port(port)
                .auth().form("user", "password",
                        new FormAuthConfig("/authentication", "username", "password")
                                .withLoggingEnabled()
                                .sendCsrfTokenAsHeader())

                .when()
                .get("/resource")

                .then()
                .statusCode(OK.value())
                .body("content", is("Hello world"));
    }
}
