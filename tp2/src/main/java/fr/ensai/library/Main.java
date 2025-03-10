package fr.ensai.library;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
            "The Fellowship of the Ring",
            1954,
            423,
            "978-0-618-26025-6",
            tolkien);

        ArrayList list_books = new ArrayList<Book>();
        list_books.add(fellowshipOfTheRing);

        Library cdi = new Library("cdi", list_books);

        System.out.println(fellowshipOfTheRing.toString());

        cdi.loadBooksFromCSV(null);

        cdi.displayItems();
    }
}