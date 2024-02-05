package com.servlet;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import LibraryPackage.Library;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "get_list_of_users_servlet", value = "/get_list_of_users_servlet")
public class GetListOfUsersServlet extends HttpServlet {
    static Library library;

    public void init() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            library = new Library("jdbc:mysql://localhost:3306/jdbc", "root", "");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>get users result</title><link rel=\"stylesheet\" href=\"style.css\"></head><body class=\"container\">");
        out.println("<div class=\"center\"><b style=\"\n" +
                "    color: #fff; font: 12px \"\";\">" + library.getAllUsers() + "</b><br><br>");
        out.println("<a href=\"index.jsp\" class=\"btn\">" +
                "    <button type=\"button\" class=\"button\" value=\"back to main menu\">back to main menu</button>\n" +
                "    </a></div>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}