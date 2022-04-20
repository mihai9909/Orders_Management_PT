import Connection.ConnectionFactory;
import DataAccess.ProductDAO;
import DataAccess.ProductDAO;
import Model.Product;
import Presentation.ClientView;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        ProductDAO c = new ProductDAO();

        c.insert(new Product(2,20,"Dovleac",new BigDecimal("22.32")));
        System.out.println(c.find(2).toString());
        Product t = new Product(2,200,"Seminte",new BigDecimal("2.32"));
        c.update(t);
        System.out.println(c.find(2).toString());
        c.deleteProduct(2);

        JFrame frame = new JFrame("Clients");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ClientView());
        frame.pack();
        frame.setVisible(true);
    }
}
