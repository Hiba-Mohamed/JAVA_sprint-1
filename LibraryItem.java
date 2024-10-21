package JAVA_sprint_1;

public class LibraryItem {
    private static int nextId = 0;
    private int ID;
    private String title;
    private String ISBN;
    private String publisher;
    private int numberOfCopies;
    private Author author;


    public LibraryItem(String title,String ISBN,String publisher,int numberOfCopies){
        this.ID = nextId;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        incrementNextId();  
      }

    public LibraryItem(String title,String ISBN,String publisher,int numberOfCopies,Author author){
        this.ID = nextId;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.author = author;
        incrementNextId();  
      }

    public static void incrementNextId(){
        nextId++;
    }

    public int getID() {
        return this.ID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getNumberOfCopies() {
        return this.numberOfCopies;
    }

    public Author getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Library Item {" +
            "ID=" + getID() +
            ", Title='" + getTitle() + '\'' +
            ", ISBN='" + getISBN() + '\'' +
            ", Publisher='" + getPublisher() + '\'' +
            ", NumberOfCopies=" + getNumberOfCopies() +
            '}';
    }


    
}
