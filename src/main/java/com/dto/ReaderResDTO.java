package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderResDTO {
    private String firstName;
    private String lastName;
    private int phoneNum;
    private String email;
}
