package com.controller;

import com.service.ReaderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
