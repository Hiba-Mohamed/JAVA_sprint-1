package JAVA_sprint_1;

public class Book extends LibraryItem {
    private String type;

    public Book(String title,String ISBN,String publisher,int numberOfCopies,Author author,String type){
        super(title, ISBN, publisher, numberOfCopies, author);
        this.type = type;
    }
    
}
