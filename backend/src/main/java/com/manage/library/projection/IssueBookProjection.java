package com.manage.library.projection;

import java.time.LocalDate;

public interface IssueBookProjection {

    Long getIssueId();

    String getUserName();

    LocalDate getIssueDate();

    LocalDate getReturnDate();

    BookProjection getBook();
}
