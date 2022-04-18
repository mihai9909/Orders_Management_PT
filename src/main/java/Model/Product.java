package Model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private int stockQuantity;
    private String name;
    private BigDecimal price;

    public Product(){}

    public Product(int id, int stockQuantity, String name,BigDecimal price) {
        this.id = id;
        this.stockQuantity = stockQuantity;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", quantity=" + stockQuantity + ", price=" + price + "]";
    }

}
