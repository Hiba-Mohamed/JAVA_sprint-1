package Authors;

import Items.LibraryItem;

import java.util.Date;
import java.util.ArrayList;

public class Author{
    private String name;
    private String address;
    private Date dateOfBirth;
    private ArrayList<LibraryItem> writtenItems;

    public Author(String name, String address){
        this.name = name;
        this.address = address;
        this.writtenItems = new ArrayList<LibraryItem>();
    }

    public Author(String name, String address, ArrayList<LibraryItem> writtenItems ){
        this.name = name;
        this.address = address;
        this.writtenItems = writtenItems;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
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
            "Name =" + this.name +
            ", Address='" + this.address + '\'' +
            ", DOB='" + this.dateOfBirth + '\'' +
            ", Written Items='" + this.writtenItems + '\'' +
            '}';
    }

}