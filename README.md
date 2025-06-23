# Employment-Management-system (Week-1 Task) 
This is a console-based Employee Management System developed in Java, following Object-Oriented Programming (OOP) principles, integrating the Java 8 Stream API, and implementing custom exception handling.

The application enables organizations to efficiently manage employees, managers, and projects in a structured and hierarchical format, through a simple menu-driven console interface.


Users interact with the system through a simple menu-driven console interface.

---

## 🧠 Key Features

- ✅ Add Employees and Managers
- ✅ Create Projects
- ✅ Assign Employees to Projects with Deadline (in days)
- ✅ Assign Employees under a Manager
- ✅ View Employees under a Manager
- ✅ Filter High Salary Employees (Java 8 Streams)
- ✅ Sort Employees by Name or Age (Java 8 Streams)
- ✅ Group Employees by Department (Java 8 Streams)
- ✅ View All Employees
- ✅ Show Employee Hierarchy (Manager → Team)
- ❗ Custom exception handling for invalid name, age, and missing assignments

  Custom Exception Handling for:

-Invalid or empty names

-Age below 18

-Unassigned employees

-Missing manager/employee



---

## 🧱 Technologies Used

| Technology     | Purpose                          |
|----------------|----------------------------------|
| Java (SE)      | Core development language        |
| Java 8 Streams | Filtering, sorting, grouping     |
| OOP Concepts   | Inheritance, Encapsulation, etc. |
| Exception Handling | Custom input validation     |
| CLI            | User interaction via `Scanner`   |

---

## ⚙️ Structure of Project

```plaintext
src/
├── EMSApp.java                  # Console driver/main class
├── EMSService.java              # Business logic
├── Employee.java                # Employee model (extends Person)
├── Manager.java                 # Manager model (extends Employee)
├── Person.java                  # Base class
├── Project.java                 # Project class with deadlines
├── EmployeeNotFoundException.java
├── InvalidAgeException.java
└── InvalidDataException.java
