package Library;
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
    /*
     * This is just one example of how a menu can look using a scanner
     * This isn't complete nor does it have all required sections included
     * This is just meant to give you a brief idea of how a menu could look
     * Good luck and have fun!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Library library = new Library();

        Book book1 = new Book("BookTitle1", "BOOKISBN1", "BOOKpublisher1", 9, new Author("firstName", "lastName", "1street"), "audio");
        Periodical periodical1 = new Periodical("PERIODICALTitle1", "PERIODICALISBN1", "PERIODICALpublisher1", 9, new Author("firstName", "lastName", "1street"), "printed");
        Author author1 = new Author("Author1first", "Author1last", "123street");
        Author author2 = new Author("Author2first", "Author2last", "456street");
        Patron patron1 = new Patron("patron1", "123street", "1234567");
        Patron patron2 = new Patron("patron2", "456street", "98764");

        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addLibraryItem(book1);
        library.addLibraryItem(periodical1);

        System.out.println("");
        library.displayAllItems();
        library.displayAllAuthors();
        library.displayAllPatrons();
        System.out.println("");

        do {
            System.out.println("");
            library.displayAllItems();
            library.displayAllAuthors();
            library.displayAllPatrons();
            System.out.println("");

            System.out.println("Welcome to the Library Management System");
            // there are more options needed for the project.
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Add a new Author to the library");
            System.out.println("7. Remove existing Author from the library");
            System.out.println("8. Add a new Patron to the library");
            System.out.println("9. Remove existing Patron from the library");
            System.out.println("10. Exit");
            System.out.print("Enter your choice (1-10): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new library item...");
                    // Add logic to add a library item
                    System.out.println("Enter the type ('book' or 'periodical') of Library item: ");
                    String bookORperiodical = scanner.nextLine();
                    System.out.println("Specify 'audio', 'printed', or 'electronic': ");
                    String itemType = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Authors first name: ");
                    String authorFname = scanner.nextLine();
                    System.out.print("Enter Authors last name: ");
                    String authorLname = scanner.nextLine();
                    System.out.print("Enter Authors Address: ");
                    String authorAddress = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter total copies: ");
                    int totalCopies = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter available copies: ");
                    int availableCopies = scanner.nextInt();
                    scanner.nextLine();

                    Author author = new Author(authorFname, authorLname, authorAddress);
                    if (!library.authorExistsInLibrary(authorFname, authorLname) && bookORperiodical.equalsIgnoreCase("book")) {
                        library.addAuthor(author);
                        Book book = new Book(title, ISBN, publisher, availableCopies, author, itemType);
                        library.addLibraryItem(book);
                        System.out.println("Item Added Successfully! ");
                        System.out.println("");
                        library.displayAllItems();
                    } else {
                        if (library.authorExistsInLibrary(authorFname, authorLname) && bookORperiodical.equalsIgnoreCase("book")) {
                            Book book = new Book(title, ISBN, publisher, availableCopies, author, itemType);
                            library.addLibraryItem(book);
                            System.out.println("Item Added Successfully! ");
                            System.out.println("");
                            library.displayAllItems();
                        } else {
                            if (!library.authorExistsInLibrary(authorFname, authorLname) && bookORperiodical.equalsIgnoreCase("periodical")) {
                                library.addAuthor(author);
                                Periodical periodical = new Periodical(title, ISBN, publisher, availableCopies, author, itemType);
                                library.addLibraryItem(periodical);
                                System.out.println("Item Added Successfully! ");
                                System.out.println("");
                                library.displayAllItems();
                            } else {
                                if (library.authorExistsInLibrary(authorFname, authorLname) && bookORperiodical.equalsIgnoreCase("periodical")) {
                                    Periodical periodical = new Periodical(title, ISBN, publisher, availableCopies, author, itemType);
                                    System.out.println("");
                                    library.addLibraryItem(periodical);
                                } else {
                                    System.out.println("Error, invalid entry for type, item not added");
                                    library.displayAllItems();
                                }
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("Editing an existing library item...");
                    System.out.print("Enter Item ISBN: ");
                    String isbn = scanner.nextLine();
                    LibraryItem specifiedItem = library.searchItemByISBN(isbn);
                    System.out.print("Enter new Item Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Item ISBN: ");
                    String newISBN = scanner.nextLine();
                    System.out.print("Enter new Item Publisher: ");
                    String newPublisher = scanner.nextLine();
                    System.out.print("Enter new Item Number of Copies: ");
                    int newNumberOfCopies = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Item Author First Name: ");
                    String newAuthorFirstName = scanner.nextLine();
                    System.out.print("Enter new Item Author Last Name: ");
                    String newAuthorLastName = scanner.nextLine();
                    System.out.print("Enter new Item Author Address: ");
                    String newAuthorAddress = scanner.nextLine();
                    System.out.print("Enter new Item Author Date Of Birth (yyyy-MM-dd): ");
                    String dobInput = scanner.nextLine();
                    LocalDate newAuthorDOB = null;

                    try {
                        newAuthorDOB = LocalDate.parse(dobInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
                    }

                    Date authorDOBDate = Date.from(newAuthorDOB.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    System.out.print("Enter new Item Type (printed, electronic, or audio): ");
                    String newType = scanner.nextLine();

                    if (specifiedItem instanceof Book) {
                        Book bookItem = (Book) specifiedItem; // Cast to Book
                        bookItem.setInfo(newTitle, newISBN, newPublisher, newNumberOfCopies, newAuthorFirstName, newAuthorLastName, newAuthorAddress, authorDOBDate, newType);
                        System.out.println("");
                        library.displayAllItems();
                    } else {
                        Periodical periodicalItem = (Periodical) specifiedItem; // Cast to Periodical
                        periodicalItem.setInfo(newTitle, newISBN, newPublisher, newNumberOfCopies, newAuthorFirstName, newAuthorLastName, newAuthorAddress, authorDOBDate, newType);
                        System.out.println("");
                        library.displayAllItems();
                    }
                    break;

                case 3:
                    System.out.println("Deleting a library item...");
                    System.out.println("Enter Item ISBN: ");
                    String itemISBN = scanner.nextLine();
                    LibraryItem item = library.searchItemByISBN(itemISBN);
                    library.removeLibraryItem(item);
                    library.displayAllItems();
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Borrowing a library item...");
                    System.out.print("Enter Patron name: ");
                    String patronName = scanner.nextLine();
                    Patron patron = library.searchPatronByName(patronName);

                    if (patron == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter Item ISBN: ");
                    String borrowISBN = scanner.nextLine();
                    LibraryItem borrowItem = library.searchItemByISBN(borrowISBN);

                    if (borrowItem == null) {
                        System.out.println("Item not found.");
                    } else {
                        library.borrowItem(patron, borrowItem); // Borrow the item
                    }
                    break;

               case 5:
                    System.out.println("Returning a library item...");
                    System.out.print("Enter Patron name: ");
                    String returnPatronName = scanner.nextLine();
                    Patron returnPatron = library.searchPatronByName(returnPatronName);

                    if (returnPatron == null) {
                        System.out.println("Patron not found.");
                        break;
                    }

                    System.out.print("Enter Item ISBN: ");
                    String returnISBN = scanner.nextLine();
                    LibraryItem returnItem = library.searchItemByISBN(returnISBN);

                    if (returnItem == null) {
                        System.out.println("Item not found.");
                    } else {
                        library.returnItem(returnPatron, returnItem); // Return the item
                    }
                    break;

                case 6:
                    System.out.println("Adding a new author...");
                    // Add logic to add an author
                    break;

                case 7:
                    System.out.println("Removing an author...");
                    // Add logic to remove an author
                    break;

                case 8:
                    System.out.println("Adding a new patron...");
                    // Add logic to add a new patron
                    break;

                case 9:
                    System.out.println("Removing a patron...");
                    // Add logic to remove a patron
                    break;

                case 10:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
        scanner.close();
    }
}