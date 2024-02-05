package com.servlet;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import LibraryPackage.Library;
import LibraryPackage.utils.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "create_user_servlet", value = "/create_user_servlet")
public class CreateUserServlet extends HttpServlet {
    static Library library;

    public void init() {
        try {
            DriverManager.registerDriver (new com.mysql.jdbc.Driver());
            library = new Library("jdbc:mysql://localhost:3306/jdbc", "root", "");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String email = req.getParameter("email-address");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
            out.println("<html><head><title>create user result</title><link rel=\"stylesheet\" href=\"style.css\"></head><body class=\"container\">");
            out.println("<div class=\"center\"><b class=\"res\">" + "name or email or password is empty!" + "</b><br><br>");
            out.println("<a href=\"create-user.jsp\" class=\"btn\">\n" +
                    "        <button type=\"button\" class=\"button\" value=\"back\">back</button>\n" +
                    "    </a>" +
                    "    <a href=\"index.jsp\" class=\"btn\">\n" +
                    "        <button type=\"button\" class=\"button\" value=\"back to main menu\">back to main menu</button>\n" +
                    "    </a></div>");
            out.println("</body></html>");
            return;
        }
        out.println("<html><head><title>create user result</title><link rel=\"stylesheet\" href=\"style.css\"></head><body class=\"container\">");
        out.println("<div class=\"center\"><b class=\"res\">" + library.addUser(new User(name,email,password)) + "</b><br><br>");
        out.println("<a href=\"create-user.jsp\" class=\"btn\">\n" +
                "        <button type=\"button\" class=\"button\" value=\"back\">back</button>\n" +
                "    </a>" +
                "    <a href=\"index.jsp\" class=\"btn\">\n" +
                "        <button type=\"button\" class=\"button\" value=\"back to main menu\">back to main menu</button>\n" +
                "    </a></div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}