public class PremiumSoundSystem extends CarDecorator {
    public PremiumSoundSystem(Car newCar) {
        super(newCar);
        System.out.println("Adding Premium Sound System");
    }
    public String getDescription() {
        return tempCar.getDescription() + ", Premium Sound System";
    }
    public double getCost() {
        return tempCar.getCost() + 800.00;
    }
}