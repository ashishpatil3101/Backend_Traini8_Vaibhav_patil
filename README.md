

#  Training Centre Management System

a web-based training centre management system that allows users to manage and organize various aspects of training centres, including adding new centres and retrieving existing ones.

## Deployed Link 
   - [click here to go to Deployed link](https://backend-traini8-vaibhav-patil-buyogo.onrender.com/swagger-ui/index.html)

## Features

- **Add Training Centre**: Users can add new training centres to the system, providing details such as centre name, code, address, capacity, courses offered, and contact information.
- **Retrieve Training Centre**: Users can retrieve training centres based on various criteria such as city, centre name, centre code, course name, and maximum student capacity.

## Technologies Used

- **Spring Boot**: Backend framework for building RESTful APIs.
- **Java Persistence API (JPA)**: Java specification for managing relational data in applications.
- **Jakarta EE**: Set of specifications for enterprise Java applications.
- **PostgreSQL Database**: 
- **Lombok**: Library to reduce boilerplate code in Java.
- **Swagger**: API documentation tool for documenting RESTful APIs.

## Setup Instructions

1. Clone the repository: `git clone https://github.com/ashishpatil3101/Backend_Traini8_Vaibhav_patil.git`
2. Add database properties in application.properties file[username, password, dburl]
3. Navigate to the project directory: `cd <project_directory>`
4. Build the project: `mvn clean install`
5. Run the application: `mvn spring-boot:run`
6. Access the application: Open a web browser and go to `http://localhost:8080`

## API Documentation

The API documentation is available at `http://localhost:8080/swagger-ui.html`, which provides detailed information about the available endpoints and how to use them.

## Usage

1. **Add Training Centre**:
   - Method: `POST`
   - Endpoint: `/training-centre/add`
   - Request Body: Details of the training centre to be added.
   - Example Request Body:
     ```json
     {
        "centerName": "string",
        "centerCode": "ciKb8Qf4VJFh",
        "studentCapacity": 0,
        "coursesOffered": ["string"],
        "contactEmail": "string",
        "contactPhone": "2692108100",
        "detailedAddress": "string",
        "city": "string",
        "state": "string",
        "pincode": "string"
     }
     ```

2. **Retrieve Training Centre**:
   - Method: `GET`
   - Endpoint: `/training-centre/get`
   - Query Parameters: 
     - `city`: Filter by city name.
     - `centerName`: Filter by training centre name.
     - `centerCode`: Filter by training centre code.
     - `courseName`: Filter by course name.
     - `studentCapacityMax`: Filter by maximum student capacity.




