package ATM_Machine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ATM {
    public static void main(String[] args) {




        int number = Integer.parseInt(JOptionPane.showInputDialog("Enter ur account number"));
        int scretOS = Integer.parseInt(JOptionPane.showInputDialog("Enter ur secret number"));

        int accNumber = 20010730;
        int sNumber = 5566;




        if(accNumber == number && sNumber == scretOS ){
            System.out.println("Welcome Imal");
            System.out.println("English or Sinhala");
            String language = JOptionPane.showInputDialog("Enter ur laguage");
            System.out.println(language);
            switch (language) {
                case "English":
                    System.out.println("Hey Imal");
                    hello();
                    break;
                case "Sinhala":
                    System.out.println("hey");
                default:
                    System.out.println("Select english or sinhala");
            }
        }
        else{
            System.out.println("wrong");
        }

    }

    static  void hello(){

//        boolean isJavaFun = true;
        boolean value = true;


        int cash= 0;
        int balance = 5000;

        do{
            System.out.println("1. Check Balance");
            System.out.println("2. Cash deposit");
            System.out.println("3. exit");
            int option = Integer.parseInt(JOptionPane.showInputDialog("Choose option 1-3"));
            switch (option){
                case 1 :
                    System.out.println("$"+balance);
                    break;

                case 2:
                    cash = Integer.parseInt(JOptionPane.showInputDialog("Enter cash do u want to depost"));
                    if(cash < balance){
                        balance -= cash;
                        System.out.println(cash);
                        System.out.println(balance);
                        JOptionPane.showMessageDialog(null,"Thank you come again !!! ");
                    }else{
                        System.out.println("Sorry low balance !!! ");
                    }
                    break;
                case 3:
                    value = false;
                    break;
                default:
                    System.out.println("Choose right option");
                    break;
            }
        }while (value);

    }
}