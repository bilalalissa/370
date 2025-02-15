// CuttingRobot.java
/**
 * Cutting Robot responsible for cutting raw materials.
 */
class CuttingRobot extends Robot {
    public CuttingRobot(String serialNumber) {
        super("Cutting: ", "Regina Machine: ", serialNumber);
    }

    @Override
    public void doTask() {
        System.out.println(" - Raw material cut");
    }
}