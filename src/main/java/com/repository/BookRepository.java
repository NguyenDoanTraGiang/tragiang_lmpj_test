package com.repository;

import com.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll();

    @Query(value = "SELECT book.book_id, book.book_name, book.author_name, book.edition, book.status, book_type.type_name as bookTypeName" +
            "FROM book LEFT JOIN book_type ON book.book_type_id = book_type.type_id", nativeQuery = true)
    Book getBookInfo(Long id);

    Book getBookById(Long id);
}
