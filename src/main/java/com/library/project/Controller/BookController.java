package com.library.project.Controller;

import com.library.project.Entity.BookEntity;
import com.library.project.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookServiceImpl.getAllBooks();

    }

    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity bookEntity){
        BookEntity savedBook = bookServiceImpl.saveBook(bookEntity);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/update/{isbn}")
    public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity bookEntity, @PathVariable Long isbn) {
        BookEntity updatedBook = bookServiceImpl.updateBook(bookEntity, isbn);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<BookEntity> deleteBook(@PathVariable Long isbn){
        BookEntity deletedBook = bookServiceImpl.deleteBook(isbn);
        return ResponseEntity.ok(deletedBook);
    }

}
