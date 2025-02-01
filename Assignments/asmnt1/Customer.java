// Customer.java
// Represents a customer who can withdraw cash from an ATM

public class Customer extends Person {
    // Withdraws cash from the ATM if conditions are met
    public void withdrawCash(ATM atm, int amount, Person person) {
        System.out.println("\n\tcurrent inService is --> " + atm.getServiceStatus());

        if (!atm.getServiceStatus()) {
            System.out.println("\n\tATM is not in service\n\n");
            return;
        }

        if (atm.queryCash() < amount) {
            System.out.println("\n\tATM has insufficient cash\n\n");
            return;
        }

        // Proceed with withdrawal process
        String name = person.getName(); // Get customer's name, EXTRA CREDIT ;)
        atm.reader.readCard();
        atm.display.displayPINverification();
        atm.dispenser.dispenseCash(amount);
        atm.printer.printReceipt();
        System.out.print("\n\n\t Costumer --> ( " + name + " )");
        System.out.println("\n\t Has successfully withdrawn ( $" + amount + " ) from ATM\n\n");
    }
}