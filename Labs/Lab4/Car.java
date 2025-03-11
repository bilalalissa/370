/**
 * Car interface representing the base component in the Decorator Pattern.
 */
public interface Car {
    /**
     * Provides the description of the car.
     * @return A string describing the car.
     */
    String getDescription();

    /**
     * Provides the cost of the car.
     * @return The cost as a double value.
     */
    double getCost();
}