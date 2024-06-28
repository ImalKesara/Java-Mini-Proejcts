package CarRentalSystem.Modal;

import CarRentalSystem.Controller.AddnewAccount;

import java.util.Scanner;

public class Client extends User {

    private  Operations[] operations  = new Operations[] {new AddnewAccount(0)};

    public Client(){
        super();
    }

    @Override
    public void showList(Database database, Scanner sc) {
        System.out.println("1. View Car");
        System.out.println("2. Rent Car ");
        System.out.println("4. Return Car");
        System.out.println("5. Show My Admin");
        System.out.println("6. Edit My Data");
        System.out.println("7. Quit \n");
    }
}
