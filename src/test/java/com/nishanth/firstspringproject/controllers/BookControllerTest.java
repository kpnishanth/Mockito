package com.nishanth.firstspringproject.controllers;

import com.nishanth.firstspringproject.domain.Book;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookController bookController;
    MockMvc mockMvc;



    @Test
    void readersBooks() throws Exception {
        List<Book> bookList = List.of(new Book());
        when(bookRepository.findByReader("Nishanth")).thenReturn(bookList);

        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/book/Nishanth"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"));

    }
}