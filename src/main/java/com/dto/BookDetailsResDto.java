package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetailsResDto {
    private long bookId;
    private String bookName;
    private String authorName;
    private String edition;
    private boolean status;
    private String bookTypeName;
}
