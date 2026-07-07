# ✈️ Air-Booker (Airline Reservation System)

A professional desktop-based **Airline Reservation System** developed using **Java Swing**, **JDBC**, and **MySQL**. The application provides a modern and user-friendly interface for managing airline reservations, including user authentication, flight booking, booking history, ticket cancellation, and dashboard management.

---

## 📌 Features

### 👤 User Authentication
- User Registration
- Secure Login
- Duplicate Email Validation
- Logout Functionality

### 🏠 Dashboard
- Professional Airline Dashboard
- Sidebar Navigation
- User Welcome Section
- Booking Statistics Cards
- Auto-Scrolling Recommended Flights
- Search Bar
- Profile Image Support

### ✈️ Flight Booking
- Search Flights
- Source Selection
- Destination Selection
- Travel Date Selection
- Travel Class Selection
- Passenger Selection
- Flight Listing
- Book Flight

### 🎫 Booking Management
- View My Bookings
- Booking History
- Cancel Ticket
- Booking Status

### 👤 User Profile
- Display Logged-in User
- Upload Profile Picture
- Profile Management *(Under Development)*

### 🗄 Database Integration
- MySQL Database
- JDBC Connectivity
- User Management
- Flight Management
- Booking Records

---

## 🛠 Technologies Used

- Java
- Java Swing
- AWT
- JDBC
- MySQL
- Object-Oriented Programming (OOP)

---

## 📂 Project Structure

```
AirBooker/
│
├── src/
│   ├── database/
│   │     └── DBConnection.java
│   │
│   ├── ui/
│   │     ├── Login.java
│   │     ├── Register.java
│   │     ├── Dashboard.java
│   │     ├── BookFlight.java
│   │     ├── BookingHistory.java
│   │     ├── CancelTicket.java
│   │     ├── Profile.java
│   │
│   └── Main.java
│
├── lib/
│     └── mysql-connector-j.jar
│
├── database.sql
│
└── README.md
```

---

## 🚀 Installation

### 1️⃣ Clone Repository

```bash
git clone https://github.com/YourUsername/Air-Booker-Airline-Reservation-System.git
```

### 2️⃣ Open Project

Open the project in your preferred Java IDE.

Examples:
- NetBeans
- IntelliJ IDEA
- Eclipse
- VS Code

### 3️⃣ Configure Database

- Install MySQL
- Create a database named:

```
airbooker
```

- Import the SQL file.

### 4️⃣ Add MySQL Connector

Add

```
mysql-connector-j.jar
```

to your project libraries.

### 5️⃣ Run the Project

Compile

```bash
javac -cp "lib/mysql-connector-j-9.3.0.jar" -d bin src/database/DBConnection.java src/ui/*.java src/Main.java
```

Run

```bash
java -cp "bin;lib/mysql-connector-j-9.3.0.jar" Main
```

---

## 📸 Screenshots

### Login Page

> Add Screenshot Here

---

### Registration Page

> Add Screenshot Here

---

### Dashboard

> Add Screenshot Here

---

### Flight Booking

> Add Screenshot Here

---

## 🔮 Future Enhancements

- Seat Selection System
- Online Payment Gateway
- PDF Ticket Generation
- QR Code Boarding Pass
- Flight Status Tracker
- Admin Panel
- Email Notifications
- Forgot Password
- OTP Verification
- Dark / Light Theme
- AI Flight Recommendation

---

## 🎯 Learning Outcomes

This project helped me learn:

- Java Swing GUI Development
- JDBC Connectivity
- MySQL Database Design
- CRUD Operations
- Event Handling
- Object-Oriented Programming
- Desktop Application Development

---

## 👨‍💻 Author

**Pintu Sahoo**

MCA Student | Java Developer | Cloud Computing Enthusiast

GitHub: https://github.com/SAHOOPINTU182

LinkedIn: https://linkedin.com/in/pintu-sahoo-086436236

---

## ⭐ Support

If you found this project helpful, consider giving it a **⭐ Star** on GitHub.

---

## 📄 License

This project is created for educational and learning purposes.
