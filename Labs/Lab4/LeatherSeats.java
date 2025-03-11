public class LeatherSeats extends CarDecorator {
    public LeatherSeats(Car newCar) {
        super(newCar);
        System.out.println("Adding Leather Seats");
    }
    public String getDescription() {
        return tempCar.getDescription() + ", Leather Seats";
    }
    public double getCost() {
        return tempCar.getCost() + 1500.00;
    }
}