package com.manage.library.entity;

import jakarta.persistence.*; 
import lombok.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    
    @Column(nullable = false)
    private String BookCode;

    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String category;
    
    @Column(nullable = false)
    private String language;
    
    @Column(nullable = false)
    private String publisher;
    
    @Column(nullable = false)
    private String shelfNo;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer availableQuantity;
    
    @Column(nullable = false)
    private Integer price;
    

}
