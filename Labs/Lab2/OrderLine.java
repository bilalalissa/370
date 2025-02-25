// OrderLine.java
// OrderLine class
// Purpose: This class represents an order line
// It has a quantity, price, and product
// It is used in the Order class to manage order lines
// It is also used in the Main class to demonstrate the centralized control of pricing logic
// and the use of the ShippingInfo class
// It is also used in the Main class to demonstrate the use of the ExternalService class
// to simulate external pricing and discount logic

public class OrderLine {
    private int quantity;
    private double price;
    private Product product;

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        // For simplicity, store the product price at creation time
        this.price = product.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void printOrderLine() {
        System.out.println("Product: " + product.getName() + 
                           ", Quantity: " + quantity + 
                           ", Price: " + price);
    }
}