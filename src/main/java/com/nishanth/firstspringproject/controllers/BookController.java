package com.nishanth.firstspringproject.controllers;

import com.nishanth.firstspringproject.domain.Book;
import com.nishanth.firstspringproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    public BookRepository repository;

    public BookController() {
    }

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/{reader}")
    public String readersBooks(@PathVariable(value = "reader") String reader,Model model) {
        if(!reader.equalsIgnoreCase("Nishanth")){
            model.addAttribute("title","title");
            return "error";
        }
        List<Book> bookList = repository.findByReader(reader);
        model.addAttribute("books", bookList);
        return "readingList";
    }

    @PostMapping(value = "/{reader}")
    public String addToReadingList(@PathVariable(value="reader") String reader,Book book) {

        book.setReader(reader);
        repository.save(book);
        return "redirect:/{reader}";
    }


}
