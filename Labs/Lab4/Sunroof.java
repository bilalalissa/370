public class Sunroof extends CarDecorator {
    public Sunroof(Car newCar) {
        super(newCar);
        System.out.println("Adding Sunroof");
    }
    public String getDescription() {
        return tempCar.getDescription() + ", Sunroof";
    }
    public double getCost() {
        return tempCar.getCost() + 1200.00;
    }
}