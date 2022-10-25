package com.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billId;

    @Column(name="borrow_date", nullable = false)
    @CreatedDate
    private Date borrowDate;

    @Column(name="return_date", nullable = false)
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;
}
