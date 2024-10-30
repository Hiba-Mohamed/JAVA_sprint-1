import Authors.Author;
import Items.*;
import Library.Library;
import Patrons.Patron;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Library library = new Library();

        // // Sample data for testing
        // Book book1 = new Book("BookTitle1", "BOOKISBN1", "BOOKpublisher1", 9, new Author("firstName", "lastName", "1street"), "audio");
        // Periodical periodical1 = new Periodical("PERIODICALTitle1", "PERIODICALISBN1", "PERIODICALpublisher1", 9, new Author("firstName", "lastName", "1street"), "printed");
        // Patron patron1 = new Patron("patron1", "123street", "1234567");
        // Patron patron2 = new Patron("patron2", "456street", "98764");
        // library.registerPatron(patron1);
        // library.registerPatron(patron2);
        // library.addLibraryItem(book1);
        // library.addLibraryItem(periodical1);

        // Load initial data
        loadData(library);

        do {
            System.out.println("\nWelcome to the Library Management System");
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Exit");
            System.out.println("\n");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addLibraryItem(scanner, library);
                case 2 -> editLibraryItem(scanner, library);
                case 3 -> deleteLibraryItem(scanner, library);
                case 4 -> borrowLibraryItem(scanner, library);
                case 5 -> returnLibraryItem(scanner, library);
                case 6 -> System.out.println("Exiting the system. Goodbye!");
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
     // Method to preload data for testing
    private static void loadData(Library library) {
        Author author1 = new Author("John", "Doe", "123 Main City");
        Author author2 = new Author("Jane", "Smith", "456 Elm St");
        
        Book book1 = new Book("Mystery of the Old House", "ISBN001", "Penguin", 5, author1, "printed");
        Book book2 = new Book("The Adventures of Time", "ISBN002", "HarperCollins", 3, author2, "audio");
        Book book3 = new Book("The Space Beyond", "ISBN003", "Random House", 2, author1, "electronic");
        Book book4 = new Book("Ocean's Depths", "ISBN004", "Seas Publishers", 4, author2, "printed");
        
        Periodical periodical1 = new Periodical("Nature Weekly", "PERIODICAL001", "Nature", 7, author1, "printed");
        Periodical periodical2 = new Periodical("Science Daily", "PERIODICAL002", "SciencePress", 6, author2, "electronic");
        Periodical periodical3 = new Periodical("Tech Monthly", "PERIODICAL003", "Tech Today", 5, author1, "printed");

        System.out.println("\n");
        library.addLibraryItem(book1);
        library.addLibraryItem(book2);
        library.addLibraryItem(book3);
        library.addLibraryItem(book4);
        library.addLibraryItem(periodical1);
        library.addLibraryItem(periodical2);
        library.addLibraryItem(periodical3);

        Patron patron1 = new Patron("Alice Johnson", "789 Pine St", "555-1234");
        Patron patron2 = new Patron("Bob Williams", "321 Oak St", "555-5678");
        Patron patron3 = new Patron("Carol White", "654 Maple St", "555-8765");

        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.registerPatron(patron3);

        System.out.println("\nData loaded successfully");
    }

    private static void addLibraryItem(Scanner scanner, Library library) {
        System.out.println("Adding a new library item...");
        System.out.print("Enter the type ('book' or 'periodical'): ");
        String itemType = scanner.nextLine().toLowerCase();
        System.out.print("Specify 'audio', 'printed', or 'electronic': ");
        String format = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author's First Name: ");
        String authorFname = scanner.nextLine();
        System.out.print("Enter Author's Last Name: ");
        String authorLname = scanner.nextLine();
        System.out.print("Enter Author's Address: ");
        String authorAddress = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter Available Copies: ");
        int availableCopies = scanner.nextInt();
        scanner.nextLine();

        Author author = new Author(authorFname, authorLname, authorAddress);
        
        if (!library.authorExistsInLibrary(authorFname, authorLname)) {
            library.addAuthor(author);
        }

        if (itemType.equals("book")) {
            library.addLibraryItem(new Book(title, ISBN, publisher, availableCopies, author, format));
        } else if (itemType.equals("periodical")) {
            library.addLibraryItem(new Periodical(title, ISBN, publisher, availableCopies, author, format));
        } else {
            System.out.println("Invalid item type. Item not added.");
            return;
        }

        System.out.println("Item added successfully!");
        library.displayAllItems();
    }

    private static void editLibraryItem(Scanner scanner, Library library) {
        System.out.println("Editing an existing library item...");
        System.out.print("Enter Item ISBN: ");
        String isbn = scanner.nextLine();
        LibraryItem specifiedItem = library.searchItemByISBN(isbn);
        
        if (specifiedItem == null) {
            System.out.println("Item not found.");
            return;
        }

        System.out.print("Enter new Title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new Publisher: ");
        String newPublisher = scanner.nextLine();
        System.out.print("Enter new Available Copies: ");
        int newCopies = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Author's First Name: ");
        String newAuthorFname = scanner.nextLine();
        System.out.print("Enter new Author's Last Name: ");
        String newAuthorLname = scanner.nextLine();
        System.out.print("Enter new Author's Address: ");
        String newAuthorAddress = scanner.nextLine();
        System.out.print("Enter new Item Type (printed, electronic, or audio): ");
        String newType = scanner.nextLine();
        System.out.print("Enter Author's Date of Birth (yyyy-MM-dd): ");
        LocalDate newAuthorDOB = parseDate(scanner);

        if (newAuthorDOB == null) {
            return;
        }

        Date authorDOBDate = Date.from(newAuthorDOB.atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (specifiedItem instanceof Book bookItem) {
            bookItem.setInfo(newTitle, isbn, newPublisher, newCopies, newAuthorFname, newAuthorLname, newAuthorAddress, authorDOBDate, newType);
        } else if (specifiedItem instanceof Periodical periodicalItem) {
            periodicalItem.setInfo(newTitle, isbn, newPublisher, newCopies, newAuthorFname, newAuthorLname, newAuthorAddress, authorDOBDate, newType);
        }

        System.out.println("Item edited successfully!");
        library.displayAllItems();
    }

    private static void deleteLibraryItem(Scanner scanner, Library library) {
        System.out.println("Deleting a library item...");
        System.out.print("Enter Item ISBN: ");
        String itemISBN = scanner.nextLine();
        LibraryItem item = library.searchItemByISBN(itemISBN);

        if (item == null) {
            System.out.println("Item not found.");
        } else {
            library.removeLibraryItem(item);
            System.out.println("Item deleted successfully!");
            library.displayAllItems();
        }
    }

    private static void borrowLibraryItem(Scanner scanner, Library library) {
        System.out.println("Borrowing a library item...");
        System.out.print("Enter Patron Name: ");
        String patronName = scanner.nextLine();
        Patron patron = library.searchPatronByName(patronName);

        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.print("Enter Item ISBN: ");
        String borrowISBN = scanner.nextLine();
        LibraryItem borrowItem = library.searchItemByISBN(borrowISBN);

        if (borrowItem == null) {
            System.out.println("Item not found.");
        } else {
            library.borrowItem(patron, borrowItem);
            System.out.println("Item borrowed successfully!");
        }
    }

    private static void returnLibraryItem(Scanner scanner, Library library) {
        System.out.println("Returning a library item...");
        System.out.print("Enter Patron Name: ");
        String returnPatronName = scanner.nextLine();
        Patron returnPatron = library.searchPatronByName(returnPatronName);

        if (returnPatron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.print("Enter Item ISBN: ");
        String returnISBN = scanner.nextLine();
        LibraryItem returnItem = library.searchItemByISBN(returnISBN);

        if (returnItem == null) {
            System.out.println("Item not found.");
            return;
        }
        // } else {
        //     library.returnItem(returnPatron, returnItem);
        //     System.out.println("Item returned successfully!");
        // }
        returnPatron.returnItem(returnItem);
    }

    private static LocalDate parseDate(Scanner scanner) {
        try {
            String dobInput = scanner.nextLine();
            return LocalDate.parse(dobInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
            return null;
        }
    }
}
