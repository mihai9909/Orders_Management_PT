package Presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class OrderView extends JPanel {
    private JButton jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JButton viewProductsBtn;
    private JComboBox jcomp5;
    private JComboBox jcomp6;
    private JTextField jcomp7;
    private JLabel jcomp8;

    public OrderView() {
        //construct preComponents
        String[] jcomp5Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp6Items = {"Item 1", "Item 2", "Item 3"};

        //construct components
        jcomp1 = new JButton("Button 1");
        jcomp2 = new JLabel("Client");
        jcomp3 = new JLabel("Product:");
        viewProductsBtn = new JButton("View Products");
        jcomp5 = new JComboBox(jcomp5Items);
        jcomp6 = new JComboBox(jcomp6Items);
        jcomp7 = new JTextField(5);
        jcomp8 = new JLabel("Quantity:");

        //adjust size and set layout
        setPreferredSize(new Dimension(1150, 530));
        setLayout(null);

        //add components
        add(jcomp1);
        add(jcomp2);
        add(jcomp3);
        add(viewProductsBtn);
        add(jcomp5);
        add(jcomp6);
        add(jcomp7);
        add(jcomp8);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(-530, -15, 100, 20);
        jcomp2.setBounds(35, 55, 100, 25);
        jcomp3.setBounds(35, 170, 100, 25);
        viewProductsBtn.setBounds(500, 415, 140, 25);
        jcomp5.setBounds(35, 90, 100, 25);
        jcomp6.setBounds(35, 205, 100, 25);
        jcomp7.setBounds(35, 325, 100, 25);
        jcomp8.setBounds(35, 290, 100, 25);
    }
}
