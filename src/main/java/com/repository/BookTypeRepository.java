package com.repository;

import com.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookTypeRepository extends JpaRepository<BookType, Integer> {
    Optional<BookType> findByTypeName(String bookTypeName);
}
