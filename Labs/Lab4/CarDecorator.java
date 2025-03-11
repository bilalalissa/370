/**
 * CarDecorator abstract class that implements Car and serves as a base for all feature decorators.
 */
public abstract class CarDecorator implements Car {
    protected Car tempCar;

    /**
     * Constructor that sets the car to be decorated.
     * @param newCar The car to which features will be added.
     */
    public CarDecorator(Car newCar) {
        this.tempCar = newCar;
    }

    /**
     * Returns the description of the car with added features.
     * @return A string describing the car with features.
     */
    @Override
    public String getDescription() {
        return tempCar.getDescription();
    }

    /**
     * Returns the cost of the car with added features.
     * @return The cost as a double value.
     */
    @Override
    public double getCost() {
        return tempCar.getCost();
    }
}