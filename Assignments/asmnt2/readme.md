# Factory Robot System

## Overview
This project implements a **Factory Robot System** using **Java**, incorporating **Design Patterns** like:
- **Factory Pattern** (to create different robot types dynamically)
- **Singleton Pattern** (to ensure only one instance of Assembly Robot exists)

The system simulates robots working on an assembly line to **cut materials, drill holes, and assemble parts** into a final product.

## Features
- **CuttingRobot**: Cuts raw materials.
- **DrillingRobot**: Drills holes in the parts.
- **AssemblyRobot**: Assembles drilled parts into a final product.
- **RobotFactory**: Uses the Factory Pattern to create robot instances.
- **FactoryController (Main Class)**: Controls the execution flow and manages the robots.

## Class Structure
```
FactoryController (Main Program)
│
├── Robot (Abstract Class)
│   ├── CuttingRobot (Extends Robot)
│   ├── DrillingRobot (Extends Robot)
│   ├── AssemblyRobot (Extends Robot, Singleton Pattern)
│
├── RobotFactory (Factory Pattern)
```

## Installation & Compilation
### **1. Clone the Repository**
```
git clone https://github.com/bilalalissa/370/tree/main/Assignments/asmnt2
cd FactoryRobotSystem
```

### **2. Compile the Java Files**
```
javac A02bah305.java
```

### **3. Run the Program**
```
java A02bah305
```

## Expected Output
```
====================================
 Welcome to the Factory Robot System
====================================

--- Creating Cutting Robots ---
Cutting Robot created (Serial: 100200300401)
Cutting Robot created (Serial: 100200300402)

--- Creating Drilling Robots ---
Drilling Robot created (Serial: 200200300401)
Drilling Robot created (Serial: 200200300402)

--- Creating Assembly Robot ---
Assembly Robot created (Serial: 300200300401)

--- Starting Cutting Process ---
Cutting Robot: Fetching parts
Raw material cut
Cutting Robot: Storing parts
...

--- Ending Process ---
====================================
```

## Use-Case Diagram
To visualize the **Use-Case** interactions, refer to `PlantUML code`.
Code:
```
@startuml
actor FactoryController

rectangle "Factory Robot System" {
    FactoryController --> (Create Cutting Robot)
    FactoryController --> (Create Drilling Robot)
    FactoryController --> (Create Assembly Robot)

    (Create Cutting Robot) --> (Fetch Parts)
    (Create Cutting Robot) --> (Cut Material)
    (Create Cutting Robot) --> (Store Parts)

    (Create Drilling Robot) --> (Fetch Parts)
    (Create Drilling Robot) --> (Drill Holes)
    (Create Drilling Robot) --> (Store Parts)

    (Create Assembly Robot) --> (Fetch Parts)
    (Create Assembly Robot) --> (Assemble Product)
    (Create Assembly Robot) --> (Store Product)
}
@enduml
```

## Class Diagram
For an overview of **class relationships**, refer to `PlantUML code`.
Code:
```
@startuml
class Robot {
    - String type
    - String manufacturer
    - String serialNumber
    + fetchParts()
    + doTask()
    + storeParts()
}

abstract class CuttingRobot {
    + doTask()
}

abstract class DrillingRobot {
    + doTask()
}

class AssemblyRobot {
    + getInstance()
    + doTask()
}

class RobotFactory {
    + createRobot(type, serialNumber)
}

class FactoryController {
    + main()
}

Robot <|-- CuttingRobot
Robot <|-- DrillingRobot
Robot <|-- AssemblyRobot
FactoryController --> RobotFactory
RobotFactory --> Robot

@enduml
```

## Errors & Fix Note (RobotFactory.java):
If you ran into errors, like because having an old java version.
Do the following:
Replace
```
class RobotFactory {
    public static Robot createRobot(String type, String serialNumber) {
        return switch (type) {
            case "Cutting" -> new CuttingRobot(serialNumber);
            case "Drilling" -> new DrillingRobot(serialNumber);
            case "Assembly" -> AssemblyRobot.getInstance(serialNumber);
            default -> throw new IllegalArgumentException("\n\t >> Invalid robot type << \n");
        };
    }
}
```
with
```
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
```

## License
This project is for educational purposes only.


