package com.example.iniciosb;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class HelloControllerIntegrationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RestTestClient client;

    @Test
    public void getHello() {
        System.out.println("Test!");
        client.get().uri("/").exchangeSuccessfully()
                .expectBody(String.class)
                .isEqualTo("Greetings from Spring Boot!");
    }
}