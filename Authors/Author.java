package Authors;

import Items.LibraryItem;

import java.util.Date;
import java.util.ArrayList;

public class Author{
    private String firstName;
    private String lastName;
    private String address;
    private Date dateOfBirth;
    private ArrayList<LibraryItem> writtenItems;

    public Author(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.writtenItems = new ArrayList<LibraryItem>();
    }

    public Author(String firstName, String lastName, String address, ArrayList<LibraryItem> writtenItems ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.writtenItems = writtenItems;
    }

    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName(){
        return this.firstName + ' ' +this.lastName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth(){
        return this.dateOfBirth;
    }

    public void setWrittenItems(ArrayList<LibraryItem> writtenItems){
        this.writtenItems = writtenItems;
    }

    public ArrayList<LibraryItem> getWrittenItems(){
        return this.writtenItems;
    }

    public String toString(){
        return "Author Info {" +
            "Name =" + this.firstName + ' ' + this.lastName +
            ", Address='" + this.address + '\'' +
            ", DOB='" + this.dateOfBirth + '\'' +
            ", Written Items='" + this.writtenItems + '\'' +
            '}';
    }

}