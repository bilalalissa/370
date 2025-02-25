// Order.java
// Order class
// purpose: This class represents an order
// It has an order ID, date received, price, order lines, customer, and shipping info
// It has methods to add order lines, calculate price, update shipping, and get order ID

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderID;
    private String dateReceived;
    private double price;
    private List<OrderLine> orderLines;
    private Customer customer;
    private ShippingInfo shippingInfo;

    public Order(int orderID, String dateReceived, Customer customer) {
        this.orderID = orderID;
        this.dateReceived = dateReceived;
        this.customer = customer;
        this.orderLines = new ArrayList<>();
    }

    public void addOrderLine(OrderLine line) {
        orderLines.add(line);
    }

    /**
     * This method now centrally controls the pricing logic
     * by interacting with OrderLine, Product, Customer, and ExternalService.
     */
    public double calculatePrice() {
        double basePrice = 0.0;
        // Sum up each line's quantity * product price
        for (OrderLine line : orderLines) {
            basePrice += line.getQuantity() * line.getProduct().getPrice();
        }

        // Possibly call out to an external service for more pricing rules
        ExternalService ext = new ExternalService();
        double updatedPrice = ext.getPricingDetails(basePrice);

        // Retrieve discount from Customer
        int discountRate = customer.getDiscount();
        double discountAmount = ext.getDiscountInfo(discountRate, updatedPrice);

        // Final price
        double finalPrice = updatedPrice - discountAmount;
        this.price = finalPrice;

        return this.price;
    }

    /**
     * Example of shipping update after price is known.
     */
    public void updateShipping() {
        if (shippingInfo != null) {
            // totalAmount could be the final order price
            shippingInfo.setTotalAmount(this.price);
            shippingInfo.updateShipping();
        }
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public double getPrice() {
        return price;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getDateReceived() {
        return dateReceived;
    }
}