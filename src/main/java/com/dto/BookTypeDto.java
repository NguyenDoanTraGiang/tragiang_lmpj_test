package com.dto;

import com.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class BookTypeDto {
    private int typeId;
    private String typeName;
    private List<Book> books;
}
