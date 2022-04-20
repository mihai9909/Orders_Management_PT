package DataAccess;

import Model.Order;

import java.util.List;

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
}
