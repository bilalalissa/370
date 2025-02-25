// CreditCustomer.java
// CreditCustomer class that extends Customer class

public class CreditCustomer extends Customer {
    
    public CreditCustomer(String customerName, String address, int discount) {
        super(customerName, address, discount);
    }

    // Additional credit-specific logic could go here
}