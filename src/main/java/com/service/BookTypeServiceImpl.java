package com.service;

import com.entity.BookType;
import com.exception.ResourceNotFoundException;
import com.repository.BookTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeServiceImpl implements BookTypeService{
    final private BookTypeRepository bookTypeRepository;
    public BookTypeServiceImpl(BookTypeRepository bookTypeRepository){
        super();
        this.bookTypeRepository = bookTypeRepository;
    }

    @Override
    public List<BookType> getBookTypeList() {
        return bookTypeRepository.findAll();
    }

    @Override
    public BookType getBookTypeById(int typeId) throws ResourceNotFoundException {
        return bookTypeRepository.findById(typeId).orElseThrow(() -> new ResourceNotFoundException("Book type not found by this id: " + typeId));
    }

    @Override
    public BookType createBookType(BookType bookType) {
        return bookTypeRepository.save(bookType);
    }

    @Override
    public BookType findByTypeName(String bookTypeName) {
        if(bookTypeRepository.findByTypeName(bookTypeName).isPresent()) {
            return bookTypeRepository.findByTypeName(bookTypeName).get();
        }
        bookTypeRepository.save(new BookType(bookTypeName));
        return new BookType(bookTypeName);
    }
}
