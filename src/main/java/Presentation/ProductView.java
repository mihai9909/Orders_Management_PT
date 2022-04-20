package Presentation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ProductView extends JPanel {
    private JButton jcomp1;
    private JTextField addID;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JTextField addQuantity;
    private JTextField addName;
    private JTextField addPrice;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JLabel jcomp10;
    private JButton submitBtn;
    private JLabel jcomp12;
    private JLabel jcomp13;
    private JLabel jcomp14;
    private JLabel jcomp15;
    private JLabel jcomp16;
    private JTextField productToEditByID;
    private JTextField editQuantity;
    private JTextField editName;
    private JTextField editPrice;
    private JButton editBtn;
    private JLabel jcomp22;
    private JTextField prodToDelID;
    private JLabel jcomp24;
    private JButton deleteBtn;
    private JButton viewProductsBtn;

    public ProductView() {
        //construct components
        jcomp1 = new JButton("Button 1");
        addID = new JTextField(5);
        jcomp3 = new JLabel("ID");
        jcomp4 = new JLabel("quantity");
        addQuantity = new JTextField(5);
        addName = new JTextField(5);
        addPrice = new JTextField(5);
        jcomp8 = new JLabel("name");
        jcomp9 = new JLabel("price");
        jcomp10 = new JLabel("Add product:");
        submitBtn = new JButton("SUBMIT");
        jcomp12 = new JLabel("Edit Product:");
        jcomp13 = new JLabel("Product ID");
        jcomp14 = new JLabel("new quantity");
        jcomp15 = new JLabel("new name");
        jcomp16 = new JLabel("new price");
        productToEditByID = new JTextField(5);
        editQuantity = new JTextField(5);
        editName = new JTextField(5);
        editPrice = new JTextField(5);
        editBtn = new JButton("EDIT");
        jcomp22 = new JLabel("Delete Product");
        prodToDelID = new JTextField(5);
        jcomp24 = new JLabel("Product ID");
        deleteBtn = new JButton("DELETE");
        viewProductsBtn = new JButton("View Products");

        //adjust size and set layout
        setPreferredSize(new Dimension(1150, 530));
        setLayout(null);

        //add components
        add(jcomp1);
        add(addID);
        add(jcomp3);
        add(jcomp4);
        add(addQuantity);
        add(addName);
        add(addPrice);
        add(jcomp8);
        add(jcomp9);
        add(jcomp10);
        add(submitBtn);
        add(jcomp12);
        add(jcomp13);
        add(jcomp14);
        add(jcomp15);
        add(jcomp16);
        add(productToEditByID);
        add(editQuantity);
        add(editName);
        add(editPrice);
        add(editBtn);
        add(jcomp22);
        add(prodToDelID);
        add(jcomp24);
        add(deleteBtn);
        add(viewProductsBtn);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(-530, -15, 100, 20);
        addID.setBounds(35, 90, 100, 25);
        jcomp3.setBounds(35, 55, 100, 25);
        jcomp4.setBounds(170, 55, 100, 25);
        addQuantity.setBounds(170, 90, 180, 25);
        addName.setBounds(385, 90, 215, 25);
        addPrice.setBounds(630, 90, 200, 25);
        jcomp8.setBounds(385, 55, 100, 25);
        jcomp9.setBounds(630, 55, 100, 25);
        jcomp10.setBounds(35, 20, 100, 25);
        submitBtn.setBounds(985, 90, 100, 25);
        jcomp12.setBounds(35, 135, 100, 25);
        jcomp13.setBounds(35, 170, 100, 25);
        jcomp14.setBounds(170, 170, 100, 25);
        jcomp15.setBounds(385, 170, 100, 25);
        jcomp16.setBounds(630, 170, 100, 25);
        productToEditByID.setBounds(35, 210, 100, 25);
        editQuantity.setBounds(170, 210, 180, 25);
        editName.setBounds(385, 210, 215, 25);
        editPrice.setBounds(630, 210, 200, 25);
        editBtn.setBounds(990, 210, 100, 25);
        jcomp22.setBounds(35, 260, 100, 25);
        prodToDelID.setBounds(35, 335, 100, 25);
        jcomp24.setBounds(35, 295, 100, 25);
        deleteBtn.setBounds(170, 335, 100, 25);
        viewProductsBtn.setBounds(500, 415, 140, 25);
    }
}
