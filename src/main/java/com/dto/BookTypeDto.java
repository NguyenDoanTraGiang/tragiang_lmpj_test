package com.dto;

import com.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTypeDto {
    private int typeId;
    private String typeName;
    private List<Book> books;
}
