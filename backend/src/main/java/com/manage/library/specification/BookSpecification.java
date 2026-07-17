package com.manage.library.specification;

import org.springframework.data.jpa.domain.Specification;

import com.manage.library.entity.Book;

public class BookSpecification {

    public static Specification<Book> hasBookId(Long bookId) {
        return (root, query, cb) ->
                bookId == null
                        ? null
                        : cb.equal(root.get("bookId"), bookId);
    }

    public static Specification<Book> hasBookCode(String bookCode) {
        return (root, query, cb) ->
                bookCode == null || bookCode.isBlank()
                        ? null
                        : cb.equal(cb.lower(root.get("bookCode")), bookCode.toLowerCase());
    }

    public static Specification<Book> hasTitle(String title) {
        return (root, query, cb) ->
                title == null || title.isBlank()
                        ? null
                        : cb.like(cb.lower(root.get("title")),
                                  "%" + title.toLowerCase() + "%");
    }

    public static Specification<Book> hasAuthor(String author) {
        return (root, query, cb) ->
                author == null || author.isBlank()
                        ? null
                        : cb.like(cb.lower(root.get("author")),
                                  "%" + author.toLowerCase() + "%");
    }

    public static Specification<Book> hasCategory(String category) {
        return (root, query, cb) ->
                category == null || category.isBlank()
                        ? null
                        : cb.equal(cb.lower(root.get("category")),
                                   category.toLowerCase());
    }

    public static Specification<Book> hasLanguage(String language) {
        return (root, query, cb) ->
                language == null || language.isBlank()
                        ? null
                        : cb.equal(cb.lower(root.get("language")),
                                   language.toLowerCase());
    }

    public static Specification<Book> hasPublisher(String publisher) {
        return (root, query, cb) ->
                publisher == null || publisher.isBlank()
                        ? null
                        : cb.like(cb.lower(root.get("publisher")),
                                  "%" + publisher.toLowerCase() + "%");
    }

    public static Specification<Book> hasShelfNo(String shelfNo) {
        return (root, query, cb) ->
                shelfNo == null || shelfNo.isBlank()
                        ? null
                        : cb.equal(cb.lower(root.get("shelfNo")),
                                   shelfNo.toLowerCase());
    }

    public static Specification<Book> hasQuantity(Integer quantity) {
        return (root, query, cb) ->
                quantity == null
                        ? null
                        : cb.equal(root.get("quantity"), quantity);
    }

    public static Specification<Book> hasAvailableQuantity(Integer availableQuantity) {
        return (root, query, cb) ->
                availableQuantity == null
                        ? null
                        : cb.equal(root.get("availableQuantity"), availableQuantity);
    }
    
    public static Specification<Book> hasPrice(Integer price) {
        return (root, query, cb) ->
                price == null 
                        ? null
                        : cb.equal(root.get("price"), price);
    }

}
