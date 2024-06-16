package CarRentalSystem;

public class Client extends User {
    public Client(){
        super();
    }

    @Override
    public void showList() {
        System.out.println("\n 1.View Car");
        System.out.println("2. Rent Car ");
        System.out.println("4. Return Car");
        System.out.println("5. Show My Admin");
        System.out.println("6. Edit My Data");
        System.out.println("7. Quit \n");
    }
}
