import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        int dollar =Integer.parseInt(JOptionPane.showInputDialog("Enter $"));
        convertor Convertor = new convertor(dollar);

//        System.out.println(Convertor.dollar);

        JOptionPane.showMessageDialog(null,Convertor.dollar);
    }
}