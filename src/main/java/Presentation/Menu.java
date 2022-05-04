package Presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/***Menu view for products*/
public class Menu extends JPanel {
    private JButton clientsBtn;
    private JButton prodBtn;
    private JButton ordBtn;

    /***Initialize components*/
    public Menu() {
        //construct components
        clientsBtn = new JButton ("Clients");
        prodBtn = new JButton ("Products");
        ordBtn = new JButton ("Orders");

        //adjust size and set layout
        setPreferredSize (new Dimension (182, 179));
        setLayout (null);

        //add components
        add (clientsBtn);
        add (prodBtn);
        add (ordBtn);

        //set component bounds (only needed by Absolute Positioning)
        clientsBtn.setBounds (45, 30, 100, 20);
        prodBtn.setBounds (45, 70, 100, 20);
        ordBtn.setBounds (45, 110, 100, 20);

        clientsBtn.addActionListener(new ClientsBtnListener());
        prodBtn.addActionListener(new ProductBtnListener());
        ordBtn.addActionListener(new OrderBtnListener());
    }
    /***Listener for button*/
    public class OrderBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Orders");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new OrderView());
            frame.pack();
            frame.setVisible(true);
        }
    }
    /***Listener for button*/
    public class ProductBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Products");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ProductView());
            frame.pack();
            frame.setVisible(true);
        }
    }
    /****Listener for button*/
    public class ClientsBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Clients");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ClientView());
            frame.pack();
            frame.setVisible(true);
        }
    }
}

