package DataAccess;

import Model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product>{

    public Product find(int id){
        return findById(id);
    }

    public List<Product> find(){
        return findAll();
    }

    public void createProduct(Product p){
        insert(p);
    }

    public void updateProduct(Product p){
        update(p);
    }

    public void deleteProduct(int id){
        deleteById(id);
    }
}
