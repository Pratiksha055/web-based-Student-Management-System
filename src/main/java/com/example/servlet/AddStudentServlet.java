package com.example.servlet;

import java.io.IOException;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet for handling requests related to adding new students.
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    /**
     * Handles the HTTP POST request to add a new student.
     * 
     * @param request  The HTTP request object containing form data.
     * @param response The HTTP response object to send the response.
     * @throws ServletException If an error occurs during request handling.
     * @throws IOException      If an input or output error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            // If validation fails, forward back to addStudent.jsp with an error message
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("addStudent.jsp").forward(request, response);
        } else {
            // If validation passes, proceed with adding the student
            Student student = new Student();
            student.setName(name);
            student.setEmail(email);

            StudentDAO studentDAO = new StudentDAO();
            try {
                studentDAO.addStudent(student);
                response.sendRedirect("viewStudent");
            } catch (Exception e) {
                throw new ServletException("Error adding student", e);
            }
        }
    }

    /**
     * Handles the HTTP GET request to display the add student form.
     * 
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @throws ServletException If an error occurs during request handling.
     * @throws IOException      If an input or output error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addStudent.jsp").forward(request, response);
    }
}
