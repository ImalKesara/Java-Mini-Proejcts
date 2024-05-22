package BinarytoDecimal;

import java.util.Scanner;

public class Dto {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.\



        Scanner scanner = new Scanner(System.in);
        int decimal = 0;

        System.out.println("Enter Decimal number you wish");
        decimal =  scanner.nextInt();
        System.out.println(decimal);

        int remain;

        while(decimal != 0){
            remain = decimal % 2 ;
            decimal/=2;
            System.out.print(remain);

        }
    }
}