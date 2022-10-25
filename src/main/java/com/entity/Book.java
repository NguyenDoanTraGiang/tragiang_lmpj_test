package com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @Column(name="book_name", nullable = false, length=100)
    private String bookName;

    @Column(name="author_name", nullable = false, length=100)
    private String authorName;

    @Column(name="edition", length = 5)
    private String edition;

    @Column(name="status", nullable = false)
    private boolean status;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "book")
    private List<Bill> bills;


}
