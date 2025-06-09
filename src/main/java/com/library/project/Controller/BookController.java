package com.library.project.Controller;

import com.library.project.Entity.BookEntity;
import com.library.project.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/{isbn}")
    public Optional<BookEntity> getBookByIsbn(@PathVariable Long isbn) {
        return bookServiceImpl.getBookByIsbn(isbn);
    }
}
