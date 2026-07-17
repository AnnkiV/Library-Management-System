package com.manage.library.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "librarian")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long librarianId;

    @Column(nullable = false)
    private String librarianName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

}
