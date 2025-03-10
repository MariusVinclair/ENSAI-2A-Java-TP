package fr.ensai.library;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        ArrayList list_books = new ArrayList<>(fellowshipOfTheRing);

        Library cdi = new Library("cdi", list_books);

        System.out.println(fellowshipOfTheRing.toString());
    }
}