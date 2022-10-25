package com.dto;

import com.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {
    private int readerId;
    private String firstName;
    private String lastName;
    private int phoneNum;
    private String email;
    private List<Bill> bills;
}
