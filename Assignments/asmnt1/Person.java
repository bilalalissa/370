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
        System.out.println("\n--> The name is set to --> ( " + nameString + " )");
    }
}