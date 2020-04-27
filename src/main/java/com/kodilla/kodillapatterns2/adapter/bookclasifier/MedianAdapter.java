package com.kodilla.kodillapatterns2.adapter.bookclasifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.*;

public class MedianAdapter extends MedianAdaptee implements Classifier {


    private com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book bookB;
    private BookSignature bookSignature;

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {

        Map<BookSignature, com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book> books = new HashMap<>();

        for (Book bookLibraryA : bookSet) {
            bookB = new com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb.Book(bookLibraryA.getAuthor(),bookLibraryA.getTitle(), bookLibraryA.getPublicationYear());
            bookSignature = new BookSignature(bookLibraryA.getSignature());
            books.put(bookSignature, bookB);
        }
        return medianPublicationYear(books);
    }
}
