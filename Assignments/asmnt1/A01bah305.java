// A01bah305.java
// Main program to simulate an ATM system

import java.util.Scanner;

public class A01bah305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\tWelcome to the ATM System");


        // Prompt user for initial ATM cash
        System.out.println("\n--> Enter a number between 0 and 10000");
        int initialCash = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create two ATM instances
        ATM atm1 = new ATM(); // Default ATM (0 cash, not in service)
        ATM atm2 = new ATM(initialCash, true); // ATM with user-defined cash

        // Create and configure an Operator
        System.out.println("\n--> Enter a name for the Operator");
        String operatorName = scanner.nextLine();
        Operator operator = new Operator();
        operator.setName(operatorName);

        // Process ATM 1
        System.out.println("\nProcessing ATM 1");
        operator.topUpATM(atm1);

        // Process ATM 2
        System.out.println("\nProcessing ATM 2");
        operator.topUpATM(atm2);

        // Create and configure a Customer
        System.out.println("\n--> Enter a name for the Customer");
        String customerName = scanner.nextLine();
        Customer customer = new Customer();
        customer.setName(customerName);

        // Prompt user for withdrawal amount
        System.out.println("\n--> Enter an amount to withdraw");
        int withdrawAmount = scanner.nextInt();

        // Process withdrawal from ATM 2
        customer.withdrawCash(atm2, withdrawAmount, customer);

        // Close scanner
        scanner.close();
    }
}