// Robot.java (Abstract Class)
/**
 * Abstract base class for all robots.
 * Defines common properties and actions each robot must implement.
 */
abstract class Robot {
    protected String type;
    protected String manufacturer;
    protected String serialNumber;

    public Robot(String type, String manufacturer, String serialNumber) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        System.out.println(type + " Robot created\n" + manufacturer + " " + serialNumber);
    }

    public void fetchParts() {
        System.out.println(type + " Robot: Fetching parts");
    }

    public abstract void doTask();

    public void storeParts() {
        System.out.println(type + " Robot: Storing parts\n\n");
    }
}