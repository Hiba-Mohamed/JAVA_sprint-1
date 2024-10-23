import Items.*;
import Library.Library;
import java.util.Scanner;

import Authors.Author;

public class Demo {
 //*
// This is just one example of how a menu can look using a scanner
// This isnt complete nor does it have all required sections included
// This is just meant to give you a brief idea of how a menu could look
// Good luck and have fun!
//
//
// *//



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the Library Management System");
            // there are more options needed for the project.
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();
            Library library = new Library();

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
                    System.out.print("Enter available copies: ");
                    int availableCopies = scanner.nextInt();
                    Author author = new Author(authorFname, authorLname, authorAddress);
                    if (!library.authorExistsInLibrary(authorFname, authorLname)){
                        library.addNewAuthor(author);

                    }
                    scanner.nextLine();
                    if (bookORperiodical == "book"){
                        Book book = new Book()

                    }
                    else{
                        if (bookORperiodical == "periodical"){

                        }
                        else{
                            System.out.println("Error, invalid entry for type, item not added");
                        }
                    }

                    LibraryItem libraryItem = new LibraryItem(title,ISBN,publisher,availableCopies);
                    library.addLibraryItem(libraryItem);
                    break;
                case 2:
                    System.out.println("Editing an existing library item...");
                    break;
                case 3:
                    System.out.println("Deleting a library item...");
                    String itemISBN = scanner.nextLine();
                    scanner.nextLine();
                    LibraryItem item = library.searchItemByISBN(itemISBN);
                    library.removeLibraryItem(item);
                    break;
                case 4:
                    System.out.println("Borrowing a library item...");
                    // Add logic to borrow a library item
                    break;
                case 5:
                    System.out.println("Returning a library item...");
                    // Add logic to return a library item
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
   