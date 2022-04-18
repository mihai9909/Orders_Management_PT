package DataAccess;

import Model.Product;

import java.math.BigDecimal;

public class ProductDAO extends AbstractDAO<Product>{

    public Product find(int id){
        return findById(id);
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
