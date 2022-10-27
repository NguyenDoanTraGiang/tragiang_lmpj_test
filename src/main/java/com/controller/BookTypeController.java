package com.controller;

import com.dto.BookTypeDto;
import com.entity.BookType;
import com.exception.ResourceNotFoundException;
import com.service.BookTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library/book-types")
public class BookTypeController {
    @Autowired
    ModelMapper modelMapper;

    private final BookTypeService bookTypeService;
    public BookTypeController(BookTypeService bookTypeService){
        super();
        this.bookTypeService = bookTypeService;
    }

    /**
     * Xem danh sach loai sach
     * @return List<BookType>
     */
    @GetMapping()
    public List<BookType> getBookTypeList(){
        return bookTypeService.getBookTypeList();
    }

    /**
     * Xem thong tin loai sach
     * @param typeId
     * @return BookTypeDto
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{typeId}")
    public BookTypeDto getBookTypeById(@PathVariable(name="typeId") int typeId) throws ResourceNotFoundException {
        BookType bookType = bookTypeService.getBookTypeById(typeId);
        return modelMapper.map(bookType, BookTypeDto.class);
    }

    /**
     * Them loai sach moi
     * @param bookTypeDto
     * @return ResponseEntity
     */
    @PostMapping()
    public ResponseEntity<BookTypeDto> createBookType(@RequestBody BookTypeDto bookTypeDto){
        BookType bookRequest = modelMapper.map(bookTypeDto, BookType.class);
        BookType createdBookType = bookTypeService.createBookType(bookRequest);
        BookTypeDto bookResponse = modelMapper.map(bookRequest, BookTypeDto.class);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }
}
