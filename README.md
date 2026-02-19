# 👤 User Service — User Management Microservice

The **User Service** is a Spring Boot microservice responsible for managing user data in a distributed system.  
It works alongside the **Auth Service** to separate authentication from user profile management — a common pattern in scalable backend architectures.

This service stores and provides user information while authentication and token validation are handled by the Auth Server.

---

## 🚀 Features

- User profile creation & storage
- Fetch user details by ID
- Update user information
- Delete users
- Designed for microservice architecture
- Works with centralized Auth Service
- Clean separation of authentication & user data
- Database-ready entity management
- RESTful APIs

---

## 🏗️ Architecture Role

Client → API Gateway
├── Auth Service (login & token)
└── User Service (user data)


Auth Service verifies identity  
User Service manages user information

This follows **Single Responsibility Principle in system design**

---

## 🧠 Why Separate User Service?

In real production systems:

Authentication ≠ User Data Management

### Without separation
- Tight coupling
- Hard to scale
- Security risks
- Difficult maintenance

### With User Service
✔ Independent scaling  
✔ Cleaner architecture  
✔ Easier debugging  
✔ Service ownership clarity  

---

## 🛠️ Tech Stack

| Technology | Purpose |
|----------|------|
| Java | Core language |
| Spring Boot | Backend framework |
| Spring Web | REST APIs |
| Spring Data JPA | Database operations |
| Gradle | Build system |
| REST | Service communication |

---

## 📂 Project Structure

src/
└── main/
├── controller/ → API endpoints
├── service/ → Business logic
├── model/ → User entity
├── repository/ → Database layer
└── dto/ → Request/Response models
