package com.nishanth.firstspringproject.unittests;

import com.nishanth.firstspringproject.controllers.BookController;
import com.nishanth.firstspringproject.domain.Book;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTests {
    @Mock
    BookRepository bookRepository;
    @Spy
    BookController bookController = new BookController(bookRepository);
    @Mock
Model model;
    @Test
    public void argCapturetest() {

        Book book1 = new Book();
        book1.setReader("Nishanth");
        book1.setTitle("Spring in Action");
        book1.setAuthor("James");
        book1.setDescription("nice book");
        List<Book> bookList = Arrays.asList(book1);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        when(bookRepository.findByReader(argumentCaptor.capture())).thenReturn(bookList);
        bookController.readersBooks("Nishanth",model);
        assertThat(argumentCaptor.getValue()).isEqualTo("Nishanth");
        bookRepository.findAll();
        verifyNoMoreInteractions(bookRepository);
        bookRepository.findAll();
        verify(bookRepository).findAll();

    }

    //spy
    @Test
    public void spyTest() {


        when(bookController.readersBooks("nishanth",model)).thenReturn("Test");
    }

    @Test
    public void answertest() {
        Book book1 = new Book();
        book1.setReader("Nishanth");
        book1.setTitle("Spring in Action");
        book1.setAuthor("James");
        book1.setDescription("nice book");
        List<Book> bookList = Arrays.asList(book1);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        when(bookRepository.findByReader(argumentCaptor.capture())).thenAnswer(invocationOnMock -> {
            Object argument = invocationOnMock.getArgument(0);
            if (argument.equals("Nishanth")) {
                return bookList;
            } else {
                return null;
            }
        }).thenReturn(bookList);
        bookController.readersBooks("Nisanth",model);
        assertThat(argumentCaptor.getValue()).isEqualTo("Nishanth");
    }

    @Test
    public void BookControllerTest() {
        Book book1 = new Book();
        book1.setReader("Nishanth");
        book1.setTitle("Spring in Action");
        book1.setAuthor("James");
        book1.setDescription("nice book");
        List<Book> bookList = Arrays.asList(book1);
        Model model = null;
        when(bookRepository.findByReader("Nishanth")).thenReturn(bookList);
        assertEquals(bookController.readersBooks("Nishanth",model), "readingList");

    }

}
