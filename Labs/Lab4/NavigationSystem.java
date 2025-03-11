public class NavigationSystem extends CarDecorator {
    public NavigationSystem(Car newCar) {
        super(newCar);
        System.out.println("Adding Navigation System");
    }
    public String getDescription() {
        return tempCar.getDescription() + ", Navigation System";
    }
    public double getCost() {
        return tempCar.getCost() + 1000.00;
    }
}