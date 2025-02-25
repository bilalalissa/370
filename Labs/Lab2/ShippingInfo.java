public class ShippingInfo {
    private double shippingCost;
    private double totalAmount;

    public ShippingInfo() {
        this.shippingCost = 0.0;
        this.totalAmount = 0.0;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void updateShipping() {
        // Simple logic: shipping cost is 5% of totalAmount
        this.shippingCost = this.totalAmount * 0.05;
    }
}