package com.repository;

import com.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll();

    @Query(value = "SELECT book.book_id, book.book_name, book.author_name, book.edition, book.status, book_type.type_name as bookTypeName" +
            "FROM book JOIN book_type ON book.book_type_id = book_type.type_id", nativeQuery = true)
    List<Book> getBookList();

    /*@Modifying
    @Transactional
    @Query(value="INSERT INTO book(book_name, author_name, edition, status, book_type_id) VALUES (:name, :author, :edition, :status, :book_type_id)", nativeQuery = true)
    void createBook(
            @Param("name") String bookName,
            @Param("author") String authorName,
            @Param("edition") String edition,
            @Param("status") boolean status,
            @Param("book_type_id") int bookTypeId);

     */

    Book getBookById(Long id);
}
