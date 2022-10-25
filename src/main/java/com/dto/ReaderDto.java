package com.dto;

import lombok.Data;

@Data
public class ReaderDto {
    private int readerId;
    private String firstName;
    private String lastName;
    private int phoneNum;
    private String email;
}
