package com.nishanth.firstspringproject;

import com.nishanth.firstspringproject.controllers.BookController;
import com.nishanth.firstspringproject.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@WebMvcTest(BookController.class)
@ComponentScan(basePackages = {"src/main/java/com/nishanth/firstspringproject/repository"})
@Sql({"/Author.sql"})
public class FirstspringprojectApplicationTests {

	@Autowired
	BookController bookController;
	@Autowired
	AuthorRepository authorRepository;
	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(authorRepository.findAll().size()>3);
	}

}
