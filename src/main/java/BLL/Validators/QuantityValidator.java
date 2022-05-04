package BLL.Validators;

import Model.Product;

/**Validates quantity*/
public class QuantityValidator implements Validator<Product> {
    @Override
    public void validate(Product product) {
        if(product.getStockQuantity() < 0){
            throw new IllegalArgumentException("Invalid quantity");
        }
    }
}
