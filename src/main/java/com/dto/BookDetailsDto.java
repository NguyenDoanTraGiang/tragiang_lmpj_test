package com.dto;

import com.entity.Book;
import com.entity.BookType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetailsDto {
    private long bookId;
    private String bookName;
    private String authorName;
    private String edition;
    private boolean status;
    private String bookTypeName;
}
