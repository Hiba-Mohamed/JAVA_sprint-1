package Patrons;

import Items.*;
import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public List<LibraryItem> getBorrowedItems() {
        return this.borrowedItems;
    }

    // Add a library item to the borrowed items list
    public void borrowItem(LibraryItem item) {
        if (item != null){ //To ensure no null/invalid items are added
        borrowedItems.add(item);
        System.out.println(item.getTitle() + " has been borrowed by " + this.name);
        } else {
        System.out.println("Cannot borrow a null item.");
        }
    }

    // Remove a library item from the borrowed items list
    public void returnItem(LibraryItem item) {
        if (item == null) {
        System.out.println("Cannot return a null item.");
        return; //To exit early if it's null/invalid
        }
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            System.out.println(item.getTitle() + " has been returned by " + this.name);
        } else {
            System.out.println("The item is not borrowed by " + this.name);
        }
    }

    // Search for borrowed items by title
    public LibraryItem searchBorrowedItemByTitle(String title) {
        if (title == null || title.isEmpty()) {
            System.out.println("Invalid title search.");
        return null; // To make sure that no invalid input is entered
        }
        for (LibraryItem item : this.borrowedItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        System.out.println("Item with title '" + title + "' not found in borrowed items.");
        return null;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedItems=" + borrowedItems +
                '}';
    }
}
