# Order Management System

This project implements a simple Order Management System based on the class and sequence diagrams inspired by *UML Distilled* (3rd ed.) by Martin Fowler. The system demonstrates the “centralized control” design pattern for calculating the total price of an order (including discounts and shipping costs).

**Table of Contents**

**1.**	[Overview](#overview)

**2.**	[Features](#features)

**3.**	[Class Diagram](#class-diagram)

**4.**	[Sequence Diagram](#sequence-diagram)

**5.**	[Installation and Usage](#installation-and-usage)

**6.**	[Example Usage](#example-usage)

**7.**	[License](#license)


## Overview

The application models a simple ordering process with the following classes:

**•**	**Order**: Central “controller” that manages **OrderLine** items and coordinates pricing logic.

**•**	**OrderLine**: Represents a line item in an order, linking a **Product** to a specified quantity.

**•**	**Product**: Contains product name and price.

**•**	**Customer**: Basic customer information (e.g., name, address, discount rate).

**•**	**CreditCustomer**: Specialized customer type for credit customers (inherits from **Customer**).

**•**	**ShippingInfo**: Manages shipping cost and total amount.

**•**	**ExternalService**: Simulates external logic for pricing and discount calculations.

The code demonstrates how **Order** orchestrates the calls to **OrderLine**, **Product**, **Customer**, and **ExternalService** in a centralized manner to compute the final price of an order.

## Features

**•**	**Centralized Price Calculation**: **Order** calculates the total price by:

**1.**	Iterating over each **OrderLine**.

**2.**	Summing up each product’s price multiplied by its quantity.

**3.**	Applying any external pricing modifications (tax, promotions, etc.).

**4.**	Applying a discount from the **Customer**.

**•**	**Flexible Discounts**: **Customer** can hold a discount percentage; a specialized **CreditCustomer** can extend this logic further.

**•**	**Shipping Cost Calculation**: **ShippingInfo** updates shipping costs based on the order’s total amount.

**•**	**Extensible Design**: The presence of an **ExternalService** class allows you to integrate real external APIs or complex pricing logic in the future.

## Class Diagram

Below is the class diagram in PlantUML. You can copy and paste it into any [PlantUML](https://plantuml.com) renderer to visualize it:

```
@startuml
skinparam classAttributeIconSize 0

title Final Class Diagram

class Order {
    - orderID : int
    - dateReceived : String
    - price : double
    - orderLines : List<OrderLine>
    - customer : Customer
    - shippingInfo : ShippingInfo
    + Order(int, String, Customer)
    + calculatePrice() : double
    + addOrderLine(OrderLine) : void
    + updateShipping() : void
}

class ShippingInfo {
    - shippingCost : double
    - totalAmount : double
    + ShippingInfo()
    + getShippingCost() : double
    + setShippingCost(double) : void
    + getTotalAmount() : double
    + setTotalAmount(double) : void
    + updateShipping() : void
}

class Customer {
    - customerName : String
    - address : String
    - discount : int
    + Customer(String, String, int)
    + getCustomerName() : String
    + getAddress() : String
    + getDiscount() : int
}

class CreditCustomer extends Customer {
    + CreditCustomer(String, String, int)
}

class OrderLine {
    - quantity : int
    - price : double
    - product : Product
    + OrderLine(int, Product)
    + getQuantity() : int
    + getPrice() : double
    + getProduct() : Product
    + printOrderLine() : void
}

class Product {
    - name : String
    - price : double
    + Product(String, double)
    + getName() : String
    + getPrice() : double
}

class ExternalService {
    + ExternalService()
    + getPricingDetails(double) : double
    + getDiscountInfo(int, double) : double
}

' Associations
Order --> "1" Customer
Order --> "1" ShippingInfo
Order -> "1..*" OrderLine
OrderLine --> "1" Product
CreditCustomer --|> Customer
@enduml
```
![Class Diagram](https://arc.net/l/quote/zsjqeb)

## Sequence Diagram

The sequence diagram below shows how **Order** acts as the central controller when calculating the final price.

```
@startuml
title Centralized Control - calculatePrice()

actor "User" as user
participant "Order" as o
participant "ExternalService" as ext
participant "OrderLine" as ol
participant "Product" as p
participant "Customer" as c

user -> o: calculatePrice()
activate o

o -> o: basePrice = 0
loop for each OrderLine
    o -> ol: getQuantity()
    ol -> o: return quantity
    o -> ol: getProduct()
    ol -> o: return product
    o -> p: getPrice()
    p -> o: return unitPrice
    o -> o: basePrice += quantity * unitPrice
end

o -> ext: getPricingDetails(basePrice)
ext -> o: return updatedPrice

o -> c: getDiscount()
c -> o: return discountRate

o -> ext: getDiscountInfo(discountRate, updatedPrice)
ext -> o: return discountAmount

o -> o: finalPrice = updatedPrice - discountAmount
o -> o: set price = finalPrice

deactivate o
@enduml
```

## Installation and Usage

**1.**	**Compile the Java Files**

```
javac *.java
```

**2.**	**Run the Main Class**

```
java Main
```

This will execute the demo **main** method, creating a sample **Order**, adding a couple of **OrderLine** items, and printing out the calculated total price and shipping cost.

## Example Usage

In the example **Main** class, we create a **Customer** named “Alice,” set up an **Order** with two products (**Widget** and **Gadget**), then:

**1.**	Add **OrderLine** items.

**2.**	Call **order.calculatePrice()** to see the total.

**3.**	Attach **ShippingInfo** and call **order.updateShipping()** to see the shipping cost.

You should see output similar to:

```
Calculated Order Price: 49.5
Shipping Cost: 2.475
Shipping Total Amount: 49.5
```

*(Exact values may vary depending on your discount or pricing logic.)*


## License

This project is open-source. You may use and modify it according to your needs. If you reuse significant portions, please give credit to the original source.
