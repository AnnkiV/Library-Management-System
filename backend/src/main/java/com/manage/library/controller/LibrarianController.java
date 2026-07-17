package com.manage.library.controller;

import com.manage.library.dto.BookDto;
import com.manage.library.dto.IssueDto;
import com.manage.library.dto.RequestDto;
import com.manage.library.entity.IssuedRecord;
import com.manage.library.projection.IssueBookProjection;
import com.manage.library.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private IssueService issueService;

    //ISSUE BOOK 

    @PostMapping("/issue")
    public ResponseEntity<?> issueBook(@RequestBody RequestDto requestDto) {
    	
        IssueDto issue = issueService.issueBook(requestDto);
        
        if(issue!= null) {
        	return ResponseEntity.status(HttpStatus.CREATED).body(issue);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book not available for issue");
    }
    
    

    @GetMapping("/issued-books")
    public List<IssueBookProjection> getAllIssuedBooks() {
        return issueService.getAllIssuedBooks();
    }
    


    @DeleteMapping("/return/{issueId}")
    public ResponseEntity<String> returnBook(@PathVariable Long issueId) {

        IssuedRecord issueRecord = issueService.returnBook(issueId);
        
        if(issueRecord!= null) {
        	return ResponseEntity.ok("Book returned successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Issued record not found");
    }

}
