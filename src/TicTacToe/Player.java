package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    char symbol;
    String name;
    boolean isComputer = false;
    Random rand = new Random();

    public Player(char symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }

    public Player(char symbol, String name, boolean isComputer){
        this.symbol = symbol;
        this.name = name;
        this.isComputer = isComputer;
    }

    public int[] getMove(Board board){
        if(isComputer){
            //computer
            System.out.println("Computer thinking...");
            int randomRow = rand.nextInt(3);
            int randomCol = rand.nextInt(3);
            while(!board.isValidMove(randomRow, randomCol)){
                randomRow = rand.nextInt(3);
                randomCol = rand.nextInt(3);
            }
            return new int[]{randomRow, randomCol};
        }else{
            System.out.println("Enter position of row and column");
            int row = sc.nextInt();
            int column = sc.nextInt();
            while(!board.isValidMove(row,column)){
                System.out.println("Invalid move type again...");
                row = sc.nextInt();
                column = sc.nextInt();
            }
            return new int[]{row,column};
        }
    }


    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

}
