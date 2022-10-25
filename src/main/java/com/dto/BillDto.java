package com.dto;

import com.entity.Book;
import com.entity.Reader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {
    private long billId;
    private Date borrowDate;
    private Date returnDate;
    private Book book;
    private Reader reader;
}
