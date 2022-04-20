package Model;

public class Order {
    int id;
    int client;
    int product;
    int quantity;

    public Order() {
    }

    public Order(int id, int client, int product,int quantity) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Order [id=" + id + ", clientId=" + client + ", product=" + product + ", quantity=" + quantity + "]";
    }
}
