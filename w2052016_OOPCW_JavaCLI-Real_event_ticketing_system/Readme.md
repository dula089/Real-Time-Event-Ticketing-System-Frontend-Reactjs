# Real-Time Event Ticketing System

This project is a Real-Time Event Ticketing System implemented in Java. The system supports configuration, ticket issuance, and real-time interaction between vendors and customers using multithreading. It provides a Command-Line Interface (CLI) for users to configure and operate the system.

## Features

- **Dynamic Configuration:** Configure ticketing parameters such as total tickets, ticket release rate, customer retrieval rate, and maximum ticket capacity.

- **Real-Time Operations:** Vendors and customers interact in real-time using multithreaded operations.

- **Persistence:** Save and load configuration in both JSON and text formats.

- **Logging:** Logs system activities to a system.log file.

## Prerequisites

- **Java Development Kit (JDK):** Version 21 or later.

- **Apache Maven:** For building and managing dependencies.

- **Gson Library:** Included via Maven for JSON operations.

## Project Structure
```txt
    ├── Configuration.java         # Handles system configuration
    ├── Customer.java              # Defines customer behavior
    ├── Logger.java                # Logs system activities
    ├── TicketingSystem.java       # Main ticketing system logic
    ├── TicketingSystemCLI.java    # Command-Line Interface
    ├── TicketPool.java            # Manages ticket availability
    ├── Vendor.java                # Defines vendor behavior
├── pom.xml                    # Maven configuration
└── system.log                 # Log file (auto-generated)
```
## Getting Started

**Step 1:**  Clone the Repository

```
git clone https://github.com/dula089/Real-Time-Event-Ticketing-System--Reactjs-vite-tailwindcss-springboot.git 
cd Real-Time-Event-Ticketing-System 
```

**Step 2:** Build the Project

Use Maven to build the project and resolve dependencies:

```
mvn clean install
```

**Step 3:** Run the CLI

Execute the CLI to start the ticketing system:
```
java -cp target/<artifact_name>.jar TicketingSystemCLI
```
Replace ```<artifact_name>``` with the name of the generated JAR file.

## Usage

### Menu Options

When you start the CLI, you'll see the following menu:

 1. **Configuration:** Configure the system parameters.

 2. **Start the System:** Start ticketing operations.

 3. **Stop the System:** Stop ticketing operations.

 4. **Save Configuration to JSON File:** Save current configuration to a JSON file.

 5. **Load Configuration from JSON File:** Load configuration from a JSON file.

 6. **Save Configuration to Text File:** Save current configuration to a text file.

 7. **Load Configuration from Text File:** Load configuration from a text file.

 8. **Exit:** Exit the application.

## Example Flow

1. Configure the system with your desired parameters.

2. Start the system to begin ticketing operations.

3. Monitor the logs for real-time updates.

4. Save configurations for future use or load existing configurations.

5. Stop the system when needed.

## Key Classes

- ***Configuration:*** Manages ticketing system settings.

- ***TicketPool:*** Tracks available tickets and enforces capacity.

- ***Vendor:*** Simulates ticket addition at a specified rate.

- ***Customer:*** Simulates ticket retrieval at a specified rate.

- ***Logger:*** Logs system events and errors.

## Logging

Logs are saved to system.log with timestamps. For example:
```
2024-12-11 10:00:00 - Starting system configuration...
2024-12-11 10:01:00 - 5 tickets added. Tickets available: 20
```
## Configuration Persistence

***Save to JSON:*** Use Option 4 to save the configuration in JSON format.

***Load from JSON:*** Use Option 5 to load configuration from a JSON file.

***Save to Text:*** Use Option 6 to save the configuration in plain text.

***Load from Text:*** Use Option 7 to load configuration from a text file.

## Development Notes

- **Concurrency:** The system uses synchronized methods to ensure thread safety.

- **AtomicInteger:** Used for managing ticket counts in a thread-safe manner.

- **Customizable:** Modify parameters in Configuration.java to tailor the system.

## Dependencies

The project uses the following dependencies:

- **Gson:** For JSON serialization/deserialization.

Add this dependency in ```pom.xml:```
```
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
```
## Future Enhancements

- Add a graphical user interface (GUI).

- Support for multiple vendors and customers.

- Implement analytics for ticketing trends.

## License

This project is licensed under the MIT License.