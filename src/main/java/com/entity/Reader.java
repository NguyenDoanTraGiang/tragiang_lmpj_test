package com.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "reader")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int readerId;

    @Column(name="first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name="phone_no", nullable = false)
    private int phoneNum;

    @Column(name="email")
    private String email;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "reader")
    private List<Bill> bills;
}
