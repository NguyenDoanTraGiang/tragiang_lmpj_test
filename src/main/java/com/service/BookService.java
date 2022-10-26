package com.service;

import com.entity.Book;
import com.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BookService {
    Book getBookInfo(Long bookId);
    Book getBookById(Long bookId);
    List<Book> getBookList();
    Book createBook(Book book);
    Book updateBook(long bookId, Book bookDetails);
    Map<String, Boolean> deleteBook(long bookId);
}
