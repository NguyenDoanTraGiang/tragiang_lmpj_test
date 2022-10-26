package com.service;

import com.entity.Book;
import com.repository.BookRepository;
import org.springframework.stereotype.Service;

public interface BookService {
    Book getBookInfo(Long bookId);
    Book getBookById(Long bookId);
}
