package com.nishanth.firstspringproject.unittests;

import com.nishanth.firstspringproject.domain.Book;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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
    @Test
    public void orderTest(){
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

        when(bookRepository.findByReader(anyString())).thenReturn(Arrays.asList(book1));
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book1));
        bookRepository.findById(2L);
        bookRepository.findByReader("Nishanth");

        verify(bookRepository,timeout(1L)).findById(anyLong());
        verify(bookRepository,timeout(1L)).findByReader(anyString());
        InOrder inOrder = inOrder(bookRepository);
        inOrder.verify(bookRepository).findById(anyLong());
        inOrder.verify(bookRepository,times(1)).findByReader(anyString());
       verify(bookRepository,times(1)).findById(anyLong());
        verifyNoMoreInteractions(bookRepository);

        Book book = bookRepository.findById(anyLong()).get();


    }


}
