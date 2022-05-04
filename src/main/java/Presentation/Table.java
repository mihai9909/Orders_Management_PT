package Presentation;

import DataAccess.AbstractDAO;

import javax.swing.*;

/**Swing table used to display products / clients / orders*/
public class Table extends JFrame {
    private JScrollPane scrollPane;
    private JTable table;
    private String[] header;
    private String[][] data;
    public Table(String[] header,String [][]data) {
        setSize(300, 500);
        setLayout(null);
        setTitle("Table");
        setLocationRelativeTo(null);
        setResizable(false);

        setVisible(true);

        table = new JTable(data,header);

        table.setCellSelectionEnabled(true);
        table.setBounds(40,50,200,400);
        table.setDefaultEditor(Object.class,null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40,50,200,400);
        add(scrollPane);
    }


    
}
