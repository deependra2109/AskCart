# 🛒 AskCart - Spring Boot Shopping Cart API

Welcome to **AskCart**, a full-featured RESTful API built using **Spring Boot** that manages products and a shopping cart. Designed with clean code principles and modular architecture, this project provides all the core operations you’d expect in a shopping platform, including **add/update/delete products**, **add to cart**, **remove from cart**, and a powerful **search feature**.

> ⚡ Perfect for learning backend development or using as a base for an e-commerce platform.

---

## 🚀 Key Features

### ✅ Product Management (CRUD)
- Add new products with name, brand, category, and price
- Retrieve all products or individual product by ID
- Update product information
- Delete products by ID

### 🔍 Advanced Search Capability
- Search products by **name**, **brand**, **category**, or **product ID**
- Supports flexible keyword-based filtering
- Fast, case-insensitive matching

### 🛒 Shopping Cart Operations
- Add products to cart with quantity
- View all items currently in the cart
- Fetch individual cart item by ID
- Delete specific cart items
- Cart automatically calculates total price dynamically

### ⚙️ Clean Layered Architecture
- **Controller**, **Service**, **Repository**, and **Entity** layers are neatly separated
- Easy to scale and maintain

### 🌐 RESTful API Standards
- HTTP status codes and methods strictly follow best practices
- JSON-formatted request/response bodies
- Can be easily consumed by frontend apps or Postman

---

## 🌐 API Endpoints

### 📦 Product Endpoints

| Method | Endpoint                             | Description                                         |
|--------|--------------------------------------|-----------------------------------------------------|
| POST   | `/api/products`                      | Add a new product                                   |
| GET    | `/api/products`                      | Fetch all products                                  |
| GET    | `/api/products/search?keyword=abc`   | Search product by name, brand, category, or ID      |
| PUT    | `/api/products/{id}`                 | Update a specific product                           |
| DELETE | `/api/products/{id}`                 | Delete a product                                    |

### 🛒 Cart Endpoints

| Method | Endpoint           | Description                |
|--------|--------------------|----------------------------|
| POST   | `/api/cart`        | Add product to the cart    |
| GET    | `/api/cart`        | Retrieve all cart items    |
| GET    | `/api/cart/{id}`   | Get specific cart item     |
| DELETE | `/api/cart/{id}`   | Remove product from the cart |

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- RESTful API
- Postman (for testing)
- lombok

---
 📁 Folder Structure

```bash
AskCart/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/deependra/Askcart/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       └── model/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── pom.xml
└── README.md


---


## 🚀 How to Run This Project Locally

### 1. Clone the Repository

```bash
git clone https://github.com/deependra2109/AskCart.git
cd AskCart
```

### 2. Configure MySQL Database

Create a MySQL database named `askcart` (or update the name in your properties file):

```sql
CREATE DATABASE askcart;
```

### 3. Configure application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/askcart
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

Or use IntelliJ: Right-click `AskcartApplication.java` → `Run`

### 5. Test the APIs

Use Postman to hit endpoints like:

* `GET /api/products`
* `POST /api/products`
* `GET /api/products/search?keyword=shoes`
* `POST /api/cart`
* `GET /api/cart`
* 

---


🙋‍♂️ Why This Project Matters
✅ Demonstrates real-world understanding of backend design
✅ Follows enterprise-grade layered architecture
✅ Built from scratch without boilerplates
✅ Clean and scalable code — ready for real-world extension
✅ Shows strong command over Spring Boot, MySQL, and API design

---


Planned improvements to take this project to the next level:

🔐 Add Spring Security + JWT Authentication

📄 Integrate Swagger/OpenAPI docs

🐳 Dockerize the backend

✅ Add unit and integration tests

---

## 📄 License

**All Rights Reserved.**  
This project is protected. No part of this codebase may be copied, reused, distributed, or modified without explicit written permission from the author.


---

Author

Deependra Kumar
💻 Passionate about backend engineering and building scalable systems

[![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?logo=linkedin&logoColor=white&style=for-the-badge)](https://www.linkedin.com/in/deependra-kumar21/)
[![GitHub](https://img.shields.io/badge/GitHub-black?logo=github&logoColor=white&style=for-the-badge)](https://github.com/deependra2109)




