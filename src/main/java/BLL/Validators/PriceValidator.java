package BLL.Validators;

import Model.Product;

/**Validates product price*/
public class PriceValidator implements Validator<Product>{
    @Override
    public void validate(Product product) {
        if(product.getPrice().floatValue() < 0){
            throw new IllegalArgumentException("Invalid Price");
        }
    }
}
