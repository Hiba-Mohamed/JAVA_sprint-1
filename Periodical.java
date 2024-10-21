package JAVA_sprint_1;

public class Periodical extends LibraryItem {
    private boolean printed = false;
    private boolean electronic = false;


    public Periodical(String title,String ISBN,String publisher,int numberOfCopies,Author author,String type){
        super(title, ISBN, publisher, numberOfCopies, author);
        switch (type.toLowerCase()) {
            case "printed":
                this.printed = true;
                break;
            case "electronic":
                this.electronic = true;
                break;
            default:
            System.err.println("Invalid periodical type: Please enter a valid periodical type ('printed' or 'electronic')");
                break;
        }
    }

}
