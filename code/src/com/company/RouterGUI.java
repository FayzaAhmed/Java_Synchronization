package com.company;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RouterGUI extends JFrame {

    private JTextField ConnectionsTextField; //takes number of connections
    private JTextField DevicesTextField; //takes the number of devices

    public RouterGUI() throws InterruptedException {

        this.setBounds(100, 100, 1000, 619);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setTitle("Router Synchronization");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Router Synchronization GUI");
        label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 29));
        label.setBounds(106, 0, 767, 106);
        this.getContentPane().add(label);
        this.setResizable(false);
        this.setVisible(true);

        JLabel label1= new JLabel("What is the number of WI-FI Connections?");
        label1.setFont(new Font("Corbel", Font.PLAIN, 23));
        label1.setBounds(50, 112, 568, 20);
        this.getContentPane().add(label1);

        JLabel label2 = new JLabel("What is the number of devices Clients want to connect?");
        label2.setFont(new Font("Corbel", Font.PLAIN, 23));
        label2.setBounds(50, 188, 568, 20);
        this.getContentPane().add(label2);

        JLabel label3 = new JLabel("Enter the names of the devices:");
        label3.setFont(new Font("Corbel", Font.PLAIN, 23));
        label3.setBounds(50, 260, 384, 20);
        this.getContentPane().add(label3);

        JLabel label4 = new JLabel("Enter the types of the devices:");
        label4.setFont(new Font("Corbel", Font.PLAIN, 23));
        label4.setBounds(509, 260, 568, 20);
        this.getContentPane().add(label4);

        ConnectionsTextField = new JTextField();
        ConnectionsTextField.setBounds(72, 137, 344, 26);
        this.getContentPane().add(ConnectionsTextField);
        ConnectionsTextField.setColumns(10);
        ConnectionsTextField.setVisible(true);
        ConnectionsTextField.requestFocus();

        DevicesTextField = new JTextField();
        DevicesTextField.setColumns(10);
        DevicesTextField.setBounds(72, 218, 344, 26);
        this.getContentPane().add(DevicesTextField);
        DevicesTextField.requestFocus();

        JTextArea NamesTextArea = new JTextArea();
        NamesTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        NamesTextArea.setBounds(72, 293, 344, 106);
        NamesTextArea.setRows(100);
        this.getContentPane().add(NamesTextArea);
        NamesTextArea.requestFocus();

        JTextArea TypesTextArea = new JTextArea();
        TypesTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        TypesTextArea.setBounds(519, 293, 344, 106);
        TypesTextArea.setRows(100);
        this.getContentPane().add(TypesTextArea);
        TypesTextArea.requestFocus();

        JButton btnNewButton = new JButton("  Start ");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Network.N = Integer.parseInt(ConnectionsTextField.getText());
                Network.TC = Integer.parseInt(DevicesTextField.getText());
                String[] names = NamesTextArea.getText().split("\s");
                String[] types = TypesTextArea.getText().split("\s");
                for (int i = 0; i < Integer.parseInt(DevicesTextField.getText()); i++) {
                    Network.devices.add(new Device(names[i], types[i]));
                }

                for (int j = 0; j < Network.N; j++) {
                    Network.names.add("");
                    Network.state.add(false);
                }

                Router routerClass = new Router();
                try {
                    routerClass.connect();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(298, 440, 360, 65);
        btnNewButton.requestFocus();
        this.getContentPane().add(btnNewButton);

    }

}