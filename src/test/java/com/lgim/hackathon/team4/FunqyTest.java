package com.lgim.hackathon.team4;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class FunqyTest {

    @Test
    public void testGreeting() {
        given()
                .given()
                .contentType("application/json")
                .body("{\"name\": \"Bill\"}")
                .post("/greet")
                .then()
                .statusCode(200)
                .body("message", equalTo("Hello Bill"));

        given()
                .given()
                .contentType("application/json")
                .body(new Friend("John"))
                .post("/greet")
                .then()
                .statusCode(200)
                .body("message", equalTo("Hello John"));
    }

}