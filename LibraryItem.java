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

@Override
public String toString() {
    return "Library Item {" +
           "ID=" + ID +
           ", Title='" + title + '\'' +
           ", ISBN='" + ISBN + '\'' +
           ", Publisher='" + publisher + '\'' +
           ", NumberOfCopies=" + numberOfCopies +
           '}';
}


    
}
