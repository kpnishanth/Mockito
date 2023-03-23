package com.nishanth.firstspringproject;

import com.nishanth.firstspringproject.controllers.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UsingWebMvcTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    BookController bookController;
    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/book/nishanth")).andExpect(status().isOk());
    }
}
