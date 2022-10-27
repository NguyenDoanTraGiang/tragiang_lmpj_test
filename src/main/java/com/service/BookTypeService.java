package com.service;

import com.entity.BookType;
import com.exception.ResourceNotFoundException;

import java.util.List;

public interface BookTypeService {
    List<BookType> getBookTypeList();
    BookType getBookTypeById(int typeId) throws ResourceNotFoundException;
    BookType createBookType(BookType bookType);
}
