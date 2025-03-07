package com.example.servlet;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for handling requests related to editing student details.
 */
@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    /**
     * Handles the HTTP POST request to update student details.
     * 
     * @param request  The HTTP request object containing student details.
     * @param response The HTTP response object to redirect after update.
     * @throws ServletException If an error occurs during request handling.
     * @throws IOException      If an input or output error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Validate input
        String errorMessage = null;
        if (name == null || name.trim().isEmpty()) {
            errorMessage = "Name is required.";
        } else if (email == null || email.trim().isEmpty()) {
            errorMessage = "Email is required.";
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            errorMessage = "Invalid email format.";
        }

        if (errorMessage != null) {
            // If validation fails, forward back to editStudent.jsp with an error message
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setEmail(email);
            request.setAttribute("student", student);
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("editStudent.jsp").forward(request, response);
        } else {
            // If validation passes, proceed with updating the student
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setEmail(email);

            StudentDAO studentDAO = new StudentDAO();
            try {
                studentDAO.updateStudent(student);
                response.sendRedirect("viewStudent");
            } catch (Exception e) {
                // Handle potential exceptions and provide feedback
                throw new ServletException("Error updating student.", e);
            }
        }
    }

    /**
     * Handles the HTTP GET request to display the edit form for a specific student.
     * 
     * @param request  The HTTP request object containing the student ID.
     * @param response The HTTP response object to forward to the edit form.
     * @throws ServletException If an error occurs during request handling.
     * @throws IOException      If an input or output error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve student ID from the request
        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO studentDAO = new StudentDAO();
        try {
            // Fetch student details from the database
            Student student = studentDAO.getStudentById(id);
            request.setAttribute("student", student);
            request.getRequestDispatcher("editStudent.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle potential exceptions and provide feedback
            throw new ServletException("Error retrieving student details.", e);
        }
    }
}
