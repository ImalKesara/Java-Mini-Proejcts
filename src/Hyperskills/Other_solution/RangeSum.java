package Hyperskills.Other_solution;
import java.util.InputMismatchException;
import java.util.Scanner;

public  class RangeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            int number = scanner.nextInt();
            System.out.println(number);
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    public static String getNextState(int currentState) {
        return String.valueOf((currentState + 1) % 3);
    }

    public static String getAction(int currentState) {
        return switch (getNextState(currentState)) {
            case "0" -> "Change to Red";
            case "1" -> "Change to Yellow";
            case "2" -> "Change to Green";
            default -> "Invalid State";
        };
    }

}

