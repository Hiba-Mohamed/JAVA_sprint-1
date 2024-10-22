package JAVA_sprint_1.Patrons;

public class StudentPatron extends Patron {
    private String studentID;

    public StudentPatron(String name, String address, String phoneNumber, String studentID) {
        super(name, address, phoneNumber);
        this.studentID = studentID;
    }

    public String getStudentID() {
        return this.studentID;
    }

    @Override
    public String toString() {
        return "StudentPatron{" +
                "studentID='" + this.studentID + '\'' +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", borrowedItems=" + getBorrowedItems() +
                '}';
    }
}

