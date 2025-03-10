package fr.ensai.library;

/**
 * Represents a book.
 */
public class Magazine extends Item {

    // Attributes
    private String issn;
    private int issueNumber;

    /**
     * Constructs a new Magazine object.
     */
    public Magazine(String title, int year, int pageCount, String issn, int issueNumber) {
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public Author getAuthor() {
        return null;
    }

    @Override
    public String toString() {
        return "Book " + title + " written by " + issueNumber;
    }

}
