import Connection.ConnectionFactory;
import DataAccess.AbstractDAO;
import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Product;
import Presentation.ClientView;
import Presentation.ProductView;
import Presentation.Table;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Clients");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ClientView());
        frame.pack();
        frame.setVisible(true);
    }
}
