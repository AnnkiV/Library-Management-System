package com.manage.library.controller;

import com.manage.library.dto.BookDto;
import com.manage.library.dto.BookSearchRequest;
import com.manage.library.dto.LibrarianDto;
import com.manage.library.dto.RequestDto;
import com.manage.library.entity.Book;
import com.manage.library.entity.Librarian;
import com.manage.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // BOOK CRUD 

    @PostMapping("/books")
    public ResponseEntity<List<BookDto>> addBook(@RequestBody List<RequestDto> requestDto) {
    	List<BookDto> savedBook = adminService.addBook(requestDto);

    	return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {

        List<BookDto> books = adminService.getAllBooks();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
    	BookDto bookById = adminService.getBookById(bookId);
        
        if(bookById!= null) {
        	return ResponseEntity.ok(bookById);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not Available");
        
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, RequestDto requestDto) {

        Book book = adminService.updateBook(bookId, requestDto);
        
        if(book!= null) {
        	return ResponseEntity.ok(book);
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {

        adminService.deleteBook(bookId);

        return "Book deleted successfully";
  
    }
    
    @GetMapping("/search")
    public List<BookDto> searchBooks(@ModelAttribute BookSearchRequest request) {
    	 
    	 return adminService.searchBooks(request);
		
    }

    // LIBRARIAN CRUD 

    @PostMapping("/librarians")
    public ResponseEntity<LibrarianDto> addLibrarian(@RequestBody RequestDto requestDto) {

        LibrarianDto savedLibrarian = adminService.addLibrarian(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLibrarian);
    }

    @GetMapping("/librarians")
    public ResponseEntity<List<LibrarianDto>> getAllLibrarians() {

        List<LibrarianDto> librarian = adminService.getAllLibrarians();
        
        return ResponseEntity.ok(librarian);
    }

    @GetMapping("/librarians/{librarianId}")
    public ResponseEntity<?> getLibrarianById(@PathVariable Long librarianId) {

        LibrarianDto librarianById = adminService.getLibrarianById(librarianId);
        
        if(librarianById!= null) {
        	return ResponseEntity.ok(librarianById);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Librarian doesn't Exists");
    }

    @PutMapping("/librarians/{librarianId}")
    public ResponseEntity<Librarian> updateLibrarian(@PathVariable Long librarianId, RequestDto requestDto) {

        Librarian librarian = adminService.updateLibrarian(librarianId, requestDto);
        
        if(librarian!= null) {
        	return ResponseEntity.ok(librarian);
        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
    }

    @DeleteMapping("/librarians/{librarianId}")
    public String deleteLibrarian(@PathVariable Long librarianId) {

        adminService.deleteLibrarian(librarianId);

        return "Librarian deleted successfully";
    }

}
