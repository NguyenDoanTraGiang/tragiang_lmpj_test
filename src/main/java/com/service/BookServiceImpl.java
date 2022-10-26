package com.service;

import com.entity.Book;
import com.repository.BookRepository;
import com.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
