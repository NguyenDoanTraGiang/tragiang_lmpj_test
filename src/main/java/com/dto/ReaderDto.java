package com.dto;

import com.entity.Bill;
import lombok.Data;

import java.util.List;

@Data
public class ReaderDto {
    private int readerId;
    private String firstName;
    private String lastName;
    private int phoneNum;
    private String email;
    private List<Bill> bills;
}
