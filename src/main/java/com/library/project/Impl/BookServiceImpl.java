package com.library.project.Impl;

import com.library.project.Entity.BookEntity;
import com.library.project.Repository.BookRepository;
import com.library.project.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
