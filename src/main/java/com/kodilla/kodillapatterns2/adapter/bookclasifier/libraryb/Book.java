package com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb;

import lombok.Getter;

@Getter
public class Book {

    private final String author;
    private final String title;
    private final int yearOfPublication;

    public Book(String author, String title, int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }
}
