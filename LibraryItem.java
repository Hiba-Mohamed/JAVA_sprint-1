package JAVA_sprint_1;

public class LibraryItem {
    private int ID;
    private String title;
    private String ISBN;
    private String publisher;
    private int numberOfCopies;
    private Author author;

    public LibraryItem(int ID, String title,String ISBN,String publisher,int numberOfCopies,Author author){
        this.ID = ID;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.author = author;
    }

    public void editLibraryItem(int ID, String title,String ISBN,String publisher,int numberOfCopies,Author author){
        this.ID = ID;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.author = author;
    }

    public void deleteLibraryItem(){}



    
}
