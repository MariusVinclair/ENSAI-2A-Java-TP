package fr.ensai.library;

import java.util.Date;

/**
 * Represents a Loan.
 */
public class Loan {
    
    // Attributes
    private Student student;
    private Item item;
    private Date startDate;
    private Date returnDate;

    /**
     * Constructs a new Loan object.
     */
    public Loan(Student student, Item item, Date startDate, Date returnDate) {
        this.student = student;
        this.item = item;
        this.startDate = startDate;
        this.returnDate = null;
    }
}
