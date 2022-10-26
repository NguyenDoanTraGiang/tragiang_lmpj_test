package com.controller;

import com.dto.BookDto;
import com.entity.Book;
import com.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")

public class BookController {
    @Autowired
    private ModelMapper modelMapper;

    private BookService bookService;
    public BookController(BookService bookService){
        super();
        this.bookService = bookService;
    }

    /**
     * Xem danh sach cua tat ca book
     * @return List<BookDto>
     */
    @GetMapping("/")
    public List<BookDto> getBookList(){
        List<Book> bookList = bookService.getBookList();
        List<BookDto> bookDtoList = bookList.stream().map(book -> modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    /**
     * Xem chi tiet mot cuon sach cu the
     * @param bookId
     * @return Book bookInfo
     */
    @GetMapping("/full-info/{bookId}")
    public Book getBookInfo(@PathVariable(name="bookId")Long bookId){
        Book bookInfo = bookService.getBookById(bookId);
        return bookInfo;
    }
}
