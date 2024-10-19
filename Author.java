package JAVA_sprint_1;
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

    public void editName(String name){
        this.name = name;
    }
    public void editAddress(String address){
        this.address = address;
    }

    public void editwrittenItems(ArrayList<LibraryItem> writtenItems){
        this.writtenItems = writtenItems;
    }

    public void getwrittenItems(ArrayList<String> writtenItems){
    }

}