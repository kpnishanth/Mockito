package com.nishanth.firstspringproject;

import com.nishanth.firstspringproject.controllers.BookController;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BookController.class)
public class TestsUsingMockMvc {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BookRepository bookRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/book/nishanth"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().encoding("UTF-8"));
    }

    @Test
    public void test1() throws Exception {
        mockMvc.perform(get("/book/liji"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().encoding("UTF-8"));
    }
}