package com.dto;

import com.entity.Bill;
import com.entity.BookType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private long bookId;
    private String bookName;
    private String authorName;
    private String edition;
    private boolean status;
    private List<Bill> bills;
    private BookType bookType;
}
