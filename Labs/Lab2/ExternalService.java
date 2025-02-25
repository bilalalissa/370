// ExternalService.java
// ExternalService class
// purpose: This class simulates an external service that provides pricing and discount information
// It is used in the Order class to simulate external pricing and discount logic
// It is also used in the Main class to demonstrate the centralized control of pricing logic
// It is also used in the Main class to demonstrate the use of the ShippingInfo class
// It is also used in the Main class to demonstrate the use of the ExternalService class
// It is also used in the Main class to demonstrate inheritance with the Customer class
// and the CreditCustomer class
// It is also used in the Main class to demonstrate the use of the Order class to manage an order
// and its associated OrderLines

public class ExternalService {

    public ExternalService() {
    }

    /**
     * Simulates external logic that returns a "revised" price 
     * based on base price (e.g., tax rules, promotions, etc.).
     */
    public double getPricingDetails(double basePrice) {
        // In a real scenario, you might call an external API.
        // For now, assume no change to basePrice:
        return basePrice;
    }

    /**
     * Simulates external logic for discount calculation
     */
    public double getDiscountInfo(int discountRate, double price) {
        // discountRate is a percentage
        return (price * discountRate) / 100.0;
    }
}