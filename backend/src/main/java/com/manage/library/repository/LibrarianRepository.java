package com.manage.library.repository;

import com.manage.library.entity.Librarian;  
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibrarianRepository extends JpaRepository<Librarian, Long> {

}
