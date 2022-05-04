package Presentation;

import DataAccess.*;
import Model.Client;
import Model.Order;
import Model.Product;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/***Panel to perform the order operations*/
public class OrderView extends JPanel {
    private JButton jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JButton orderBtn;
    private JComboBox clientAdd;
    private JComboBox productAdd;
    private JTextField addQuantity;
    private JLabel jcomp8;

    private AbstractDAO<Client> clientDAO;
    private AbstractDAO<Product> productDAO;

    private List<Client> clientList;
    private List<Product> productList;

    String[] sProducts;

    public OrderView() {
        clientDAO = new ClientDAO();
        productDAO = new ProductDAO();

        //construct preComponents
        clientList = clientDAO.findAll();
        productList = productDAO.findAll();

        String[] sClients = new String[clientList.size()];
        sProducts = new String[productList.size()];

        for(int i = 0;i < clientList.size();i++){
            sClients[i] = clientList.get(i).toString();
        }
        for(int j = 0;j < productList.size();j++){
            sProducts[j] = productList.get(j).toString();
        }

        //construct components
        jcomp1 = new JButton("Button 1");
        jcomp2 = new JLabel("Client");
        jcomp3 = new JLabel("Product:");
        orderBtn = new JButton("Order");
        clientAdd = new JComboBox(sClients);
        productAdd = new JComboBox(sProducts);
        addQuantity = new JTextField(5);
        jcomp8 = new JLabel("Quantity:");

        //adjust size and set layout
        setPreferredSize(new Dimension(1150, 530));
        setLayout(null);

        //add components
        add(jcomp1);
        add(jcomp2);
        add(jcomp3);
        add(orderBtn);
        add(clientAdd);
        add(productAdd);
        add(addQuantity);
        add(jcomp8);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(-530, -15, 100, 20);
        jcomp2.setBounds(35, 55, 100, 25);
        jcomp3.setBounds(35, 170, 100, 25);
        orderBtn.setBounds(500, 415, 140, 25);
        clientAdd.setBounds(35, 90, 800, 25);
        productAdd.setBounds(35, 205, 800, 25);
        addQuantity.setBounds(35, 325, 100, 25);
        jcomp8.setBounds(35, 290, 100, 25);

        orderBtn.addActionListener(new OrderBtnListener());
    }

    class OrderBtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            OrderDAO orderDAO = new OrderDAO();
            ProductDAO productDAO = new ProductDAO();

            int clientIndex = clientAdd.getSelectedIndex();
            int prodIndex = productAdd.getSelectedIndex();

            if(clientIndex == -1 || prodIndex == -1) {
                System.err.println("Select product or client");
                return;
            }

            int quantity;
            try{
                quantity = Integer.parseInt(addQuantity.getText());
            } catch (NumberFormatException exception){
                System.err.println("Please enter a number");
                return;
            }

            Product p = productList.get(prodIndex);
            if(p.getStockQuantity() < quantity || quantity <= 0){
                System.err.println("Invalid amount");
                System.out.println("In stock: " + p.getStockQuantity());
                return;
            }

            int productID = p.getId();
            int clientID = clientList.get(clientIndex).getId();

            Order o = new Order(orderDAO.nbOrders()+1,clientID,productID,quantity);
            orderDAO.createOrder(o);
            Product updatedProduct = new Product(p.getId(),p.getStockQuantity()-quantity,p.getName(),p.getPrice());
            productDAO.update(updatedProduct);

            productList = productDAO.findAll();
            for(int j = 0;j < productList.size();j++){
                sProducts[j] = productList.get(j).toString();
            }
            productAdd = new JComboBox(sProducts);
        }
    }
}
