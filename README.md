# Product Application

## Overview

This Spring Boot application provides a RESTful API for managing products. It interacts with the [Fake Store API](https://fakestoreapi.com/) to fetch product details and add new products. The application uses MySQL for local data storage and `RestTemplate` for external API communication.

[Documentation](https://drive.google.com/file/d/1JB_nk6vO0RiwOv9XqgeyPwHK9dSafe78/view?usp=sharing)



## Features

- Fetch products by category from the Fake Store API.
- Add new products to the Fake Store API and save them to a local database.

## Endpoints

### 1. Fetch Products by Category

- **URL:** `/api/products/category/{category}`
- **Method:** `GET`
- **Description:** Fetches a list of products by category from the Fake Store API.
- **URL Example:** `http://localhost:8888/api/products/category/jewelery`
- **Path Variable:**
  - `category` (string): The category to filter products by.
- **Response:**
  - **200 OK:** Returns a list of products in JSON format.
  - **404 Not Found:** If no products are found for the specified category.

**Response Example:**
json
[
  {
    "id": 5,
    "title": "Product 1",
    "price": 19.99,
    "description": "Description of product 1",
    "category": "jewelery",
    "image": "https://example.com/image1.jpg"
  },
  {
    "id": 6,
    "title": "Product 2",
    "price": 29.99,
    "description": "Description of product 2",
    "category": "jewelery",
    "image": "https://example.com/image2.jpg"
  }
]
## Add a New Product 
URL: /api/products/add
Method: POST
Description: Adds a new product to the Fake Store API and saves it to the local database.
Request Body:
title (string): The title of the product.
price (number): The price of the product.
description (string): The description of the product.
category (string): The category of the product.
image (string): The URL of the product image.
Request Body Example:
json

{
  "title": "New Product",
  "price": 25.99,
  "description": "This is a description of the new product",
  "category": "electronics",
  "image": "https://example.com/image.jpg"
}
Response:
200 OK: Returns the details of the newly created product in JSON format.
400 Bad Request: If the request body is invalid.
Response Example:

json

{
  "id": 31,
  "title": "New Product",
  "price": 25.99,
  "description": "This is a description of the new product",
  "category": "electronics",
  "image": "https://example.com/image.jpg"
}
**Configuration**
application.properties
properties

spring.application.name=Product Application
server.port=8888

# MySQL properties
spring.datasource.url=jdbc:mysql://localhost:3306/fakestore
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Timeouts for RestTemplate (in milliseconds)
resttemplate.connection.timeout=5000
resttemplate.read.timeout=5000

# Enable HTTP client logging for debugging purposes
logging.level.org.springframework.web.client.RestTemplate=DEBUG

# External API URL
external.api.url=https://fakestoreapi.com
Running the Application
Clone the Repository
sh 
[Git Clone](https://github.com/bhupirao/Prospecta_Coding.git) 
Navigate to the Project Directory

sh
cd product-application
Build and Run the Application

sh
./mvnw spring-boot:run
Access the API
The application will be available at[LocalHost](http://localhost:8888) 
