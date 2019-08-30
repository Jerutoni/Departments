package com.department.servlets;

import com.department.database.EmployeeQueries;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet adds Employees
 */
@Log4j
@WebServlet(urlPatterns = "/AddEmployees")
public class AddEmployees extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        try {
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("departmentID"));
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            int age = Integer.parseInt(req.getParameter("age"));
            EmployeeQueries.insertEmployee(firstName, lastName, age, id);
            resp.sendRedirect("ListEmployee?id=" + req.getParameter("departmentID"));
        } catch (IOException | NumberFormatException e) {
            log.error("Add employees error {POST} : " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            String departmentId = req.getParameter("id");
            req.setAttribute("departmentID", departmentId);
            req.getRequestDispatcher("WEB-INF/jsp/AddEmployees.jsp").forward(req, resp);

        } catch (ServletException | IOException e) {
            log.error("Add employees error {GET} : " + e.getMessage());
        }
    }
}
