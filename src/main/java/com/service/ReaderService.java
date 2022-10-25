package com.service;

import com.entity.Reader;
import com.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Map;

public interface ReaderService {
    List<Reader> getReaderList();
    Reader getReaderById(Integer readerId) throws ResourceNotFoundException;
    Reader createReader(Reader reader);
    Reader updateReader(Integer readerId, Reader readerDetails) throws ResourceNotFoundException;
    Map<String, Boolean> deleteReader(Integer readerId) throws ResourceNotFoundException;
}
