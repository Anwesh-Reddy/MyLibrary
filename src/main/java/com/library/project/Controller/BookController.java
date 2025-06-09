package com.library.project.Controller;

import com.library.project.Entity.BookEntity;
import com.library.project.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/books")
    public List<BookEntity> getAllBooks() {
        return bookServiceImpl.getAllBooks();
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity bookEntity){
        return bookServiceImpl.saveBook(bookEntity);
    }

    @PutMapping("/update/{isbn}")
    public BookEntity updateBook(@RequestBody BookEntity bookEntity, @PathVariable Long isbn){
        return bookServiceImpl.updateBook(bookEntity, isbn);
    }

    @DeleteMapping("/delete/{isbn}")
    public BookEntity deleteBook(@PathVariable Long isbn){
        return bookServiceImpl.deleteBook(isbn);
    }
}
