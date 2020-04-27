package com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya;

import lombok.Getter;

@Getter
public class Book {

    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    public Book(final String author, final String title,
                final int publicationYear, final String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }



}
