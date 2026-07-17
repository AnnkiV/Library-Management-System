package com.manage.library.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.manage.library.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "issueId",
    "userName",
    "issueDate",
    "returnDate",
    "book"
})
public class IssueDto {
	
	private Long issueId;
    private String userName;
    private String number;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private Long bookId;
    private String title;

}
