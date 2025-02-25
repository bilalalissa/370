// Customer.java
// Customer class
// purpose: This class represents a customer
// It has a name, address, and discount rate
// It is used in the Order class to associate an order with a customer
// It is also used in the ExternalService class to simulate external pricing and discount logic
// It is also used in the Main class to demonstrate inheritance
// It is also used in the Main class to demonstrate the centralized control of pricing logic
// It is also used in the Main class to demonstrate the use of the ShippingInfo class
// It is also used in the Main class to demonstrate the use of the ExternalService class
// It is also used in the Main class to demonstrate the use of inheritance with the Customer class
// and the CreditCustomer class

public class Customer {
    private String customerName;
    private String address;
    private int discount; // in percentage

    public Customer(String customerName, String address, int discount) {
        this.customerName = customerName;
        this.address = address;
        this.discount = discount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public int getDiscount() {
        return discount;
    }
}