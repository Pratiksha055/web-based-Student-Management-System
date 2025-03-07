<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
    <!-- Link to external CSS stylesheet for consistent styling -->
    <link rel="stylesheet" type="text/css" href="resources/styles.css">
</head>
<body>
    <div class="container">
        <!-- Main heading for the page -->
        <h1>Student Management System</h1>
        
        <!-- Button to navigate to the Add Student page -->
        <a href="addStudent" class="button add-button">Add New Student</a>
        
        <!-- Add spacing between the buttons and the table -->
        <br/>
        <br/>

        <!-- Table displaying the list of students -->
        <table class="student-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterate through the list of students and display each one -->
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>
                            <!-- Button to edit the student -->
                            <a href="editStudent?id=${student.id}" class="button edit-button">Edit</a>
                            
                            <!-- Form to delete the student -->
                            <form action="deleteStudent" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="${student.id}">
                                <input type="submit" value="Delete" class="button delete-button">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Button to navigate back to the home page -->
        <a href="index.jsp" class="button back-button">Back to Home</a>
    </div>
</body>
</html>
