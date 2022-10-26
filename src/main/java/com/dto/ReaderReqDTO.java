package com.dto;

import com.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderReqDTO {
    private int readerId;
    private List<Bill> bills;
}
