package com.repository;

import com.entity.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRepository extends JpaRepository<BookType, Integer> {

}
