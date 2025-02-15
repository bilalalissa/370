// AssemblyRobot.java (Singleton Pattern)
/**
 * Assembly Robot responsible for assembling parts.
 * Uses Singleton Pattern to ensure only one instance exists.
 */
class AssemblyRobot extends Robot {
    private static AssemblyRobot instance;

    private AssemblyRobot(String serialNumber) {
        super("\n == > Assembly", "SK Robotics: ", serialNumber);
    }

    public static AssemblyRobot getInstance(String serialNumber) {
        if (instance == null) {
            instance = new AssemblyRobot(serialNumber);
        }
        return instance;
    }

    @Override
    public void doTask() {
        System.out.println("\n == > Product Assembled");
    }
}