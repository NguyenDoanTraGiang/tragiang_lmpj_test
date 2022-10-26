package com.controller;

import com.dto.BookDto;
import com.entity.Book;
import com.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library")

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
    @GetMapping("/books")
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
    @GetMapping("/books/{bookId}")
    public Book getBookInfo(@PathVariable(name="bookId")Long bookId){
        Book bookInfo = bookService.getBookById(bookId);
        return bookInfo;
    }

    /**
     * Tao sach moi
     * @param bookDto
     * @return ResponseEntity<BookDto>
     */
    @PostMapping("/books")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        Book createdBook = bookService.createBook(book);
        BookDto response = modelMapper.map(createdBook, BookDto.class);
        return new ResponseEntity<BookDto>(response, HttpStatus.CREATED);
    }

    /**
     * Chinh sua sach
     * @param bookId
     * @param bookDto
     * @return ResponseEntity.ok().body(BookDto)
     */

    @PutMapping("/books/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable(name="bookId") long bookId, @RequestBody BookDto bookDto){
        Book bookRequest = modelMapper.map(bookDto, Book.class);
        Book updatedBook = bookService.updateBook(bookId, bookRequest);
        BookDto bookResponse = modelMapper.map(updatedBook, BookDto.class);
        return ResponseEntity.ok().body(bookResponse);
    }

    /**
     * Xoa sach
     * @param bookId
     * @return Map<String, Boolean> response
     */
    @DeleteMapping("/books/{bookId}")
    public Map<String, Boolean> deleteBook(@PathVariable(name="bookId") long bookId){
        return bookService.deleteBook(bookId);
    }
}
