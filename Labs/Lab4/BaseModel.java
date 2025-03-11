/**
 * BaseModel class representing a standard car model without extra features.
 */
public class BaseModel implements Car {
    /**
     * Returns the description of the base model.
     * @return A string describing the base model.
     */
    @Override
    public String getDescription() {
        return "Base Model";
    }

    /**
     * Returns the cost of the base model.
     * @return The cost as a double value.
     */
    @Override
    public double getCost() {
        return 25_000.00; // Base price in dollars
    }
}