package com.nishanth.firstspringproject.repository;


import com.nishanth.firstspringproject.controllers.BookController;
import com.nishanth.firstspringproject.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookRepositoryTest {
    @Mock(lenient = false)
    BookRepository bookRepository;
    @InjectMocks
    BookController bookController;
    @Mock
    Model model;

    Book book = new Book();

    @Test
    @DisplayName("Test to validate book repository")
    void test1() {
        verify(bookRepository, never()).findById(anyLong());
        when(bookRepository.findByReader(anyString())).thenReturn(Arrays.asList(book));
        assertThat(bookRepository.findByReader("Nishanth").get(0).equals(book));
        verify(bookRepository, times(1)).findByReader(anyString());
        doThrow(RuntimeException.class).when(bookRepository).findByReader(anyString());
        assertThrows(RuntimeException.class, () -> bookRepository.findByReader("GHgh"));
        when(bookRepository.findByReader(argThat(e->e.isBlank()))).thenReturn(Arrays.asList(book));
        assertThat(bookRepository.findByReader("")).isNotNull();
    }

    @Test
    @DisplayName("controller test")

    public void controllerTest(){
//        Book book = new Book();
//        bookController.readersBooks("test");
//        verify(bookRepository,times(1)).findByReader("test");
//        when(bookController.readersBooks("test")).thenReturn("test");
//        assertThat(bookController.readersBooks("test").equalsIgnoreCase("Wings on Fire")).isTrue();
    }
}