

public class EmployeePatron extends Patron {
    private String employeeID;

    public EmployeePatron(String name, String address, String phoneNumber, String employeeID) {
        super(name, address, phoneNumber);
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    @Override
    public String toString() {
        return "EmployeePatron{" +
                "employeeID='" + this.employeeID + '\'' +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", borrowedItems=" + getBorrowedItems() +
                '}';
    }
}
