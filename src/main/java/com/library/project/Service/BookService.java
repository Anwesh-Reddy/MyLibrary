package com.library.project.Service;


import com.library.project.Entity.BookEntity;
import java.util.Optional;

public interface BookService {
    Optional<BookEntity> getBookByIsbn(Long isbn);
}
