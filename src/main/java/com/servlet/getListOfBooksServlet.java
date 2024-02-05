package com.servlet;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import LibraryPackage.Library;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "get_list_of_books_servlet", value = "/get_list_of_books_servlet")
public class getListOfBooksServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DriverManager.registerDriver (new com.mysql.jdbc.Driver());
            Library library = new Library("jdbc:mysql://localhost:3306/jdbc", "root", "");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + library.getAllBook() + "</h1>");
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}