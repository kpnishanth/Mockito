package com.nishanth.firstspringproject.controllers;

import com.nishanth.firstspringproject.domain.Book;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class BookControllerTest {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookController bookController;
    MockMvc mockMvc;
    List<Book> bookList;
    @BeforeEach
    void setUp() {
        Book book1 = new Book();
        book1.setReader("Nishanth");
        book1.setTitle("Spring in Action");
        book1.setAuthor("James");
        book1.setDescription("nice book");
        bookList = List.of(book1);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void readersBooks() throws Exception {
        when(bookRepository.findByReader("Nishanth")).thenReturn(bookList);
        mockMvc.perform(MockMvcRequestBuilders.get("/book/Nishanth"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"));
    }

    @Test
    void addtoReadingListTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/book/Nishanth")
                .param("id","123")
                .param("title","my title")
                .param("isbn","233")
                .param("author","Reddy")
                .param("description","my description")).andExpect(status().is3xxRedirection());
        //mockMvc.perform(post("/book/Nishanth"),param("id","231"),param("title","myTitle")).andExpect(status().isOk());
    }


    @Test
    void readerBooksModelTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/book/Nishanth1"))
                       .andExpect(model().attributeHasErrors())
                .andExpect(model().attributeHasFieldErrors("title"));
    }
}