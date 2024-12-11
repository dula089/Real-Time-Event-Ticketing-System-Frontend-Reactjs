# Ticketing System Backend

This project is a backend implementation for a ticketing system using Spring Boot. The application manages ticket operations, configurations, logs, and vendor interactions in a ticket pool system.

## Table of Contents

- [Technologies Used](#Technologies Used)

- [Project Structure](#Project Structure)

- [Setup and Installation](#Setup and Installation)

- [Endpoints](#Endpoints)

- [Configuration](#Configuration)

- [License](#License)

## Technologies Used

*Spring Boot 3.4.0*

*Java 21*

*MySQL*

*Maven*

## Project Structure
```txt
src/
├── main/
│   ├── java/
│   │   └── com/example/ticketing/system_backend/
│   │       ├── controller/   # Controllers for handling HTTP requests
│   │       ├── model/        # Entity classes
│   │       ├── repository/   # JPA Repositories
│   │       ├── service/      # Service classes for business logic
│   │       └── utils/        # Utility classes (e.g., Vendor)
│   └── resources/
│       ├── application.properties  # Application configuration
│                     
└── test/                          )
```

## Setup and Installation

**Prerequisites**

- Java 21 installed

- Maven installed

- MySQL database running locally

**Steps to Run the Project**

- Clone the repository:
```txt
git clone https://github.com/dula089/Real-Time-Event-Ticketing-System--Reactjs-vite-tailwindcss-springboot.git
cd ticketing-system_backend
```
- Configure the database:

- Edit the application.properties file:
```txt
spring.datasource.url=jdbc:mysql://localhost:3306/ticketsystem?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=<your_password>
```
- Build and run the application:
```txt
mvn clean install
mvn spring-boot:run
```
- The server will start on *http://localhost:8081/*.

## Endpoints

### Configuration Endpoints

- Save Configuration

  - POST ``` /api/configuration```

  - Request Body:
   ```txt
    {
    "totalTickets": 1000,
    "ticketReleaseRate": 10,
    "customerRetrievalRate": 5,
    "maxTicketCapacity": 500
    }
    ```

    - Response: Created configuration object.

- Get Configuration

    - GET ``` /api/configuration/{id}```

    - Response: Configuration object or ```404 Not Found```.

### Log Endpoints

- Create Log

    - POST /api/logs

    - Request Body:
    ```txt
    {
    "saleId": "1234",
    "dateTime": "2024-01-01T10:00:00",
    "message": "Ticket sale successful"
    }
  ```

    - Response: Created log object.

### Vendor and TicketPool Logic

The ```Vendor``` class operates on the ```TicketPool``` model:

- Vendors release tickets at a specified rate.

- Tickets are added to the pool, ensuring maximum capacity is not exceeded.

## Configuration

The following configurations are available in ```application.properties```:

- Server Port:

    ```server.port=8081```

- Database Connection:
    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/ticketsystem?createDatabaseIfNotExist=true
    spring.datasource.username=root
    spring.datasource.password=<your_password>```

- Hibernate Settings:

    ```spring.jpa.hibernate.ddl-auto=update
    spring.jpa.open-in-view=false
    spring.jpa.show-sql=true```

## License

This project is licensed under the MIT License.

