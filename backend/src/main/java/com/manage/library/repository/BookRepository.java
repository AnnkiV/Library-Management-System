package com.manage.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.manage.library.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
 

}
