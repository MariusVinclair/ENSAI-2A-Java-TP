package fr.ensai.library;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Represents a library.
 */
public class Library {
    
    // Attributes
    private String name;
    private ArrayList<Item> items;
    private ArrayList<Loan> activeLoans;
    private ArrayList<Loan> completedLoans;

    /**
     * Constructs a new Library object.
     */
    public Library(String name, ArrayList<Item> items, ArrayList<Loan> activeLoans, ArrayList<Loan> completedLoans) {
        this.name = name;
        this.items = items;
        this.activeLoans = activeLoans;
        this.completedLoans = completedLoans;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String displayItems() {
        if (this.items.isEmpty()){
            return ("There is no item");
        } else {
            for (Item item : this.items){
                System.out.println(item);
            }
            return "";
        }
    }

    public ArrayList<Loan> getActiveLoans() {
        return this.activeLoans;
    }

    public Loan findActiveLoanForItem(Item item) {
        for (Loan loan : this.activeLoans) {
            if (loan.getItem() == item) {
                return loan;
            }
        }
        return null;
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName, 0, "");
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(title, year, pageCount, isbn, author);

                    this.addItem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
