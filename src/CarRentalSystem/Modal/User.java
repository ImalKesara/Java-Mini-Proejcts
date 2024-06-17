package CarRentalSystem.Modal;

import java.util.Scanner;

abstract public class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

//    type = 0 :- client
//    type = 1 :- admin

    public User(){

    }

    public abstract void showList(Database database, Scanner sc);

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
