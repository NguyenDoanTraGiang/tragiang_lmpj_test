package com.controller;

import com.dto.ReaderDto;
import com.entity.Reader;
import com.exception.ResourceNotFoundException;
import com.service.ReaderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library")
public class ReaderController {
    @Autowired
    private ModelMapper modelMapper;

    private ReaderService readerService;
    public ReaderController(ReaderService readerService){
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

    /**
     * Tao nguoi muon moi
     * @param readerDto
     * @return
     */

    @PostMapping("/readers")
    public ResponseEntity<ReaderDto> createReader(@RequestBody ReaderDto readerDto){
        Reader readerRequests = modelMapper.map(readerDto, Reader.class);
        Reader reader = readerService.createReader(readerRequests);
        ReaderDto readerResponse = modelMapper.map(reader, ReaderDto.class);
        return new ResponseEntity<ReaderDto>(readerResponse, HttpStatus.CREATED);
    }

    /**
     * Chinh sua thong tin nguoi muon
     * @param readerId
     * @param readerDto
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/readers/{readerId}")
    public ResponseEntity<ReaderDto> updateReader(@PathVariable(name="readerId") Integer readerId, @RequestBody ReaderDto readerDto)
            throws ResourceNotFoundException{
            Reader readerRequest = modelMapper.map(readerDto, Reader.class);
            Reader updatedReader = readerService.updateReader(readerId, readerRequest);

            ReaderDto readerResponse = modelMapper.map(updatedReader, ReaderDto.class);
            return ResponseEntity.ok().body(readerResponse);
    }

    /**
     * Xoa nguoi muon
     * @param readerId
     * @return
     * @throws ResourceNotFoundException
     */
    @DeleteMapping("/readers/{readerId}")
    public Map<String, Boolean> deleteReader(@PathVariable(name="readerId") Integer readerId) throws ResourceNotFoundException{
        return readerService.deleteReader(readerId);
    }
}
