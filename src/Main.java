//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        int number = Integer.parseInt(JOptionPane.showInputDialog("Enter ur account number"));
        int scretOS = Integer.parseInt(JOptionPane.showInputDialog("Enter ur secret number"));

        int accNumber = 20010730;
        int sNumber = 5566;

        if(accNumber == number && sNumber == scretOS ){
            System.out.println("log in");
            System.out.println("English or Sinhala");

        }else{
            System.out.println("wrong");
        }

    }


}