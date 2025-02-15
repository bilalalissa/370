// DrillingRobot.java
/**
 * Drilling Robot responsible for drilling holes in parts.
 */
class DrillingRobot extends Robot {
    public DrillingRobot(String serialNumber) {
        super("Drilling", "Regina Machine: ", serialNumber);
    }

    @Override
    public void doTask() {
        System.out.println(" - Holes drilled");
    }
}