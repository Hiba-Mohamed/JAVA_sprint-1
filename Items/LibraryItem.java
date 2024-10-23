package Items;


import Authors.*;
public class LibraryItem {
    private static int nextId = 0;
    private int ID;
    private String title;
    private String isbn;
    private String publisher;
    private int numberOfCopies;
    private Author author;


    public LibraryItem(String title,String isbn,String publisher,int numberOfCopies){
        this.ID = nextId;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        incrementNextId();  
      }

    public LibraryItem(String title,String isbn,String publisher,int numberOfCopies,Author author){
        this.ID = nextId;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.author = author;
        incrementNextId();  
      }

    public static void incrementNextId(){
        nextId++;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setISBN(String isbn){
        this.isbn= isbn;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public void setNumberOfCopies(int numberOfCopies){
        this.numberOfCopies = numberOfCopies;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getID() {
        return this.ID;
    }

    public String getTitle() {
        return this.title;
    }

    public String getISBN() {
        return this.isbn;
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
            "ID=" + this.ID +
            ", Title='" + this.title + '\'' +
            ", ISBN='" + this.isbn + '\'' +
            ", Publisher='" + this.publisher + '\'' +
            ", NumberOfCopies=" + this.numberOfCopies +
            '}';
    }


    
}
