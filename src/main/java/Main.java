import Connection.ConnectionFactory;
import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import Model.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        try {
            Connection c = ConnectionFactory.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM products WHERE id = 1");
            //System.out.println(rs.getString("price"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ProductDAO p = new ProductDAO();

        p.insert(new Product(1,10,"Mandarine",new BigDecimal("1.99")));
        System.out.println(p.find(1).toString());
        Product t = new Product(1,9,"Mandarine",new BigDecimal("1.99"));
        p.update(t);
        System.out.println(p.find(1).toString());
        p.deleteProduct(1);
    }

}
