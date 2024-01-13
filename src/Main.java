//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = random.nextInt(10)+1;
        System.out.println(randomNumber);



    }
}