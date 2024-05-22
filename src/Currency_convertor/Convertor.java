package Currency_convertor;

import javax.swing.*;

class Something {

    int rupee = 350;
    int dollar;
    Something(int dollar){
        this.dollar = rupee * dollar;
    }
}
public class Convertor {
    public static void main(String[] args) {

        int dollar =Integer.parseInt(JOptionPane.showInputDialog("Enter $"));
        Something convertor = new Something(dollar);
        JOptionPane.showMessageDialog(null,convertor.dollar);
    }
}