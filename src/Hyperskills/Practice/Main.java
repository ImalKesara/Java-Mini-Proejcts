package Hyperskills.Practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int D = 0,C = 0,B = 0, A = 0;
        int n = scanner.nextInt();
        char[] characters = new char[n];

        for(int i=0; i < characters.length ; i++){
            characters[i] = scanner.next().charAt(0);
                if (characters[i] == 'D') {
                    D++;
                } else if (characters[i] == 'C') {
                    C++;
                } else if (characters[i] == 'B') {
                    B++;
                } else if (characters[i] == 'A') {
                    A++;
                } else {
                    System.out.println("Not a valid character");
                    System.out.println("Enter D or C or B or A");
                    System.out.println("i value " + i);
                    i--;
                }
        }

        System.out.println(D + " " + C + " " + B + " " + A);

    }
}
