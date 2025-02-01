# Assignment A01 - Java Refresher

## Course: ENSE 370 - Software Systems Design

## Author: Bilal Alissa

## Filename Convention: A01bah305.java

## Description

This Java program simulates an **ATM system** that interacts with an **Operator** and a **Customer**.It demonstrates key **Object-Oriented Programming (OOP)** concepts including:

- **Encapsulation**: Use of private data members with public accessors and mutators.
- **Inheritance**: `Customer` and `Operator` classes inherit from `Person`.
- **Nested Classes**: `ATM` contains inner classes for `CardReader`, `ReceiptPrinter`, etc.
- **Polymorphism**: Overriding methods in child classes to customize behavior.

## File Structure

The program consists of five Java files:

### **1. ATM.java** - Represents an ATM with its functionalities

```java
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
    public ATM(int cash, boolean i...
```

This file contains:

- Cash and service status variables.
- Methods to query, increase, and decrease cash.
- Methods to toggle service status.
- **Nested classes**: `CashDispenser`, `ReceiptPrinter`, `CardReader`, `KeypadDisplay`.

### **2. Person.java** - Defines a general person

```java
// Person.java
// Represents a person with a name

public class Person {
    protected String name; // Name of the person

    // Default constructor initializing name to "Unknown"
    public Person() {
        this.name = "Unknown";
    }

    // Returns the person's name
    public String getName() {
        return name;
    }

    // Sets the person's name and prints it
    public void setName(String nameString) {
        this.name = nameString;
        System.out.println("\n--> The name is s...
```

This file contains:

- A `name` variable for storing a person's name.
- Getter and setter methods for the name.

### **3. Operator.java** - Represents an ATM Operator (inherits from Person)

```java
// Operator.java
// Represents an operator who manages ATM cash levels

public class Operator extends Person {
    // Adds cash to the ATM if needed and toggles its service status
    public void topUpATM(ATM atm) {
        System.out.println(" - current inService is --> " + atm.getServiceStatus());
        System.out.println(" - current cash is --> ( $" + atm.queryCash() + " )");

        // Ensure the ATM is off before topping up
        if (atm.getServiceStatus()) {
            atm.changeServ...
```

This file contains:

- A `topUpATM(ATM atm)` method to refill the ATM when cash is low.
- Ensures the ATM is off before refilling and turns it back on afterward.

### **4. Customer.java** - Represents an ATM Customer (inherits from Person)

```java
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

        if (atm.queryCash() < amount) ...
```

This file contains:

- A `withdrawCash(ATM atm, int amount)` method to withdraw cash.
- Performs card reading, PIN verification, cash dispensing, and receipt printing.

### **5. A01bah305.java** - Main program file

```java
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

        // Create...
```

This file:

- Takes user input for the ATM cash amount.
- Creates an Operator and a Customer with user-defined names.
- Allows the Operator to top up the ATM.
- Allows the Customer to withdraw cash if sufficient balance exists.

## Compilation & Execution

### **1. Compile the Java Files**

Since the program consists of five Java files, compile them all together using:

```sh
javac ATM.java Person.java Operator.java Customer.java A01bah305.java
```

### **2. Run the Program**

After compilation, execute the program using:

```sh
java A01bah305
```

### **3. Example Output**

```sh


        Welcome to the ATM System

--> Enter a number between 0 and 10000
8000

--> Enter a name for the Operator
John

--> The name is set to --> ( John )

Processing ATM 1
 - current inService is --> false
 - current cash is --> ( $0 )
        ==> ATM now has --> ( $5000 )
 - inService is now --> true

Processing ATM 2
 - current inService is --> true
 - current cash is --> ( $8000 )
 - inService is now --> false
 - inService is now --> true

--> Enter a name for the Customer
Mary

--> The name is set to --> ( Mary )

--> Enter an amount to withdraw
2000

        current inService is --> true
 - Card has been read
 - PIN has been verified
 - ( $2000 ) <-- has been dispensed
 - Receipt has been printed


         Costumer --> ( Mary )
         Has successfully withdrawn ( $2000 ) from ATM


```

## Debugging Tips

If you encounter errors while compiling:

- Ensure all Java files are in the same directory.
- Check that your file names match exactly (`ATM.java`, `Person.java`, etc.).
- Ensure you have Java installed. You can check by running:

```sh
java -version
```

If Java is not installed, install it using:

- **Ubuntu/Linux**: `sudo apt install openjdk-17-jdk`
- **Mac**: `brew install openjdk`
- **Windows**: Download and install from [Oracle Java](https://www.oracle.com/java/technologies/javase-downloads.html).

## Submission Instructions

If you are submitting on Snoopy, use:

```sh
~ense370/bin/submit A01 ATM.java Person.java Operator.java Customer.java A01bah305.java
```

---

**End of README**
