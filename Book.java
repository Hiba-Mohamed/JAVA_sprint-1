package JAVA_sprint_1;

public class Book extends LibraryItem {
    private boolean printed = false;
    private boolean electronic = false;
    private boolean audio= false;
    public Book(String title,String ISBN,String publisher,int numberOfCopies,Author author,String type){
super(title, ISBN, publisher, numberOfCopies, author);
        switch (type.toLowerCase()) {
            case "printed":
                this.printed = true;
                break;
            case "electronic":
                this.electronic = true;
                break;
            case "audio":
                this.audio = true;
                break;
            default:
            System.err.println("Invalid book type: Please enter a valid book type ('printed' or 'electronic' or 'audio')");
                break;
        }
    }
    
}
