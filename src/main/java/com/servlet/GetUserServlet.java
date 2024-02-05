package com.servlet;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import LibraryPackage.Library;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "get_user_servlet", value = "/get_user_servlet")
public class GetUserServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("user-id");
        PrintWriter out = resp.getWriter();
        if (id.isEmpty()){
            out.println("<html><head><title>get user result</title><link rel=\"stylesheet\" href=\"style.css\"></head><body class=\"container\">");
            out.println("<div class=\"center\"><b class=\"res\">" + "id is empty!" + "</b><br><br>");
            out.println("<a href=\"create-user.jsp\" class=\"btn\">\n" +
                    "        <button type=\"button\" class=\"button\" value=\"back\">back</button>\n" +
                    "    </a>" +
                    "    <a href=\"index.jsp\" class=\"btn\">\n" +
                    "        <button type=\"button\" class=\"button\" value=\"back to main menu\">back to main menu</button>\n" +
                    "    </a></div>");
            out.println("</body></html>");
            return;
        }
        out.println("<html><head><title>get user result</title><link rel=\"stylesheet\" href=\"style.css\"></head><body class=\"container\">");
        out.println("<div class=\"center\"><b class=\"res\">" + library.getUser(Integer.parseInt(id)) + "</b><br><br>");
        out.println("<a href=\"get-user.jsp\" class=\"btn\">\n" +
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