package com.service;

import com.entity.Book;
import com.repository.BookRepository;
import com.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookInfo(Long bookId){
        return bookRepository.getBookInfo(bookId);
    }

    @Override
    public Book getBookById(Long bookId){
        return bookRepository.getBookById(bookId);
    }

    @Override
    public List<Book> getBookList(){
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(long bookId, Book bookDetails) {
        Book book = bookRepository.getBookById(bookId);
        book.setBookName(bookDetails.getBookName());
        book.setAuthorName(bookDetails.getAuthorName());
        book.setEdition(bookDetails.getEdition());
        book.setStatus(bookDetails.isStatus());
        book.setBookType(bookDetails.getBookType());
        final Book updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    @Override
    public Map<String, Boolean> deleteBook(long bookId) {
        Book book = bookRepository.getBookById(bookId);
        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("book deleted", true);
        return response;
    }
}
