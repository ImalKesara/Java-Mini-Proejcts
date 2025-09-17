package Hyperskills.Smart_Chat_Bot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Aid.");
        System.out.println("I was created in 2018.");
        System.out.println("Please, remind me your name.");

        // reading a name
        String yourName = scanner.nextLine();

        System.out.println("What a great name you have," + yourName + "!");

        System.out.println("Let me guess your age");

        System.out.println("Enter remainders of dividing your age by 3, 5 and 7. ");
        int remainderThree = scanner.nextInt();
        int remainderFive = scanner.nextInt();
        int remainderSeven = scanner.nextInt();
        int yourAge = (remainderThree * 70  + remainderFive * 21 + remainderSeven * 15) % 105;
        System.out.println("Your age is "+yourAge+ " that's a good time to start programming! ");

    }
}
