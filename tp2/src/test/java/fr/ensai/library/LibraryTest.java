package fr.ensai.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    void findActiveLoanForItem_ItemIsLoaned() {
        // GIVEN
        ArrayList<Loan> emptyLoans = new ArrayList<>();
        Library library = new Library("Test Library", null, emptyLoans, null);
        Book book1 = new Book("Book 1", 2008, 320, "978-0321765723", new Author("Author 1", 0, ""));
        Student student = new Student("John Doe", 20, 2, true);
        Loan loan1 = new Loan(student, book1, new Date(), null);
        library.getActiveLoans().add(loan1);

        // WHEN
        Loan foundLoan = library.findActiveLoanForItem(book1);

        // THEN
        assertEquals(loan1, foundLoan);
    }

    @Test
    void findActiveLoanForItem_ItemIsNotLoaned() {
        // GIVEN
        ArrayList<Loan> emptyLoans = new ArrayList<>();
        Library library = new Library("Test Library", null, emptyLoans, null);
        Book book1 = new Book("Book 1", 2008, 320, "978-0321765723", new Author("Author 1", 0, null));
        Book book2 = new Book("Book 2", 2005, 450, "978-0596009205", new Author("Author 2", 0, null));
        Student student = new Student("John Doe", 20, 2, true);
        Loan loan1 = new Loan(student, book1, new Date(), null);
        library.getActiveLoans().add(loan1);

        // WHEN
        Loan foundLoan = library.findActiveLoanForItem(book2);

        // THEN
        assertNull(foundLoan);
    }

    @Test
    void getBooksForAuthorTest() {
        // GIVEN
        ArrayList<Loan> emptyLoans = new ArrayList<>();
        Author author1 = new Author("Author 1", 0, null);
        Book book1 = new Book("Book 1", 2008, 320, "978-0321765723", new Author("Author 1", 0, null));
        ArrayList<Item> books = new ArrayList<>();
        books.add(book1);   
        Library library = new Library("Test Library", books, emptyLoans, null);

        // WHEN
        ArrayList foundBooks = library.getBooksForAuthor(author1);

        // THEN
        assertEquals(foundBooks, books);
    }

}