import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberKeypad = new JButton[10];
    JButton[] logicKeypad = new JButton[8];
    JButton[] addB, subB, mulB, divB, decB, eqB, delB, clrB;
    JPanel panel;

    Font currentFont = new Font("Monospaced", Font.BOLD, 50);
    double n1 = 0, n2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
