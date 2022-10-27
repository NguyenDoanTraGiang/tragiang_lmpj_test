package com.service;

import com.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    Book getBookById(Long bookId);
    List<Book> getBookList();
    Book createBook(Book book);
    //void createBook(String bookName, String authorName, String edition, boolean status, int bookTypeId);
    Book updateBook(long bookId, Book bookDetails);
    Map<String, Boolean> deleteBook(long bookId);
}
