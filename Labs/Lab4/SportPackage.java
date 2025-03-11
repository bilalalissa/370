public class SportPackage extends CarDecorator {
    public SportPackage(Car newCar) {
        super(newCar);
        System.out.println("Adding Sport Package");
    }
    public String getDescription() {
        return tempCar.getDescription() + ", Sport Package";
    }
    public double getCost() {
        return tempCar.getCost() + 2000.00;
    }
}