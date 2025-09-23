# Spring Boot Microservices Project

## Overview
This project demonstrates a microservices architecture using Spring Boot. It consists of the following core services:

- **API Gateway**: Handles routing of client requests to the appropriate microservice.
- **Discovery Server**: Service registry for dynamic discovery of microservices (typically using Eureka).
- **Order Service**: Manages order-related operations.
- **User Service**: Manages user-related operations.

## Architecture
- **Spring Boot** is used for rapid application development.
- **Eureka Discovery Server** enables service registration and discovery.
- **API Gateway** (Spring Cloud Gateway or Zuul) routes requests to backend services.
- Each service is a separate Gradle project/module.

## Project Structure
```
api-gateway/         # API Gateway service
order-service/       # Order management microservice
user-service/        # User management microservice
discovery-server/    # Eureka Discovery Server
```

## Prerequisites
- Java 17 or later
- Gradle 7.x or later

## Setup Instructions
1. **Clone the repository**
   ```sh
   git clone <your-repo-url>
   cd springboot-microservices
   ```
2. **Build all services**
   ```sh
   ./gradlew build
   ```
3. **Run the Discovery Server first**
   ```sh
   cd discovery-server
   ./gradlew bootRun
   ```
4. **Run the API Gateway**
   ```sh
   cd ../api-gateway
   ./gradlew bootRun
   ```
5. **Run the Order and User Services**
   ```sh
   cd ../order-service
   ./gradlew bootRun
   # In a new terminal:
   cd ../user-service
   ./gradlew bootRun
   ```

## Usage
- Access the API Gateway at `http://localhost:<gateway-port>`
- Eureka dashboard is available at `http://localhost:<eureka-port>/`
- Update `application.properties` or `application.yml` in each service to configure ports and service names as needed.

## Contributing
1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Commit your changes
4. Push to your branch
5. Open a pull request

## License
This project is licensed under the MIT License.

