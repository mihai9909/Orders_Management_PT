package BLL;

import BLL.Validators.PriceValidator;
import BLL.Validators.QuantityValidator;
import BLL.Validators.Validator;
import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {

    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    public ProductBLL(){
        validators = new ArrayList<Validator<Product>>();
        validators.add(new QuantityValidator());
        validators.add(new PriceValidator());

        productDAO = new ProductDAO();
    }

    public void createNewProduct(Product c){
        for (Validator<Product> v: validators) {
            v.validate(c);
        }
        productDAO.createProduct(c);
    }

    public List<Product> findAllProducts(){
        return productDAO.find();
    }

    public Product findProductById(int id){
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return st;
    }

    public void editProduct(Product p){
        if(findProductById(p.getId()) == null){
            throw new NoSuchElementException("Product with id = "+ p.getId() +"does not exist");
        }
        for (Validator<Product> v: validators) {
            v.validate(p);
        }
        productDAO.updateProduct(p);
    }

    public void deleteProduct(int id){
        productDAO.deleteProduct(id);
    }
}
