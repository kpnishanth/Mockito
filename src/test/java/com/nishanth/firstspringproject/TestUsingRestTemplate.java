package com.nishanth.firstspringproject;

import com.nishanth.firstspringproject.controllers.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUsingRestTemplate {
    @Value(value="${local.server.port}")
    private int port;
    @Autowired
    BookController bookController;
    @Autowired
    TestRestTemplate restTemplate;
    @Test
    @Sql({"/Author.sql"})
    public void bookControllerTest(){
        assertThat(bookController).isNotNull();
         ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + port + "/book/nishanth", String.class);
        assertThat(forEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        ResponseEntity<String> forEntity2 = restTemplate.getForEntity("http://localhost:" + port + "/book/liji", String.class);
        assertThat(forEntity2.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
