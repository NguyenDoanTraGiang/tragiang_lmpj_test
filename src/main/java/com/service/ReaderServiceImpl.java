package com.service;

import com.entity.Reader;
import com.exception.ResourceNotFoundException;
import com.repository.ReaderRepository;

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
        return null;
    }

    @Override
    public Reader getReaderById(Integer readerId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Reader createReader(Reader reader) {
        return null;
    }

    @Override
    public Reader updateReader(Integer readerId, Reader readerDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteReader(Integer readerId) throws ResourceNotFoundException {
        return null;
    }
}
