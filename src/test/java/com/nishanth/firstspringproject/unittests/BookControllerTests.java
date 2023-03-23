package com.nishanth.firstspringproject.unittests;

import com.nishanth.firstspringproject.controllers.BookController;
import com.nishanth.firstspringproject.domain.Book;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookControllerTests {
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookController bookController= new BookController(bookRepository);



    @Test
    public void BookControllerTest() {
        Book book1 = new Book();
        book1.setReader("Nishanth");
        book1.setTitle("Spring in Action");
        book1.setAuthor("James");
        book1.setDescription("nice book");
        List<Book> bookList = Arrays.asList(book1);
        Model model=null;
        when(bookRepository.findByReader("Nishanth")).thenReturn(bookList);
        assertEquals(bookController.readersBooks("Nishanth",model),"readingList");

    }

}
