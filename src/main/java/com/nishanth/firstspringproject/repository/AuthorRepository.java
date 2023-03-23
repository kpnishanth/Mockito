package com.nishanth.firstspringproject.repository;

import com.nishanth.firstspringproject.domain.Author;
import com.nishanth.firstspringproject.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
