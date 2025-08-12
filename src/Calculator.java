import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberKeypad = new JButton[10];
    JButton[] logicKeypad = new JButton[8];
    JButton addB, subB, mulB, divB, decB, eqlB, delB, clrB;
    JPanel panel;

    Font currentFont = new Font("Monospaced", Font.BOLD, 50);
    double n1 = 0, n2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(43,50,350,70);
        textField.setFont(currentFont);
        textField.setEditable(false);

        addB = new JButton("+");
        subB = new JButton("-");
        mulB = new JButton("*");
        divB = new JButton("/");
        decB = new JButton(".");
        eqlB = new JButton("=");
        delB = new JButton("del");
        clrB = new JButton("clr");
        logicKeypad[0] = addB;
        logicKeypad[1] = subB;
        logicKeypad[2] = mulB;
        logicKeypad[3] = divB;
        logicKeypad[4] = decB;
        logicKeypad[5] = eqlB;
        logicKeypad[6] = delB;
        logicKeypad[7] = clrB;

        for (int i = 0; i < 8; i++) {
            logicKeypad[i].addActionListener(this);
            logicKeypad[i].setFont(currentFont);
            logicKeypad[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberKeypad[i] = new JButton(String.valueOf(i));
            numberKeypad[i].addActionListener(this);
            numberKeypad[i].setFont(currentFont);
            numberKeypad[i].setFocusable(false);            
        }

        delB.setBounds(50,430,145,50);
        clrB.setBounds(250,430,145,50);

        frame.add(delB);
        frame.add(clrB);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
