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
        
        Magazine equipe = new Magazine(
            "L'Equipe",
            2024,
            50,
            "978-0-618-26025-7",
            512);

        Magazine leMonde = new Magazine(
            "Le Monde",
            2025,
            60,
            "978-0-618-26025-8",
            1056);

        ArrayList list_items = new ArrayList<Item>();
        list_items.add(fellowshipOfTheRing);
        list_items.add(equipe);
        list_items.add(leMonde);

        Library cdi = new Library("cdi", list_items);

        System.out.println(fellowshipOfTheRing.toString());

        cdi.loadBooksFromCSV("books.csv");

        cdi.displayItems();
    }
}