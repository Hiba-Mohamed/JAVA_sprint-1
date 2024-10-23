package Library;

import Items.*;
import Patrons.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> libraryItems;  // List of all library items (books, periodicals, etc.)
    private ArrayList<Patron> patrons;  // List of registered patrons

    // Constructor
    public Library() {
        this.libraryItems = new ArrayList<>();  // Initialize the list of library items
        this.patrons = new ArrayList<>();       // Initialize the list of patrons
    }

    // Add a new LibraryItem (book, periodical, etc.)
    public void addLibraryItem(LibraryItem item) {
        this.libraryItems.add(item);
        System.out.println(item.getTitle() + " has been added to the library.");
    }

    // Remove an existing LibraryItem
    public void removeLibraryItem(LibraryItem item) {
        if (this.libraryItems.remove(item)) {
            System.out.println(item.getTitle() + " has been removed from the library.");
        } else {
            System.out.println(item.getTitle() + " was not found in the library.");
        }
    }

    // Register a new Patron
    public void registerPatron(Patron patron) {
        this.patrons.add(patron);
        System.out.println(patron.getName() + " has been registered as a patron.");
    }

    // Unregister an existing Patron
    public void unregisterPatron(Patron patron) {
        if (this.patrons.remove(patron)) {
            System.out.println(patron.getName() + " has been removed from the patron list.");
        } else {
            System.out.println(patron.getName() + " was not found in the patron list.");
        }
    }

    // Borrow an item by a patron
    public void borrowItem(Patron patron, LibraryItem item) {
        if (this.libraryItems.contains(item) && patron != null) {
            patron.borrowItem(item);  // Assuming Patron class has a borrowItem() method
            System.out.println(patron.getName() + " has borrowed " + item.getTitle());
        } else {
            System.out.println("The item is not available or the patron is invalid.");
        }
    }

    // Return an item by a patron
    public void returnItem(Patron patron, LibraryItem item) {
        if (patron != null) {
            patron.returnItem(item);  // Assuming Patron class has a returnItem() method
            System.out.println(patron.getName() + " has returned " + item.getTitle());
        }
    }

    // Search for a library item by title
    public LibraryItem searchItemByTitle(String title) {
        for (LibraryItem item : this.libraryItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        System.out.println("Item with title '" + title + "' not found.");
        return null;
    }

    // Search for a library item by author
    public LibraryItem searchItemByAuthor(String authorName) {
        for (LibraryItem item : this.libraryItems) {
            if (item.getAuthor() != null && item.getAuthor().getName().equalsIgnoreCase(authorName)) {
                return item;
            }
        }
        System.out.println("No items found for author '" + authorName + "'.");
        return null;
    }

    // Search for a library item by ISBN
    public LibraryItem searchItemByISBN(String isbn) {
        for (LibraryItem item : this.libraryItems) {
            if (item.getISBN().equals(isbn)) {
                return item;
            }
        }
        System.out.println("Item with ISBN '" + isbn + "' not found.");
        return null;
    }

    // Display all library items
    public void displayAllItems() {
        if (libraryItems.isEmpty()) {
            System.out.println("No items are available in the library.");
        } else {
            System.out.println("Library Items:");
            for (LibraryItem item : libraryItems) {
                System.out.println(item);
            }
        }
    }

    // Display all patrons
    public void displayAllPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons are registered.");
        } else {
            System.out.println("Library Patrons:");
            for (Patron patron : patrons) {
                System.out.println(patron);
            }
        }
    }
}
