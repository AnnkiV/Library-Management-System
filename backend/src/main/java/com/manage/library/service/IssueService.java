package com.manage.library.service;

import com.manage.library.dto.IssueDto;
import com.manage.library.dto.RequestDto;
import com.manage.library.entity.Book;
import com.manage.library.entity.IssuedRecord;
import com.manage.library.projection.IssueBookProjection;
import com.manage.library.repository.BookRepository;
import com.manage.library.repository.IssueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private BookRepository bookRepository;

    // ISSUE BOOK 

    public IssueDto issueBook(RequestDto requestDto) {

        Book book = bookRepository.findById (( requestDto).getBook().getBookId()) .orElse(null);

        if (book != null && book.getAvailableQuantity() > 1) {

            book.setAvailableQuantity(requestDto.getAvailableQuantity() - 1);

            bookRepository.save(book);

            (requestDto).setBook(book);

            return issueRepository.save(requestDto);
        }

        return null;
    }
    


    // VIEW ALL ISSUED BOOKS 

    public List<IssueBookProjection> getAllIssuedBooks() {
        return issueRepository.findAllBy();
    }
    

    // RETURN BOOK 

    public IssuedRecord returnBook(Long issueId) {

        IssuedRecord issuedRecord =
                issueRepository.findById(issueId).orElse(null);

        if (issuedRecord != null) {

            Book book = issuedRecord.getBook();

            book.setAvailableQuantity(book.getAvailableQuantity() + 1);

            bookRepository.save(book);

            issueRepository.delete(issuedRecord);
        }

        return issuedRecord;
    }

}