package com.dto;

import com.entity.Book;
import com.entity.Reader;
import lombok.Data;

import java.util.Date;

@Data
public class BillDto {
    private long billId;
    private Date borrowDate;
    private Date returnDate;
    private Book book;
    private Reader reader;
}
