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

/**Class used to perform validations on the product before running the CRUD operations*/
public class ProductBLL {

    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    public ProductBLL(){
        validators = new ArrayList<Validator<Product>>();
        validators.add(new QuantityValidator());
        validators.add(new PriceValidator());

        productDAO = new ProductDAO();
    }
    /**Validate then create*/
    public void createNewProduct(Product c){
        for (Validator<Product> v: validators) {
            v.validate(c);
        }
        productDAO.createProduct(c);
    }

    /**Read then return the result*/
    public Product findProductById(int id){
        Product st = productDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return st;
    }
    /**Validate then update*/
    public void editProduct(Product p){
        if(findProductById(p.getId()) == null){
            throw new NoSuchElementException("Product with id = "+ p.getId() +"does not exist");
        }
        for (Validator<Product> v: validators) {
            v.validate(p);
        }
        productDAO.updateProduct(p);
    }
    /**Delete*/
    public void deleteProduct(int id){
        productDAO.deleteProduct(id);
    }
}
