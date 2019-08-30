package com.department.servlets;

import com.department.database.EmployeeQueries;
import com.department.model.Employee;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The servlet lists all
 * Employees
 */
@Log4j
@WebServlet(urlPatterns = "/ListEmployee")
public class ListEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int departmentId = Integer.parseInt(req.getParameter("id"));
            List<Employee> employees = EmployeeQueries.selectAllEmployee(departmentId);
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("WEB-INF/jsp/ListEmployee.jsp").forward(req, resp);

        } catch (ServletException | IOException | NumberFormatException e) {
            log.error("List Employee error {GET}: " + e.getMessage());
        }
    }
}
