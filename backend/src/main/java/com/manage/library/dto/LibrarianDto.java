package com.manage.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibrarianDto {
	
	private Long librarianId;
    private String librarianName;
    private String email;
    private String phoneNumber;
    private String address;

}
