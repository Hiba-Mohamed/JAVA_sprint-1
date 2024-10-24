package Library;

import Authors.*;
import Items.LibraryItem;
import Patrons.Patron;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private ArrayList<LibraryItem> libraryItems;  // List of all library items (books, periodicals, etc.)
    private ArrayList<Patron> patrons;  // List of registered patrons
    private ArrayList<Author> authors;  // List of all authors

    // Constructor
    public Library() {
        this.libraryItems = new ArrayList<>();  // Initialize the list of library items
        this.patrons = new ArrayList<>();       // Initialize the list of patrons
        this.authors = new ArrayList<>();       // Initialize the list of authors
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

    // Add a new Author
    public void addAuthor(Author author) {
        this.authors.add(author);
        System.out.println(author.getName() + " has been added to the library's author list.");
    }

    // Check if author exists in library
    public boolean authorExistsInLibrary(String firstName, String lastName) {
        for (Author author : authors) {
            if (author.getName().equals(firstName + " " + lastName)) {
                return true;
            }
        }
        return false;
    }

    // Edit an existing Author (by searching with name)
    public void editAuthor(String existingAuthorName, Author updatedAuthor) {
        Author author = searchAuthorByName(existingAuthorName);
        if (author != null) {
            String[] nameParts = updatedAuthor.getName().split(" ");
            String firstName = nameParts[0];
            String lastName = (nameParts.length > 1) ? nameParts[1] : "";
            author.setName(firstName, lastName);
            author.setAddress(updatedAuthor.getAddress());
            author.setDateOfBirth(updatedAuthor.getDateOfBirth());
            author.setWrittenItems(updatedAuthor.getWrittenItems());
            System.out.println("Author " + existingAuthorName + " has been updated.");
        } else {
            System.out.println("Author " + existingAuthorName + " not found.");
        }
    }
    
    // Remove an Author
    public void removeAuthor(Author author) {
        if (this.authors.remove(author)) {
            System.out.println(author.getName() + " has been removed from the author list.");
        } else {
            System.out.println("Author " + author.getName() + " not found.");
        }
    }

    // Search for an author by name
    public Author searchAuthorByName(String name) {
        for (Author author : this.authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        System.out.println("Author with name '" + name + "' not found.");
        return null;
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

    public Patron searchPatronByName(String name) {
        for (Patron patron : patrons) {  // Assuming `patrons` is a list or collection of Patron objects in your library class
            if (patron.getName().equalsIgnoreCase(name)) {
                return patron;  // Patron found, return it
            }
        }
        return null;  // Patron not found
    }

    // Borrow an item by a patron
    public void borrowItem(Patron patron, LibraryItem item) {
        if (this.libraryItems.contains(item) && patron != null) {
            patron.borrowItem(item);
            System.out.println(patron.getName() + " has borrowed " + item.getTitle());
        } else {
            System.out.println("The item is not available or the patron is invalid.");
        }
    }

    // Return an item by a patron
    public void returnItem(Patron patron, LibraryItem item) {
        if (patron != null) {
            patron.returnItem(item);
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
    public List<LibraryItem> searchItemsByAuthor(String authorName) {
    List<LibraryItem> foundItems = new ArrayList<>();
    for (LibraryItem item : this.libraryItems) {
        if (item.getAuthor() != null && item.getAuthor().getName().equalsIgnoreCase(authorName)) {
            foundItems.add(item);
        }
    }
    if (foundItems.isEmpty()) {
        System.out.println("No items found for author '" + authorName + "'.");
    }
        return foundItems; // Return all found items
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

    // Display all authors
    public void displayAllAuthors() {
        if (authors.isEmpty()) {
            System.out.println("No authors are registered.");
        } else {
            System.out.println("Library Authors:");
            for (Author author : authors) {
                System.out.println(author);
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
