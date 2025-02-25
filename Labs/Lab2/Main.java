
// Main.java
// Main class
// ENSE 374 Lab 2
// Author: Bilal Alissa
// SID: 200384288

// Purpose: This class is the entry point for the program
// It creates a Customer, Order, Products, and OrderLines
// It then calculates the price and updates the shipping cost
// It demonstrates the centralized control of pricing logic
// and the use of the ShippingInfo class
// It also demonstrates the use of the ExternalService class
// to simulate external pricing and discount logic
// It also demonstrates the use of inheritance with the Customer class
// and the CreditCustomer class
// It also demonstrates the use of the Order class to manage an order
// and its associated OrderLines
// It also demonstrates the use of the ShippingInfo class to manage
// shipping information and calculate shipping costs
// It also demonstrates the use of the ExternalService class to simulate
// external pricing and discount logic


public class Main {
    public static void main(String[] args) {
        // Create a Customer (or CreditCustomer)
        Customer customer = new Customer("Alice", "123 Main St", 10);

        // Create an Order
        Order order = new Order(101, "2025-02-24", customer);

        // Create some Products
        Product productA = new Product("Widget", 15.0);
        Product productB = new Product("Gadget", 25.0);

        // Create OrderLines
        OrderLine line1 = new OrderLine(2, productA); // 2 x 15
        OrderLine line2 = new OrderLine(1, productB); // 1 x 25

        // Add lines to Order
        order.addOrderLine(line1);
        order.addOrderLine(line2);

        // Calculate price (centralized control)
        double totalPrice = order.calculatePrice();
        System.out.println("Calculated Order Price: " + totalPrice);

        // Attach ShippingInfo and update shipping cost
        ShippingInfo shippingInfo = new ShippingInfo();
        order.setShippingInfo(shippingInfo);
        order.updateShipping();

        System.out.println("Shipping Cost: " + shippingInfo.getShippingCost());
        System.out.println("Shipping Total Amount: " + shippingInfo.getTotalAmount());
    }
}