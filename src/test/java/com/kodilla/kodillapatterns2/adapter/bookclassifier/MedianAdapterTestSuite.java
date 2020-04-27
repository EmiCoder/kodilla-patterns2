package com.kodilla.kodillapatterns2.adapter.bookclassifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdaptee;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        Book book1 = new Book ("Author_1", "Title_1", 1985, "Book_1");
        Book book2 = new Book ("Author_2", "Title_2", 1986, "Book_2");
        Book book3 = new Book ("Author_3", "Title_3", 1987, "Book_3");

        Set<Book> booksLibraryA = new HashSet<>();
        booksLibraryA.add(book1);
        booksLibraryA.add(book2);
        booksLibraryA.add(book3);

        MedianAdapter libraryAdapter = new MedianAdapter();
        int publicationYearMedian = libraryAdapter.publicationYearMedian(booksLibraryA);
        assertEquals(1986, publicationYearMedian);
    }
}
