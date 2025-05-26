#Student Management System (Java + JDBC + PostgreSQL)

A console-based Java application to perform CRUD operations on student records stored in a PostgreSQL database using JDBC.

## 📌 Features
- Add new student records
- Update student details (name, age, course)
- Delete records by ID
- Fetch single or all student records
- Console menu for user interaction

## 🛠️ Technologies Used
- Java
- JDBC
- PostgreSQL
- Console I/O

## 🧩 Project Structure

src/
├── Entity/
│ └── Student.java
├── Service/
│ └── StudentService.java
└── Driver/
└── StudentDriver.java

sql
Copy
Edit

## 🗃️ Database Setup

Run the following in your PostgreSQL:

```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT CHECK (age > 0),
    course VARCHAR(50) NOT NULL
);
Ensure your DB is named studentdetails and credentials in code match your DB setup.

🚀 How to Run
Compile all .java files.

Ensure PostgreSQL is running.

Run StudentDriver.java from console or any IDE.
