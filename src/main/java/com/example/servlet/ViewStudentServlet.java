package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet for handling requests to view all students.
 */
@WebServlet("/viewStudent")
public class ViewStudentServlet extends HttpServlet {

    /**
     * Handles the HTTP GET request to retrieve and display all students.
     * 
     * @param request  The HTTP request object.
     * @param response The HTTP response object to forward the student list.
     * @throws ServletException If an error occurs during request handling.
     * @throws IOException      If an input or output error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create an instance of StudentDAO to interact with the database
        StudentDAO studentDAO = new StudentDAO();

        try {
            // Retrieve all students from the database
            List<Student> students = studentDAO.getAllStudents();

            // Set the list of students as a request attribute
            request.setAttribute("students", students);

            // Forward the request to the JSP page for displaying students
            request.getRequestDispatcher("viewStudent.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle exceptions by throwing a ServletException
            throw new ServletException("Error retrieving student data.", e);
        }
    }
}
