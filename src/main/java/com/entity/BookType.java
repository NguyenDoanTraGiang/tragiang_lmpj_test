package com.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="book_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    @Column(name="type_name", nullable = false, length = 30)
    private String typeName;
}
