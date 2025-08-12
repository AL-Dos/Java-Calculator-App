import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{
    // variables
    JFrame frame;
    JTextField textField;
    JButton[] numberKeypad = new JButton[10];
    JButton[] logicKeypad = new JButton[9];
    JButton addB, subB, mulB, divB, decB, eqlB, delB, clrB, negB;
    JPanel panel;

    Font currentFont = new Font("Monospaced", Font.PLAIN, 50);
    double n1 = 0, n2 = 0, result = 0;
    char operator;

    // setting up the calculator
    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(33,50,370,60);
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
        negB = new JButton("(-)");
        logicKeypad[0] = addB;
        logicKeypad[1] = subB;
        logicKeypad[2] = mulB;
        logicKeypad[3] = divB;
        logicKeypad[4] = decB;
        logicKeypad[5] = eqlB;
        logicKeypad[6] = delB;
        logicKeypad[7] = clrB;
        logicKeypad[8] = negB;

        for (int i = 0; i < 9; i++) {
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

        negB.setBounds(10,480,135,50);
        delB.setBounds(150,480,135,50);
        clrB.setBounds(290,480,135,50);

        panel = new JPanel();
        panel.setBounds(50, 150, 340, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);
        panel.setForeground(Color.BLACK);

        panel.add(numberKeypad[1]);
        panel.add(numberKeypad[2]);
        panel.add(numberKeypad[3]);
        panel.add(addB);
        panel.add(numberKeypad[4]);
        panel.add(numberKeypad[5]);
        panel.add(numberKeypad[6]);
        panel.add(subB);
        panel.add(numberKeypad[7]);
        panel.add(numberKeypad[8]);
        panel.add(numberKeypad[9]);
        panel.add(mulB);
        panel.add(decB);
        panel.add(numberKeypad[0]);
        panel.add(eqlB);
        panel.add(divB);

        frame.add(panel);
        frame.add(delB);
        frame.add(clrB);
        frame.add(negB);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        Calculator cal = new Calculator();
    }

    // function on how the calculator works
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberKeypad[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decB) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addB) {
            n1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subB) {
            n1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulB) {
            n1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divB) {
            n1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == eqlB) {
            n2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '*':
                    result = n1 * n2;
                case '/':
                    result = n1 / n2;
            }
            textField.setText(String.valueOf(result));
            n1 = result;
        }   
        if (e.getSource() == clrB) {
            textField.setText("");
        }    
        if (e.getSource() == delB) {
            String delete = textField.getText();
            textField.setText("");
            for (int i = 0; i < delete.length() - 1; i++) {
                textField.setText(textField.getText()+delete.charAt(i));
            }
        }
        if (e.getSource() == negB) {
            double negative = Double.parseDouble(textField.getText());
            negative *= -1;
            textField.setText(String.valueOf(negative));
        }            
    }
}
