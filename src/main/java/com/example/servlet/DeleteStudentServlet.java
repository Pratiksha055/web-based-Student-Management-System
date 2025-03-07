package com.example.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.example.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet for handling requests related to deleting students.
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Handles the HTTP POST request to delete a student based on the provided ID.
     * 
     * @param request  The HTTP request object containing the student ID.
     * @param response The HTTP response object to redirect after deletion.
     * @throws ServletException If an error occurs during request handling.
     * @throws IOException      If an input or output error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            try {
                int studentId = Integer.parseInt(id);
                StudentDAO studentDAO = new StudentDAO();
                studentDAO.deleteStudent(studentId);
                response.sendRedirect("viewStudent");
            } catch (NumberFormatException e) {
                // Handle case where ID is not a valid integer
                throw new ServletException("Invalid student ID format.", e);
            } catch (SQLException e) {
                // Handle database errors
                throw new ServletException("Error deleting student from the database.", e);
            }
        } else {
            // Handle case where ID parameter is missing or empty
            throw new ServletException("Student ID is required for deletion.");
        }
    }
}
