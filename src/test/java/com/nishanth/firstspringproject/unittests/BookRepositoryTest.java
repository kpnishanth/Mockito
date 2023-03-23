package com.nishanth.firstspringproject.unittests;

import com.nishanth.firstspringproject.domain.Book;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {
    @Mock
    BookRepository bookRepository;
    @Test
    public void testBookRepo(){

        //arrange
        Book book1 = new Book();
        book1.setReader("Nishanth");
        book1.setTitle("Spring in Action");
        book1.setAuthor("James");
        book1.setDescription("nice book");

        Book book2 = new Book();
        book2.setReader("Liji");
        book2.setTitle("Springboot in Action");
        book2.setAuthor("Jerry");
        book2.setDescription("Very good book");


        //act
        List<Book> bookList = Arrays.asList(book1,book2);
        when(bookRepository.findByReader("Nishanth")).thenReturn(bookList);
        when(bookRepository.findById(10L)).thenReturn(Optional.of(book1));
        when(bookRepository.save(book1)).thenReturn(book1);
        when(bookRepository.findAll()).thenReturn(bookList);

        //assert
        assertTrue(bookRepository.findByReader("Nishanth").get(0).equals(book1));
        assertEquals(bookRepository.findById(10L),Optional.of(book1));
        assertEquals(bookRepository.save(book1),book1);
        assertEquals(bookRepository.findAll(),bookList);
    }
}
