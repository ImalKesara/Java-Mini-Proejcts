package CarRentalSystem.Modal;

import CarRentalSystem.Controller.AddnewAccount;
import CarRentalSystem.Controller.AddnewAdmin;

import java.util.Scanner;

public class Admin extends User {

    private  Operations[] operations  = new Operations[] {new AddnewAccount(1)};

     public Admin(){
        super();
    }


    @Override
    public void showList(Database database, Scanner sc) {
        System.out.println("1. Add New Car");
        System.out.println("2. View Car");
        System.out.println("3. Update Car ");
        System.out.println("4. Delete Car");
        System.out.println("5. Add New Admin");
        System.out.println("6. Show Rents");
        System.out.println("7. Quit");
        int i = sc.nextInt();
        operations[0].operations(database,sc,null);
        showList(database,sc);

    }
}
