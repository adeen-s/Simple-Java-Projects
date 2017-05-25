import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    private JFrame frame;
    private JTextField disp;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bplus, bminus, bmult, bdiv, beql, bclr;

    static private double a=0,b=0,result=0;
    static private int operator=0;

    public Calculator() {
        frame = new JFrame("Calculator");
        disp = new JTextField();
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bplus = new JButton("+");
        bminus = new JButton("-");
        bmult = new JButton("*");
        bdiv = new JButton("/");
        beql = new JButton("=");
        bclr = new JButton("C");

        disp.setBounds(30, 40, 280, 30);
        b7.setBounds(40, 100, 50, 40);
        b8.setBounds(110, 100, 50, 40);
        b9.setBounds(180, 100, 50, 40);
        bdiv.setBounds(250, 100, 50, 40);

        b4.setBounds(40, 170, 50, 40);
        b5.setBounds(110, 170, 50, 40);
        b6.setBounds(180, 170, 50, 40);
        bmult.setBounds(250, 170, 50, 40);

        b1.setBounds(40, 240, 50, 40);
        b2.setBounds(110, 240, 50, 40);
        b3.setBounds(180, 240, 50, 40);
        bminus.setBounds(250, 240, 50, 40);

        b0.setBounds(110, 310, 50, 40);
        beql.setBounds(180, 310, 50, 40);
        bplus.setBounds(250, 310, 50, 40);

        bclr.setBounds(180,380,100,40);


        frame.add(disp);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);
        frame.add(b0);
        frame.add(bplus);
        frame.add(bminus);
        frame.add(bmult);
        frame.add(bdiv);
        frame.add(beql);
        frame.add(bclr);

        frame.setLayout(null);
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Calculator");
        frame.setVisible(true);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bplus.addActionListener(this);
        bminus.addActionListener(this);
        bmult.addActionListener(this);
        bdiv.addActionListener(this);
        beql.addActionListener(this);
        bclr.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)
            disp.setText(disp.getText().concat("1"));

        if (e.getSource() == b2)
            disp.setText(disp.getText().concat("2"));

        if (e.getSource() == b3)
            disp.setText(disp.getText().concat("3"));

        if (e.getSource() == b4)
            disp.setText(disp.getText().concat("4"));

        if (e.getSource() == b5)
            disp.setText(disp.getText().concat("5"));

        if (e.getSource() == b6)
            disp.setText(disp.getText().concat("6"));

        if (e.getSource() == b7)
            disp.setText(disp.getText().concat("7"));

        if (e.getSource() == b8)
            disp.setText(disp.getText().concat("8"));

        if (e.getSource() == b9)
            disp.setText(disp.getText().concat("9"));

        if (e.getSource() == b0)
            disp.setText(disp.getText().concat("0"));

        if (e.getSource() == bplus) {
            a = Integer.parseInt(disp.getText());
            operator = 1;
            disp.setText("");
        }

        if (e.getSource() == bminus) {
            a = Double.parseDouble(disp.getText());
            operator = 2;
            disp.setText("");
        }

        if (e.getSource() == bmult) {
            a = Double.parseDouble(disp.getText());
            operator = 3;
            disp.setText("");
        }

        if (e.getSource() == bdiv) {
            a = Double.parseDouble(disp.getText());
            operator = 4;
            disp.setText("");
        }

        if (e.getSource() == beql) {
            b = Double.parseDouble(disp.getText());

            switch (operator) {
                case 1:
                    result = a + b;
                    break;

                case 2:
                    result = a - b;
                    break;

                case 3:
                    result = a * b;
                    break;

                case 4:
                    result = a / b;
                    break;

                default:
                    result = 0;
            }

            disp.setText("" + result);
        }

        if (e.getSource() == bclr)
            disp.setText("");

    }

    public static void main(String args[]){
        new Calculator();
    }

}
