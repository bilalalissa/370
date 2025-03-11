// File: CarTest.java
// Author: Bilal Alissa
// SID: 200384288

public class CarTest {
    public static void main(String[] args) {
        Car myCar = new BaseModel();
        
        // Adding all features step by step
        myCar = new LeatherSeats(myCar);
        myCar = new Sunroof(myCar);
        myCar = new PremiumSoundSystem(myCar);
        myCar = new NavigationSystem(myCar);
        myCar = new SportPackage(myCar);
        
        // Display final description and cost
        System.out.println(myCar.getDescription() + " Cost = $" + myCar.getCost());
    }
}