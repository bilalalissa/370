// A02bah305.java (Main Program)
/**
 * Author: Bilal Alissa
 * SID: 200384288
 * Assignment: 2
 * Date: 2021-09-26
 * 
 * Main class to simulate the Factory Robot Controller.
 * This program demonstrates the use of Design Patterns:
 * - Factory Pattern: To instantiate different types of robots dynamically.
 * - Singleton Pattern: To ensure only one instance of AssemblyRobot.
 * 
 * The process follows these steps:
 * 1. Create two Cutting Robots, two Drilling Robots, and one Assembly Robot.
 * 2. Cutting Robots fetch raw materials, cut them, and store the cut parts.
 * 3. Drilling Robots fetch cut parts, drill holes, and store drilled parts.
 * 4. Assembly Robot fetches drilled parts, assembles them, and stores the final
 * product.
 * 5. The process is printed step-by-step to the console to ensure correct
 * execution.
 * 
 * To run the program, execute the main method in this class as follows.
 * in the terminal executing the following commands:
 * javac A02bah305.java && java A02bah305
 * 
 */
public class A02bah305 {
    public static void main(String[] args) {
        System.out.println("\n\t====================================");
        System.out.println("\t Welcome to the Factory Robot System ");
        System.out.println("\t====================================\n");

        System.out.println("\n\t--- Creating Cutting Robots ---");
        Robot cuttingRobot1 = RobotFactory.createRobot("Cutting", "100200300401");
        Robot cuttingRobot2 = RobotFactory.createRobot("Cutting", "100200300402");

        System.out.println("\n\t--- Creating Drilling Robots ---");
        Robot drillingRobot1 = RobotFactory.createRobot("Drilling", "200200300401");
        Robot drillingRobot2 = RobotFactory.createRobot("Drilling", "200200300402");

        System.out.println("\n\t--- Creating Assembly Robot ---");
        Robot assemblyRobot = RobotFactory.createRobot("Assembly", "300200300401");

        // Simulation Process
        System.out.println("\n\t--- Starting Cutting / Drilling Process ---");
        for (int i = 0; i < 2; i++) {
            cuttingRobot1.fetchParts();
            cuttingRobot2.fetchParts();
            cuttingRobot1.doTask();
            cuttingRobot2.doTask();
            cuttingRobot1.storeParts();
            cuttingRobot2.storeParts();
        }

        System.out.println("\n\t--- Starting Cutting / Drilling Process ---");
        for (int i = 0; i < 2; i++) {
            drillingRobot1.fetchParts();
            drillingRobot2.fetchParts();
            drillingRobot1.doTask();
            drillingRobot2.doTask();
            drillingRobot1.storeParts();
            drillingRobot2.storeParts();
        }

        System.out.println("\n\t--- Starting Assembly Process ---");
        assemblyRobot.fetchParts();
        assemblyRobot.doTask();
        assemblyRobot.storeParts();

        System.out.println("\n\t\t--- Ending Process ---\n\n");
    }
}
