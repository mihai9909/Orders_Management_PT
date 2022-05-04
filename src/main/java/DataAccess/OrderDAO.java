package DataAccess;

import Model.Order;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class OrderDAO extends AbstractDAO<Order> {

    public Order find(int id){
        return findById(id);
    }

    public List<Order> find(){
        return findAll();
    }

    public void createOrder(Order p){
        insert(p);
    }

    public void updateOrder(Order p){
        update(p);
    }

    public void deleteOrder(int id){
        deleteById(id);
    }

    public int nbOrders(){
        int nb=0;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT COUNT(id) FROM orders";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }


        return nb;
    }
}
