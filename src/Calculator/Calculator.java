package Calculator;

import java.util.Scanner;

public class Calculator extends Operations{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double total = 0;
        double[] myNum =new  double[2];
        boolean loop = true;

        while(loop){
            if(total == 0) {
                System.out.println("Enter first number");
                myNum[0] = scanner.nextDouble();
                scanner.nextLine();
            }else {
                myNum[0] = total;
            }

            System.out.println("Enter the next number");
            myNum[1] = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter symbol + or - ");
            String symbol = scanner.nextLine();

            if (symbol.equals("+")) {
                total = calculator.add(myNum);

            }else if(symbol.equals("-")) {
                total = calculator.reduce(myNum);

            }else if (symbol.equals("c")) {
                myNum[0] = 0;
            } else if (symbol.equals("*")) {
                total = calculator.mul(myNum);
            } else if (symbol.equals("/")) {
                if(myNum[1] == 0){
                    System.out.println("Cant divide using 0");
                    continue;
                }
                 total =calculator.div(myNum);
            } else{
                System.out.println("wrong symbol");
                continue;
            }

            System.out.println("total -  " + total);

            System.out.println("Do you want to loop ? (yes or no)");
            String runOrstop = scanner.nextLine();
            if(runOrstop.equals("no")){
                loop = false;
            }

        }

    }

    public  double add(double[] a){
        return a[0] + a[1];
    }

    public  double mul(double[] a){
        return a[0] * a[1];
    }

    public  double div(double[] a){
        return a[0] / a[1];
    }

    public double reduce(double[] a){
        return a[0] - a[1];
    }
}
