package com.controller;

import com.dto.ReaderDto;
import com.entity.Reader;
import com.service.ReaderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library")
public class ReaderController {
    @Autowired
    ModelMapper modelMapper;

    ReaderService readerService;
    ReaderController(ReaderService readerService){
        super();
        this.readerService = readerService;
    }

    /**
     * Xem danh sach cua tat ca nguoi muon
     * @return
     */

    @GetMapping("/readers")
    public List<ReaderDto> getReaderList(){
        List<Reader> readerList = readerService.getReaderList();
        List<ReaderDto> readerDtoList = readerList.stream().map(reader -> modelMapper.map(reader, ReaderDto.class)).collect(Collectors.toList());
        return readerDtoList;
    }


}
