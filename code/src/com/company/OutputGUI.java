package com.company;
import java.awt.Font;

import javax.swing.*;

public class OutputGUI {
    private JFrame frame;
    JTextArea outputTextArea;

    public OutputGUI() {
        initialize();
        frame.setVisible(true);

    }

    public void addUpdates(String str) {
        outputTextArea.append(str);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBounds(100, 100, 1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("Router Synchronization GUI");
        label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 29));
        label.setBounds(86, 16, 767, 41);
        frame.getContentPane().add(label);

        JLabel lblConnectionBehaviourUpdates = new JLabel("Connection behaviour updates");
        lblConnectionBehaviourUpdates.setFont(new Font("Corbel", Font.PLAIN, 23));
        lblConnectionBehaviourUpdates.setBounds(278, 88, 309, 29);
        frame.getContentPane().add(lblConnectionBehaviourUpdates);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        outputTextArea.setBounds(169, 125, 600, 600);

        frame.getContentPane().add(outputTextArea);
    }
}
