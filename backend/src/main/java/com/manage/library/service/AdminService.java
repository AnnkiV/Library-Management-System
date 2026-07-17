package com.manage.library.service;

import com.manage.library.dto.BookDto;
import com.manage.library.dto.BookSearchRequest;
import com.manage.library.dto.LibrarianDto;
import com.manage.library.dto.RequestDto;
import com.manage.library.entity.Book; 
import com.manage.library.entity.Librarian;
import com.manage.library.exception.ResourceNotFoundException;
import com.manage.library.repository.BookRepository;
import com.manage.library.repository.LibrarianRepository;
import com.manage.library.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    // BOOK CRUD 

    public List<BookDto> addBook(List<RequestDto> requestDto) {
    	
    	List<Book> books = requestDto.stream().map(dto -> {
    		Book book = new Book();
    		book.setBookCode(dto.getBookCode());
            book.setTitle(dto.getTitle());
            book.setAuthor(dto.getAuthor());
            book.setCategory(dto.getCategory());
            book.setLanguage(dto.getLanguage());
            book.setPublisher(dto.getPublisher());
            book.setShelfNo(dto.getShelfNo());
            book.setQuantity(dto.getQuantity());
            book.setAvailableQuantity(dto.getAvailableQuantity());
            book.setPrice(dto.getPrice());
             return book;
    	})
    			.toList();
    	
		
    	 // Save all books
        List<Book> savedBooks = bookRepository.saveAll(books);

        // Convert Entity -> DTO
        return savedBooks.stream()
                .map(book -> new BookDto(
                        book.getBookId(),
                        book.getBookCode(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getCategory(),
                        book.getLanguage(),
                        book.getPublisher(),
                        book.getShelfNo(),
                        book.getQuantity(),
                        book.getAvailableQuantity(),
                        book.getPrice()
                ))
                .toList();

       
    }

    
    public List<BookDto> getAllBooks() {
    	List<Book> books = bookRepository.findAll();
    	
        return books.stream()
        .map(book -> new BookDto(
                book.getBookId(),
                book.getBookCode(),
                book.getTitle(),
                null, 
                null,
                null,
                null,
                book.getShelfNo(),
                null,
                book.getAvailableQuantity(),
                book.getPrice()
                
        ))
        .toList();
    }
    

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        
        return new BookDto(
                book.getBookId(),
                book.getBookCode(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getLanguage(),
                book.getPublisher(),
                book.getShelfNo(),
                book.getQuantity(),
                book.getAvailableQuantity(),
                book.getPrice()
            
        );
    }

    
    public Book updateBook(Long bookId, RequestDto requestDto) {

    	Book existingBook = bookRepository.findById(bookId).orElseThrow(null);

        if (existingBook != null) {

            existingBook.setBookCode(requestDto.getBookCode());
            existingBook.setTitle(requestDto.getTitle());
            existingBook.setAuthor(requestDto.getAuthor());
            existingBook.setCategory(requestDto.getCategory());
            existingBook.setLanguage(requestDto.getLanguage());
            existingBook.setPublisher(requestDto.getPublisher());
            existingBook.setShelfNo(requestDto.getShelfNo());
            existingBook.setQuantity(requestDto.getQuantity());
            existingBook.setAvailableQuantity(requestDto.getAvailableQuantity());
            existingBook.setPrice(requestDto.getPrice());

            return bookRepository.save(existingBook);
        }

        return null;
    }

    
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    
    public List<BookDto> searchBooks(BookSearchRequest request){
    	System.out.println("Inside searchBooks");
    	Specification<Book> spec = Specification.where(null);
    	
    	spec = spec.and(BookSpecification.hasBookId(request.getBookId()))
    			.and(BookSpecification.hasBookCode(request.getBookCode()))
    	        .and(BookSpecification.hasTitle(request.getTitle()))
    	        .and(BookSpecification.hasAuthor(request.getAuthor()))
    	        .and(BookSpecification.hasCategory(request.getCategory()))
    	        .and(BookSpecification.hasLanguage(request.getLanguage()))
    	        .and(BookSpecification.hasPublisher(request.getPublisher()))
    	        .and(BookSpecification.hasShelfNo(request.getShelfNo()))
    	        .and(BookSpecification.hasQuantity(request.getQuantity()))
    	        .and(BookSpecification.hasAvailableQuantity(request.getAvailableQuantity()));
    	        //.and(BookSpecification.hasPrice(request.getPrice()));

    	return bookRepository.findAll(spec).stream().map(this::convertToDto).toList();
    	
    }
    

	private BookDto convertToDto(Book book) {
        return new BookDto(
                book.getBookId(),
                book.getBookCode(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getLanguage(),
                book.getPublisher(),
                book.getShelfNo(),
                book.getQuantity(),
                book.getAvailableQuantity(),
                book.getPrice()
        );
    }
    
    
    // LIBRARIAN CRUD 

    public LibrarianDto addLibrarian(RequestDto requestDto) {
    	
    	Librarian librarian = new Librarian();
		librarian.setLibrarianName(requestDto.getLibrarianName());
		librarian.setEmail(requestDto.getEmail());
		librarian.setPhoneNumber(requestDto.getPhoneNumber());
		librarian.setAddress(requestDto.getAddress());

        return null;
        
    }

    public List<LibrarianDto> getAllLibrarians() {
    	List<Librarian> librarians = librarianRepository.findAll();
    	
        return librarians.stream()
        .map(librarian -> new LibrarianDto(
                librarian.getLibrarianId(),
                librarian.getLibrarianName(),
                null,
                librarian.getPhoneNumber(),
                null
        ))
        .toList();
         
    }
    

    public LibrarianDto getLibrarianById(Long librarianId) {
        Librarian librarian = librarianRepository.findById(librarianId)
        		.orElseThrow(() -> new ResourceNotFoundException("Librarian not found with id: " + librarianId));
        
        return new LibrarianDto(
        		librarian.getLibrarianId(),
                librarian.getLibrarianName(),
                librarian.getEmail(),
                librarian.getPhoneNumber(),
                librarian.getAddress()
        );
    }
    
    public Librarian updateLibrarian(Long librarianId, RequestDto requestDto) {

        Librarian existingLibrarian =
                librarianRepository.findById(librarianId).orElse(null);

        if (existingLibrarian != null) {

            existingLibrarian.setLibrarianName(requestDto.getLibrarianName());
            existingLibrarian.setEmail(requestDto.getEmail());
            existingLibrarian.setPhoneNumber(requestDto.getPhoneNumber());
            existingLibrarian.setAddress(requestDto.getAddress());

            return librarianRepository.save(existingLibrarian);
        }

        return null;
    }

    public void deleteLibrarian(Long librarianId) {
        librarianRepository.deleteById(librarianId);
    }


}
