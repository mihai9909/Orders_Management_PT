package Presentation;


import BLL.ClientBLL;
import DataAccess.AbstractDAO;
import DataAccess.ClientDAO;
import Model.Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**Panel to perform the client operations*/
public class ClientView extends JPanel {
    private JButton jcomp1;
    private JTextField addID;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JTextField addName;
    private JTextField addAddress;
    private JTextField addEmail;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JLabel jcomp10;
    private JTextField addAge;
    private JLabel jcomp12;
    private JButton submitBtn;
    private JLabel jcomp14;
    private JLabel jcomp15;
    private JLabel jcomp16;
    private JLabel jcomp17;
    private JLabel jcomp18;
    private JLabel jcomp19;
    private JTextField clientToEditByID;
    private JTextField editName;
    private JTextField editAddress;
    private JTextField editEmail;
    private JTextField editAge;
    private JButton editBtn;
    private JLabel jcomp26;
    private JTextField deleteByID;
    private JLabel jcomp28;
    private JButton deleteBtn;
    private JButton viewClientsBtn;

    AbstractDAO clientDAO;

    ClientBLL clientBLL;

    public ClientView() {

        clientDAO = new ClientDAO();

        //construct components
        jcomp1 = new JButton ("Button 1");
        addID = new JTextField (5);
        jcomp3 = new JLabel ("ID");
        jcomp4 = new JLabel ("name");
        addName = new JTextField (5);
        addAddress = new JTextField (5);
        addEmail = new JTextField (5);
        jcomp8 = new JLabel ("address");
        jcomp9 = new JLabel ("email");
        jcomp10 = new JLabel ("Add client:");
        addAge = new JTextField (5);
        jcomp12 = new JLabel ("age");
        submitBtn = new JButton ("SUBMIT");
        jcomp14 = new JLabel ("Edit Client");
        jcomp15 = new JLabel ("Client ID");
        jcomp16 = new JLabel ("new name");
        jcomp17 = new JLabel ("new address");
        jcomp18 = new JLabel ("new email");
        jcomp19 = new JLabel ("new age");
        clientToEditByID = new JTextField (5);
        editName = new JTextField (5);
        editAddress = new JTextField (5);
        editEmail = new JTextField (5);
        editAge = new JTextField (5);
        editBtn = new JButton ("EDIT");
        jcomp26 = new JLabel ("Delete Client");
        deleteByID = new JTextField (5);
        jcomp28 = new JLabel ("Client ID");
        deleteBtn = new JButton ("DELETE");
        viewClientsBtn = new JButton ("View Clients");

        //adjust size and set layout
        setPreferredSize (new Dimension (1150, 530));
        setLayout (null);

        //add components
        add (jcomp1);
        add (addID);
        add (jcomp3);
        add (jcomp4);
        add (addName);
        add (addAddress);
        add (addEmail);
        add (jcomp8);
        add (jcomp9);
        add (jcomp10);
        add (addAge);
        add (jcomp12);
        add (submitBtn);
        add (jcomp14);
        add (jcomp15);
        add (jcomp16);
        add (jcomp17);
        add (jcomp18);
        add (jcomp19);
        add (clientToEditByID);
        add (editName);
        add (editAddress);
        add (editEmail);
        add (editAge);
        add (editBtn);
        add (jcomp26);
        add (deleteByID);
        add (jcomp28);
        add (deleteBtn);
        add (viewClientsBtn);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (-530, -15, 100, 20);
        addID.setBounds (35, 90, 100, 25);
        jcomp3.setBounds (35, 55, 100, 25);
        jcomp4.setBounds (170, 55, 100, 25);
        addName.setBounds (170, 90, 180, 25);
        addAddress.setBounds (385, 90, 215, 25);
        addEmail.setBounds (630, 90, 200, 25);
        jcomp8.setBounds (385, 55, 100, 25);
        jcomp9.setBounds (630, 55, 100, 25);
        jcomp10.setBounds (35, 20, 100, 25);
        addAge.setBounds (870, 90, 70, 25);
        jcomp12.setBounds (870, 55, 100, 25);
        submitBtn.setBounds (985, 90, 100, 25);
        jcomp14.setBounds (35, 135, 100, 25);
        jcomp15.setBounds (35, 170, 100, 25);
        jcomp16.setBounds (170, 170, 100, 25);
        jcomp17.setBounds (385, 170, 100, 25);
        jcomp18.setBounds (630, 170, 100, 25);
        jcomp19.setBounds (870, 170, 100, 25);
        clientToEditByID.setBounds (35, 210, 100, 25);
        editName.setBounds (170, 210, 180, 25);
        editAddress.setBounds (385, 210, 215, 25);
        editEmail.setBounds (630, 210, 200, 25);
        editAge.setBounds (870, 210, 70, 25);
        editBtn.setBounds (990, 210, 100, 25);
        jcomp26.setBounds (35, 260, 100, 25);
        deleteByID.setBounds (35, 335, 100, 25);
        jcomp28.setBounds (35, 295, 100, 25);
        deleteBtn.setBounds (170, 335, 100, 25);
        viewClientsBtn.setBounds (500, 415, 140, 25);

        submitBtn.addActionListener(new SubmitBtnListener());
        editBtn.addActionListener(new EditBtnListener());
        deleteBtn.addActionListener(new DeleteBtnListener());
        viewClientsBtn.addActionListener(new ViewClientsListener());

        clientBLL = new ClientBLL();
    }

    public class SubmitBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = addName.getText();
            String addr = addAddress.getText();
            String email = addEmail.getText();
            int age = 0;
            int id = 0;
            try {
                id = Integer.parseInt(addID.getText());
                age = Integer.parseInt(addAge.getText());
            }catch (NumberFormatException exception){
                System.err.println("Invalid age or ID");
                return;
            }

            Client c = new Client(id,name,addr,email,age);
            clientBLL.createNewClient(c);
        }
    }

    public class EditBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = editName.getText();
            String addr = editAddress.getText();
            String email = editEmail.getText();
            int age = 0;
            int id = 0;
            try {
                id = Integer.parseInt(clientToEditByID.getText());
                age = Integer.parseInt(editAge.getText());
            }catch (NumberFormatException exception){
                System.err.println("Invalid age or ID");
                exception.printStackTrace();
                return;
            }

            Client c = new Client(id,name,addr,email,age);

            clientBLL.editClient(c);
        }
    }

    public class DeleteBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            try{
                id = Integer.parseInt(deleteByID.getText());
            }catch (NumberFormatException exception){
                System.err.println("Invalid id");
                return;
            }
            clientBLL.deleteClient(id);
        }
    }

    public class ViewClientsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new Table(clientDAO.getHeader(), clientDAO.getData());
        }
    }
}
