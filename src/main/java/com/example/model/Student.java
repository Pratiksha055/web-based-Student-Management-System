package com.example.model;

/**
 * Represents a student with an ID, name, and email.
 */
public class Student {

    private int id; // The unique identifier for the student
    private String name; // The name of the student
    private String email; // The email of the student

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Parameterized constructor to initialize a student with the given ID, name,
     * and email.
     *
     * @param id    The unique identifier for the student.
     * @param name  The name of the student.
     * @param email The email of the student.
     */
    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Gets the unique identifier for the student.
     *
     * @return The student's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the student.
     *
     * @param id The student's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the student.
     *
     * @return The student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     *
     * @param name The student's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email of the student.
     *
     * @return The student's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the student.
     *
     * @param email The student's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
