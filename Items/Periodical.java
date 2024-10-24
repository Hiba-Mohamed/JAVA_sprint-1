package Items;

import Authors.*;
import java.util.Date;
public class Periodical extends LibraryItem {
    private boolean printed = false;
    private boolean electronic = false;

    public Periodical(String title,String ISBN,String publisher,int numberOfCopies,Author author){
        super(title, ISBN, publisher, numberOfCopies, author);
    }

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

    public void setInfo(String title,String ISBN,String publisher,int numberOfCopies,String authorFname, String authorLname, String address, Date dateOfBirth , String type){
        this.setTitle(title);
        this.setISBN(ISBN);
        this.setPublisher(publisher);
        this.setNumberOfCopies(numberOfCopies);
        this.setAuthor(authorFname, authorLname, address, dateOfBirth);
        this.setPeriodicalType(type);
    }


    public void setPeriodicalType(String type) {
        // Reset all the false first to make sure only one istrue at a time
        this.printed = false;
        this.electronic = false;
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

       public String getPeriodicalType(){
        if (this.printed == true){
            return "Printed";}
        else{
            if(this.electronic == true){
                return "Electronic";
            }
            else{
                return "Not Specified";
            }
        }

    }

    @Override
    public String toString() {
        return "Periodical Info {" +
            "ID=" + getID() +
            ", Title='" + getTitle() + '\'' +
            ", ISBN='" + getISBN() + '\'' +
            ", Publisher='" + getPublisher() + '\'' +
            ", NumberOfCopies=" + getNumberOfCopies() +
            ", Periodical Type=" + this.getPeriodicalType() +
            '}';
    }
  

}