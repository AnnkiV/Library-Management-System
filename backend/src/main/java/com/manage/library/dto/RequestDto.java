package com.manage.library.dto;

import java.time.LocalDate;

import com.manage.library.entity.Book;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
	
	//Book
	private Long bookId;
	
	@NotBlank(message = "Book Code is needed")
	private String BookCode;
	
	@NotBlank(message = "Title cannot be blank")
	private String title;
	
	public String Author;
	
	public String Category;
	
	private String Language;
	
	private String Publisher;
	
	private String ShelfNo;
	
	@NotNull
	@Max(100)
	private Integer quantity;
	
	@Min(1)
	private Integer availableQuantity;
	
	@NotNull
	private Integer price;
	
	//Librarian
	private Long librarianId;
	
	@NotBlank(message= "Name can't be blank")
	private String librarianName;
	
	@Email(message = "Invalid Email Format")
	private String email;
	
	@NotNull
	@Pattern(regexp="^[0-9]{10}$", message="Phone must contain exactly 10 digits")
	private String phoneNumber;
	
	private String address;
	
	//Issue Book
	private Long issueId;
	
	@NotBlank(message = "Name cannot be blank")
	private String userName;
	
	@NotNull
	@Pattern(regexp="^[0-9]{10}$", message="Phone must contain exactly 10 digits")
	private String number;
	
	private LocalDate issueDate;
	
	private LocalDate returnDate;
	
    private Book book;

	



}
