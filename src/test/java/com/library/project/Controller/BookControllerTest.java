package com.library.project.Controller;

import com.library.project.Entity.BookEntity;
import com.library.project.Impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookControllerTest {

    @Mock
    private BookServiceImpl bookService;

    @InjectMocks
    private BookController bookController;

    private BookEntity book;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        book = new BookEntity();
        book.setIsbn(1L);
        book.setName("Art of Not Overthinking");
        book.setAisle("A11");
        book.setShelf(4);
    }

    @Test
    void getBookByIsbn() {
        when(bookService.getBookByIsbn(1L)).thenReturn(Optional.of(book));

        ResponseEntity<BookEntity> response = bookController.getBookByIsbn(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Art of Not Overthinking", response.getBody().getName());
    }


    @Test
    void getAllBooks() {
        when(bookService.getAllBooks()).thenReturn(Arrays.asList(book));
        List<BookEntity> books = bookController.getAllBooks();
        assertEquals(1, books.size());
        assertEquals("Art of Not Overthinking", books.get(0).getName());
    }

    @Test
    void createBook() {
        when(bookService.saveBook(book)).thenReturn(book);

        ResponseEntity<BookEntity> response = bookController.createBook(book);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Art of Not Overthinking", response.getBody().getName());
    }

    @Test
    void updateBook() {
        when(bookService.updateBook(book, 1L)).thenReturn(book);

        ResponseEntity<BookEntity> response = bookController.updateBook(book, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Art of Not Overthinking", response.getBody().getName());
    }

    @Test
    void deleteBook() {
        when(bookService.deleteBook(1L)).thenReturn(book);

        ResponseEntity<BookEntity> response = bookController.deleteBook(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Art of Not Overthinking", response.getBody().getName());
    }

}