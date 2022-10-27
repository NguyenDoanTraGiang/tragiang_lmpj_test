package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Builder
public class Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="book_name", nullable = false, length=100)
    private String bookName;

    @Column(name="author_name", nullable = false, length=100)
    private String authorName;

    @Column(name="edition", length = 5)
    private String edition;

    @Column(name="status", nullable = false)
    private boolean status;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "book")
    private List<Bill> bills;

    @ManyToOne
    @JoinColumn(name = "book_type_id", nullable = false,  insertable = false, updatable = false)
    private BookType bookType;

}
