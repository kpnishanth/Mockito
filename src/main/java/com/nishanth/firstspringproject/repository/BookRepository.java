package com.nishanth.firstspringproject.repository;

import com.nishanth.firstspringproject.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
   List<Book> findByReader(String reader);
}
