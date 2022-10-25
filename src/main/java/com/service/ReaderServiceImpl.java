package com.service;

import com.entity.Reader;
import com.exception.ResourceNotFoundException;
import com.repository.ReaderRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderServiceImpl implements ReaderService{
    private ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository){
        super();
        this.readerRepository = readerRepository;
    }

    @Override
    public List<Reader> getReaderList() {
        return readerRepository.findAll();
    }

    @Override
    public Reader getReaderById(Integer readerId) throws ResourceNotFoundException {
        Reader reader = readerRepository.findById(readerId).orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: " + readerId));
        return reader;
    }

    @Override
    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public Reader updateReader(Integer readerId, Reader readerDetails) throws ResourceNotFoundException {
        Reader reader = readerRepository.findById(readerId).orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: + readerId"));
        reader.setFirstName(readerDetails.getFirstName());
        reader.setLastName(readerDetails.getLastName());
        reader.setEmail(readerDetails.getEmail());
        reader.setPhoneNum(readerDetails.getPhoneNum());

        final Reader updateReader = readerRepository.save(reader);
        return updateReader;
    }

    @Override
    public Map<String, Boolean> deleteReader(Integer readerId) throws ResourceNotFoundException {
        Reader reader = readerRepository.findById(readerId).orElseThrow(() -> new ResourceNotFoundException("Reader not found by this id: + readerId"));
        readerRepository.delete(reader);
        Map<String, Boolean> response = new HashMap<>();
        response.put("reader deleted", Boolean.TRUE);
        return response;
    }
}
