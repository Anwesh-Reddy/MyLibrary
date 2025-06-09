package com.library.project.Impl;

import com.library.project.Entity.BookEntity;
import com.library.project.Repository.BookRepository;
import com.library.project.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<BookEntity> getBookByIsbn(Long isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public BookEntity saveBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }
    @Override
    public BookEntity updateBook(BookEntity bookEntity, Long isbn) {
        Optional<BookEntity> existingBookOptional = bookRepository.findById(isbn);

        if (existingBookOptional.isPresent()) {
            BookEntity existingBook = existingBookOptional.get();
            existingBook.setName(bookEntity.getName());
            existingBook.setAisle(bookEntity.getAisle());
            existingBook.setShelf(bookEntity.getShelf());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    @Override
    public BookEntity deleteBook(Long isbn) {
        Optional<BookEntity> bookOptional = bookRepository.findById(isbn);

        if (bookOptional.isPresent()) {
        BookEntity book = bookOptional.get();
        bookRepository.deleteById(isbn);
        return book;
        }
        return null;
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }
}
