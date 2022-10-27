package com.controller;

import com.dto.BookDetailsReqDto;
import com.dto.BookDetailsResDto;
import com.dto.BookDto;
import com.entity.Book;
import com.entity.BookType;
import com.exception.ResourceNotFoundException;
import com.repository.BookTypeRepository;
import com.service.BookService;
import com.service.BookTypeService;
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

    @Autowired
    private BookTypeService bookTypeService;

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
    public List<BookDetailsResDto> getBookList(){
        List<Book> bookList = bookService.getBookList();
        return bookList.stream().map(book -> {
            return BookDetailsResDto
                    .builder()
                    .bookName(book.getBookName())
                    .authorName(book.getAuthorName())
                    .edition(book.getEdition())
                    .status(book.isStatus())
                    .bookId(book.getId())
                    .bookTypeName(book.getBookType().getTypeName())
                    .build();
        }).collect(Collectors.toList());
    }

    /**
     * Xem chi tiet mot cuon sach cu the
     * @param bookId
     * @return Book bookInfo
     */
    @GetMapping("/books/{bookId}")
    public BookDetailsResDto getBookById(@PathVariable(name="bookId")Long bookId){
        Book book = bookService.getBookById(bookId);
        BookDetailsResDto bookDetailsDto = BookDetailsResDto
                .builder()
                .bookName(book.getBookName())
                .authorName(book.getAuthorName())
                .edition(book.getEdition())
                .status(book.isStatus())
                .bookId(book.getId())
                .bookTypeName(book.getBookType().getTypeName())
                .build();
        return bookDetailsDto;
    }

    /**
     * Tao sach moi
     * @param bookDetailsReqDto
     * @return ResponseEntity<BookDto>
     */
    @PostMapping("/books")
    public ResponseEntity<BookDetailsResDto> createBook(@RequestBody BookDetailsReqDto bookDetailsReqDto) {
       /* bookService.createBook(
                bookDetailsReqDto.getBookName(),
                bookDetailsReqDto.getAuthorName(),
                bookDetailsReqDto.getEdition(),
                bookDetailsReqDto.isStatus(),
                bookDetailsReqDto.getBookTypeId()
        );*/
        BookType bookType = bookTypeService.findByTypeName(bookDetailsReqDto.getBookTypeName());
        // map BookDetailsReqDto to Book
        Book book = Book
                .builder()
                .bookName(bookDetailsReqDto.getBookName())
                .authorName(bookDetailsReqDto.getAuthorName())
                .edition(bookDetailsReqDto.getEdition())
                .status(bookDetailsReqDto.isStatus())
                .bookType(bookType)
                .build();

        Book createdBook = bookService.createBook(book);

        // map createdBook to BookDetailsResDto
        BookDetailsResDto response = BookDetailsResDto
                .builder()
                .bookName(createdBook.getBookName())
                .authorName(createdBook.getAuthorName())
                .edition(createdBook.getEdition())
                .status(createdBook.isStatus())
                .bookTypeName(createdBook.getBookType().getTypeName())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Chinh sua sach
     * @param bookId
     * @param bookDetailsReqDto
     * @return ResponseEntity.ok().body(BookDto)
     */

    /*@PutMapping("/books/{bookId}")
    public ResponseEntity<BookDetailsResDto> updateBook(@PathVariable(name="bookId") long bookId, @RequestBody BookDetailsReqDto bookDetailsReqDto)
            throws ResourceNotFoundException {

        Book bookRequest = Book
                .builder()
                .bookName(bookDetailsReqDto.getBookName())
                .authorName(bookDetailsReqDto.getAuthorName())
                .edition(bookDetailsReqDto.getEdition())
                .status(bookDetailsReqDto.isStatus())
                .bookType(bookTypeService.getBookTypeById(bookDetailsReqDto.getBookTypeId())) // search BookType by ID
                .build();

        Book updatedBook = bookService.updateBook(bookId, bookRequest);

        BookDetailsResDto bookResponse = BookDetailsResDto
                .builder()
                .bookId(updatedBook.getId())
                .bookName(updatedBook.getBookName())
                .authorName(updatedBook.getAuthorName())
                .edition(updatedBook.getEdition())
                .status(updatedBook.isStatus())
                .bookTypeName(updatedBook.getBookType().getTypeName())
                .build();
        return ResponseEntity.ok().body(bookResponse);
    }*/

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
