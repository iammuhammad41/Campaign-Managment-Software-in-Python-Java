To integrate Python with Java, one effective method is using **Jython**, **Py4J**, or **Jpype**. In this case, we'll use **Py4J**, which is a commonly used tool for integrating Java with Python.

### Requirements:

* **Py4J** (Python package) for creating a bridge between Python and Java.
* A basic understanding of both Python and Java programming.

### Project Overview:

We  build a **Campaign Management Software** where the logic for managing campaigns is written in Java, and the user interface (UI) and other parts of the system (e.g., data processing, analytics) is written in Python. We will link the Python and Java components using **Py4J**.

Here are the steps and files required for the integration:

### File Structure:

```
Campaign_Management_Software/
│
├── python_script.py        # Python part of the code that interacts with Java
├── java_part/              # Folder containing the Java code
│   ├── CampaignManager.java  # Java class responsible for managing campaigns
│   ├── Campaign.java         # Java class representing a Campaign
│
└── requirements.txt        # Python dependencies
```

### 1. **Java Code** (`CampaignManager.java`, `Campaign.java`)

**Campaign.java:**

```java
// Campaign.java

public class Campaign {
    private String name;
    private String description;
    private String status;

    public Campaign(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "Campaign Name: " + name + "\nDescription: " + description + "\nStatus: " + status;
    }
}
```

**CampaignManager.java:**

```java
// CampaignManager.java

import py4j.GatewayServer;

public class CampaignManager {

    public Campaign createCampaign(String name, String description, String status) {
        return new Campaign(name, description, status);
    }

    public void printCampaignDetails(Campaign campaign) {
        System.out.println(campaign.toString());
    }

    public static void main(String[] args) {
        CampaignManager manager = new CampaignManager();
        GatewayServer gatewayServer = new GatewayServer(manager);
        gatewayServer.start();
        System.out.println("Gateway Server Started");
    }
}
```

This Java code defines a `Campaign` class representing a campaign and a `CampaignManager` class that can create and print campaign details. The `CampaignManager` is set up to be accessed from Python using **Py4J**.

### 2. **Python Code** (`python_script.py`)

**python\_script.py:**

```python
# python_script.py

from py4j.java_gateway import JavaGateway

# Start the gateway connection
gateway = JavaGateway()  # Connect to the Java process
campaign_manager = gateway.entry_point  # Get the CampaignManager instance

# Create a new campaign using the Java class
campaign = campaign_manager.createCampaign("Summer Campaign", "A campaign to promote summer sales.", "Active")

# Print the campaign details
campaign_manager.printCampaignDetails(campaign)

# Modify the campaign status and print the updated details
campaign.setStatus("Completed")
campaign_manager.printCampaignDetails(campaign)
```

In this Python code:

* We use the `py4j.java_gateway.JavaGateway()` to connect to the Java process running the `CampaignManager`.
* We then call methods from the `CampaignManager` class to create and print the campaign details.
* Finally, we modify the campaign's status and print the updated details.

### 3. **Setting Up Py4J**

First, install **Py4J** in Python:

```bash
pip install py4j
```

### 4. **Running the Project**

1. **Start the Java Process:**

   Compile and run the Java files:

   ```bash
   javac -cp py4j0.10.9.2.jar Campaign.java CampaignManager.java
   java -cp .:py4j0.10.9.2.jar CampaignManager
   ```

   This will start the `CampaignManager` as a **Py4J Gateway Server**.

2. **Run the Python Script:**

   Run the Python script:

   ```bash
   python python_script.py
   ```

   This will create a campaign using the Java `CampaignManager` and print its details. It will then update the status of the campaign and print the updated details.

### 5. **requirements.txt**

```txt
py4j==0.10.9.2
```

### 6. **Summary of Integration:**

* **Java Side**: Handles the core logic (creating and managing campaigns). The `CampaignManager` and `Campaign` classes are exposed to Python through **Py4J**.
* **Python Side**: Interacts with the Java classes using the Py4J library. It is used for further processing, user interface, or analytics, as necessary.

### Reference:

For more information on Py4J and setting up a Java-Python integration, please refer to the Py4J documentation at [Py4J GitHub](https://github.com/py4j/py4j).
