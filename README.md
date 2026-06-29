# JobTrackr — Job Application Tracker API

A secured REST API built with Java and Spring Boot for tracking job applications across multiple status stages.

## Tech Stack
- **Java 21**
- **Spring Boot 3.5**
- **PostgreSQL**
- **Spring Security**
- **Spring Data JPA**
- **Lombok**

## Features
- Full CRUD operations for job applications
- Track applications across 4 status stages: `APPLIED`, `INTERVIEW`, `OFFER`, `REJECTED`
- Filter jobs by status
- Live analytics endpoint returning application statistics
- Secured with Spring Security authentication

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/jobs` | Get all jobs |
| GET | `/api/jobs/{id}` | Get job by ID |
| GET | `/api/jobs/status/{status}` | Get jobs by status |
| POST | `/api/jobs` | Create new job |
| PUT | `/api/jobs/{id}` | Update job |
| DELETE | `/api/jobs/{id}` | Delete job |
| GET | `/api/jobs/analytics` | Get analytics summary |

## Setup & Run

1. Clone the repository
2. Create a PostgreSQL database named `jobtrackr`
3. Update `application.properties` with your database credentials
4. Run the application using IntelliJ or Maven
5. API runs on `http://localhost:8080`

## Author
Yash Chhabra — [LinkedIn](https://www.linkedin.com/in/yash-chhabra-796829333/) | [GitHub](https://github.com/yashchhabra57)
