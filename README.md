### README.md

```markdown
# Patient API

This is a RESTful API for managing patient data, built with Spring Boot and MongoDB. The API provides functionality for creating, reading, updating, and deleting (CRUD) patient records, as well as JWT-based authentication for secure access.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Authentication](#authentication)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- Add new patient records
- Retrieve all patients or specific patient details
- Update patient information
- Delete patient records
- JWT authentication for secure access
- Search and filter patients based on conditions and assigned therapists

## Technologies Used

- **Java**: Programming language used to build the application.
- **Spring Boot**: Framework for building RESTful web services.
- **MongoDB**: NoSQL database for storing patient data.
- **Spring Security**: Provides security features, including JWT authentication.
- **Maven**: Dependency management and project build tool.

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven
- MongoDB (installed and running)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/vposwalia/PatientAPI.git
   cd PatientAPI
   ```

2. Ensure MongoDB is running on your local machine. You can start it using:

   ```bash
   mongod
   ```

3. Update the MongoDB configuration in `src/main/resources/application.properties`:

   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/patientdb
   ```

4. Build the project using Maven:

   ```bash
   mvn clean install
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

| Method | Endpoint                        | Description                                 |
|--------|---------------------------------|---------------------------------------------|
| POST   | /patients                       | Add a new patient record                   |
| GET    | /patients                       | Retrieve a list of all patients            |
| GET    | /patients/{id}                  | Retrieve details of a specific patient by ID |
| PUT    | /patients/{id}                  | Update an existing patient's information    |
| DELETE | /patients/{id}                  | Remove a patient's record                   |
| GET    | /patients/search                | Search for patients based on condition or therapist |

### Example Request

**Adding a Patient**

```http
POST /patients
Content-Type: application/json

{
    "name": "John Doe",
    "age": 45,
    "condition": "Parkinson's",
    "assignedTherapist": "Dr. Smith",
    "contactInfo": "555-0123"
}

### Patient Collection

- **name**: String
- **age**: Integer
- **condition**: String
- **assignedTherapist**: String
- **contactInfo**: String

## Authentication

- The API uses JWT for authentication.
- The login endpoint is `/auth/login`, where you can obtain a JWT token by providing valid credentials.
- All endpoints except for patient creation require a valid JWT token in the `Authorization` header.

## Usage

After starting the application, you can test the API using tools like Postman or cURL. Make sure to include the JWT token for protected endpoints.

