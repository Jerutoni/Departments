package com.department.servlets;

import com.department.database.DepartmentQueries;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet adds department
 */
@Log4j
@WebServlet(urlPatterns = "/addDepartment")
public class AddDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("WEB-INF/jsp/addDepartment.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.error("Add department error {GET}: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("departmentname");
            DepartmentQueries.addDepartment(name);
            resp.sendRedirect("/ListDepartment");
        } catch (IOException e) {
            log.error("Add department error {post}: " + e.getMessage());
        }
    }
}
