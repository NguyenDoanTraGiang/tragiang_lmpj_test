package com.controller;

import com.dto.ReaderDto;
import com.entity.Reader;
import com.exception.ResourceNotFoundException;
import com.service.ReaderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Xem chi tiet mot nguoi dung bang id
     * @param readerId
     * @return
     * @throws ResourceNotFoundException
     */
    @GetMapping("/readers/{readerId}")
    public ResponseEntity getReaderById(@PathVariable(name="readerId") Integer readerId) throws ResourceNotFoundException {
        Reader reader = readerService.getReaderById(readerId);
        ReaderDto response = modelMapper.map(reader, ReaderDto.class);
        return ResponseEntity.ok().body(response);

    }
}
