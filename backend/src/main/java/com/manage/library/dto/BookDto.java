package com.manage.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BookDto {
    
    private Long bookId;
    private String bookCode;
    private String title;
    private String author;
    private String category;
    private String language;
    private String publisher;
    private String shelfNo;
    private Integer quantity;
    private Integer availableQuantity;
    private Integer price;
}