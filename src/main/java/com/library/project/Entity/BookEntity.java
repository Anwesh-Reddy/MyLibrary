package com.library.project.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long isbn;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String aisle;

    @Column(name = "shelf", nullable = false)
    private int shelf;
}
