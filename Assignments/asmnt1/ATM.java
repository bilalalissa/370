// ATM.java
// Represents an ATM with cash storage, service status, and nested components

public class ATM {
    private int cash; // Amount of cash in the ATM
    private boolean inService; // Whether the ATM is in service

    // Default constructor initializing cash to 0 and ATM as out of service
    public ATM() {
        this.cash = 0;
        this.inService = false;
    }

    // Overloaded constructor to initialize ATM with given cash and service status
    public ATM(int cash, boolean inService) {
        this.cash = cash;
        this.inService = inService;
    }

    // Returns the amount of cash inside the ATM
    public int queryCash() {
        return cash;
    }

    // Increases ATM cash by the specified amount
    public void increaseCash(int x) {
        cash += x;
    }

    // Reduces ATM cash by the specified amount
    public void reduceCash(int x) {
        cash -= x;
    }

    // Returns the service status of the ATM
    public boolean getServiceStatus() {
        return inService;
    }

    // Toggles the ATM's service status and prints the new status
    public void changeServiceStatus() {
        inService = !inService;
        System.out.println(" - inService is now --> " + inService);
    }

    // Nested class representing a cash dispenser
    public class CashDispenser {
        // Dispenses cash from the ATM and prints the amount dispensed
        public void dispenseCash(int x) {
            reduceCash(x);
            System.out.println(" - ( $" + x + " ) <-- has been dispensed");
        }
    }

    // Nested class representing a receipt printer
    public class ReceiptPrinter {
        // Prints a receipt message
        public void printReceipt() {
            System.out.println(" - Receipt has been printed");
        }
    }

    // Nested class representing a card reader
    public class CardReader {
        // Simulates reading a card
        public void readCard() {
            System.out.println(" - Card has been read");
        }
    }

    // Nested class representing a keypad and display for PIN verification
    public class KeypadDisplay {
        // Displays PIN verification message
        public void displayPINverification() {
            System.out.println(" - PIN has been verified");
        }
    }

    // Instances of nested classes
    public CashDispenser dispenser = new CashDispenser();
    public ReceiptPrinter printer = new ReceiptPrinter();
    public CardReader reader = new CardReader();
    public KeypadDisplay display = new KeypadDisplay();
}