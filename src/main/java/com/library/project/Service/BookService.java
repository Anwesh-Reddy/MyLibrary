package com.library.project.Service;


import com.library.project.Entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookEntity> getBookByIsbn(Long isbn);
    List<BookEntity> getAllBooks();
    BookEntity saveBook(BookEntity bookEntity);
    BookEntity updateBook(BookEntity bookEntity, Long isbn);
    BookEntity deleteBook(Long isbn);

}
