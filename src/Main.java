//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int userinput= 0;
        int randomNumber= 0;
        int chances = 5;

        for (int i =0 ; i < chances ; i++){
            randomNumber = random.nextInt(10)+1;
            userinput = Integer.parseInt(JOptionPane.showInputDialog("enter a number between 1 to 10 "));
            if(userinput == randomNumber){
                JOptionPane.showMessageDialog(null,"Congratulations you guessed the number");
                break;
            } else if (userinput > randomNumber) {
                JOptionPane.showMessageDialog(null,"Too high to random number ");
            } else if (userinput < randomNumber) {
                JOptionPane.showMessageDialog(null,"Too low to the random number");
            }else{
                System.out.println("Empty number");
            }
        }
        if(userinput != randomNumber){
            System.out.println("Game over you took five chances !!!!");
        }
    }
}