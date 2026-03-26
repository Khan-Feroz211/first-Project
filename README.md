# 🎬 Academic Movie Booking System

A Java OOP project that displays movie information and show schedules retrieved from a MySQL database, using a Java Swing graphical user interface.

---

## 📌 Purpose

This project was built as a Project-Based Learning (PBL) exercise for an Object-Oriented Programming course. It demonstrates core OOP concepts — encapsulation, data-access objects, and GUI programming — by building a simple movie viewer that fetches data from a relational database.

---

## 🗂️ Project Structure

```
OOP pbl/
├── DBConnection.java   # Manages the MySQL JDBC connection
├── Movie.java          # Model class for movie data
├── Show.java           # Model class for show/screening data
├── User.java           # Model class for user data
├── MovieDAO.java       # Data Access Object – fetches movies & shows from DB
└── Home.java           # Main Swing GUI window (entry point)
```

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java (JDK 8+) | Core programming language |
| Java Swing | Desktop GUI |
| MySQL | Relational database |
| JDBC | Java–database connectivity |
| BlueJ | IDE used during development |

---

## 🗄️ Database Setup

1. Create a MySQL database named `academic_movie_booking`.
2. Create the required tables:

```sql
CREATE TABLE movie_details (
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(100),
    language  VARCHAR(50),
    genre     VARCHAR(50),
    duration  INT,
    starring  VARCHAR(200),
    rating    VARCHAR(10)
);

CREATE TABLE show_schedule (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    movie_id        INT,
    show_time       DATETIME,
    capacity        INT,
    available_seats INT,
    place           VARCHAR(100),
    FOREIGN KEY (movie_id) REFERENCES movie_details(id)
);
```

3. Open `DBConnection.java` and update the credentials to match your local MySQL setup:

```java
private static final String URL      = "jdbc:mysql://localhost:3306/academic_movie_booking";
private static final String USER     = "your_username";
private static final String PASSWORD = "your_password";
```

---

## ▶️ How to Run

### Using BlueJ
1. Open BlueJ and load the `OOP pbl` folder as a project.
2. Right-click the `Home` class and select **Run** (or call `main`).

### Using the command line
```bash
# Compile (make sure mysql-connector-java.jar is on the classpath)
javac -cp .;mysql-connector-java.jar *.java

# Run
java -cp .;mysql-connector-java.jar Home
```
> On macOS/Linux replace `;` with `:` in the classpath separator.

---

## 🖥️ How to Use

1. Launch the application — the **Movie Info Viewer** window opens.
2. Click **"Load Movies From Database"**.
3. All movies and their scheduled shows are displayed in the text area.

---

## 👤 Authors

- **Khan Feroz** — OOP PBL Project

