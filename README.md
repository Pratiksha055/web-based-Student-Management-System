# web-based-Student-Management-System


Overview
The Student Management System is a web application that allows users to add, view, edit, and delete student records. It is built using Java Servlets, JSP, and MySQL for the backend, and it is deployed as a WAR file.

Setup Instructions

Prerequisites
●	Java Development Kit (JDK): Ensure JDK 8 or later is installed.
●	Apache Maven: Used for project build and dependency management.
●	MySQL: Database server for storing student records.
●	Apache Tomcat: Application server for running the web application.

Steps to Setup

1.	Configure Database
Create a new database in MySQL named student_management.
Run the provided SQL script (e.g., schema.sql) to set up the necessary tables.
Update database.properties with your database credentials:

Properties
i.	db.url=jdbc:mysql://localhost:3306/student_management
ii.	db.user=root
iii.	db.password= 23858594Par1!

3.	Build the Project
Ensure Maven is installed.
Navigate to the project directory and run:
i.	mvn clean package
This will generate a WAR file in the target directory.

4.	Deploy the Application
Ensure Tomcat is installed.
Copy the WAR file (e.g., student-management-1.0.war) to the webapps directory of your Apache Tomcat server.

Start or restart the Tomcat server:
i.	startup.sh start


6.	Access the Application
Open a web browser and go to http://localhost:8594/student-management.

