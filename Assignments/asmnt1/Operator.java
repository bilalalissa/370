// Operator.java
// Represents an operator who manages ATM cash levels

public class Operator extends Person {
    // Adds cash to the ATM if needed and toggles its service status
    public void topUpATM(ATM atm) {
        System.out.println(" - current inService is --> " + atm.getServiceStatus());
        System.out.println(" - current cash is --> ( $" + atm.queryCash() + " )");

        // Ensure the ATM is off before topping up
        if (atm.getServiceStatus()) {
            atm.changeServiceStatus();
        }

        // Top up ATM if cash is below 5000
        if (atm.queryCash() < 5000) {
            atm.increaseCash(5000);
            System.out.println("\t==> ATM now has --> ( $" + atm.queryCash() + " )");
        }

        // Turn ATM back on
        atm.changeServiceStatus();
    }
}