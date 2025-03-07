<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Edit Student</title>
    <!-- Link to external CSS stylesheet for styling -->
    <link rel="stylesheet" type="text/css" href="resources/styles.css" />
  </head>
  <body>
    <div class="container">
      <h1>Edit Student</h1>

      <!-- Display error message if present -->
      <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
      </c:if>

      <!-- Form for editing an existing student -->
      <form action="editStudent" method="post">
        <input type="hidden" name="id" value="${student.id}" />

        <label for="name">Name:</label>
        <input
          type="text"
          id="name"
          name="name"
          value="${student.name}"
        /><br />

        <label for="email">Email:</label>
        <input
          type="text"
          id="email"
          name="email"
          value="${student.email}"
        /><br />

        <input type="submit" value="Update Student" />
      </form>

      <!-- Back to home button -->
      <a href="viewStudent" class="button back-button">Back to Home</a>
    </div>

    <!-- JavaScript to hide error message if empty -->
    <script>
      window.addEventListener("DOMContentLoaded", (event) => {
        const errorMessageDiv = document.querySelector(".error-message");
        if (errorMessageDiv && !errorMessageDiv.textContent.trim()) {
          errorMessageDiv.classList.add("hidden");
        }
      });
    </script>
  </body>
</html>
