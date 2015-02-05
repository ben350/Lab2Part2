/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dectobinary;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author benjamin.ramirez006
 */
public class DecToBinary extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    private JTextField decInput;
    private JTextField outputText;

    public DecToBinary() {

        setTitle("Adding Machine");
        addWindowListener(new WindowDestroyer());
        setSize(WIDTH, HEIGHT);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //top panel
        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(new FlowLayout());

        JLabel entryLabel = new JLabel("Enter a non-negative decimal Integer:");
        entryPanel.add(entryLabel);

        decInput = new JTextField("", 10);
        entryPanel.add(decInput);

        contentPane.add(entryPanel, BorderLayout.NORTH);

        //output label
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout());

        JLabel outputLabel = new JLabel("The equivalent binary number is:");
        outputPanel.add(outputLabel);

        outputText = new JTextField("", 30);
        outputPanel.add(outputText);

        contentPane.add(outputPanel, BorderLayout.CENTER);

        //buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton convert = new JButton("Convert");
        convert.addActionListener(this);
        buttonPanel.add(convert);

        JButton clear = new JButton("Clear");
        clear.addActionListener(this);
        buttonPanel.add(clear);

        JButton exit = new JButton("Exit");
        exit.addActionListener(this);
        buttonPanel.add(exit);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        DecToBinary window = new DecToBinary();
        window.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Convert")) {
            try {
                int input = Integer.parseInt(decInput.getText());
                if (input > 0) {

                    int remainder = 0;
                    StringBuffer output = new StringBuffer("");
                    while (input > 0) {
                        remainder = input % 2;
                        input = input / 2;

                        output.insert(0, remainder);
                        System.out.println(output);

                    }
                    
                    outputText.setText(output.toString());

                }
                else {
                    outputText.setText("PUT IN A NON NEGATIVE NUMBER");
                }
            } catch (NumberFormatException e2) {
                outputText.setText("PUT IN A NON NEGATIVE NUMBER");

            }
        } else if (e.getActionCommand().equals("Clear")) {
            outputText.setText("");
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }

}
