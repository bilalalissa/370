// RobotFactory.java (Factory Pattern)
/**
 * Factory class to create robot instances dynamically.
 */
class RobotFactory {
    public static Robot createRobot(String type, String serialNumber) {
        switch (type) {
            case "Cutting":
                return new CuttingRobot(serialNumber);
            case "Drilling":
                return new DrillingRobot(serialNumber);
            case "Assembly":
                return AssemblyRobot.getInstance(serialNumber);
            default:
                throw new IllegalArgumentException("\n\t >> Invalid robot type << \n");
        }
    }
}