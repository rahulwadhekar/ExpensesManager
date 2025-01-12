# Expense Manager Application

![Expense Manager Banner](https://via.placeholder.com/800x200?text=Expense+Manager+Application+by+Rahul)

## Project Summary

The Expense Manager Application is a Spring Boot-based web application designed to help users effectively manage their finances. It allows users to:

- Track income and expenses.
- Set and manage a monthly budget.
- Calculate total and average expenses.
- Generate expense quotations for better financial planning.

## Features

### User Management
- Add, edit, and retrieve user details such as username, email, address, and budget.
- Associate incomes and expenses with individual users.

### Income Management
- Add, update, and retrieve income records.
- Categorize incomes by type and date.

### Expense Management
- Add and retrieve expense records.
- Categorize expenses by type and date.

### Budget Management
- Set a monthly budget for users.
- Calculate total and average expenses.
- Generate a quotation for future financial planning.

## Technical Stack

- **Backend**: Spring Boot, JPA/Hibernate
- **Database**: MySQL (or any preferred relational database)
- **Tools**: IntelliJ IDEA, Maven, Postman (for API testing)

## Installation and Usage

### Prerequisites

1. Java 17+
2. Maven
3. MySQL or any relational database
4. Postman (optional, for API testing)

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/expense-manager.git
   ```

2. Navigate to the project directory:
   ```bash
   cd expense-manager
   ```

3. Configure the database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/expense_manager
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

6. Access the application:
   - API Endpoints: `http://localhost:8080`

## API Endpoints

### User Controller

- **Save User**:
  ```http
  POST /user/save
  {
      "username": "JohnDoe",
      "email": "john.doe@example.com",
      "address": "123 Main St",
      "budget": 5000
  }
  ```
- **Get User by ID**:
  ```http
  GET /user/{id}
  ```
- **Set Budget**:
  ```http
  POST /user/{userId}/setBudget?budget=6000
  ```

### Expense Controller

- **Save Expense**:
  ```http
  POST /expense/save/{userId}
  {
      "amount": 100,
      "description": "Grocery shopping",
      "expenseType": "Food",
      "date": "2025-01-10"
  }
  ```
- **Get Expense by ID**:
  ```http
  GET /expense/{expenseId}
  ```

### Income Controller

- **Save Income**:
  ```http
  POST /income/save/{userId}
  {
      "amount": 2000,
      "description": "Salary",
      "incomeType": "Job",
      "date": "2025-01-01"
  }
  ```
- **Get Income by ID**:
  ```http
  GET /income/{incomeId}
  ```

## Visual Enhancements

- :moneybag: **Financial Tracking Made Simple**
- :chart_with_upwards_trend: **Plan Your Future with Expense Manager**
- :tada: **Developed by Rahul**

---

![Thank You](https://via.placeholder.com/600x100?text=Thank+You+for+Using+Expense+Manager!)

