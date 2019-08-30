package com.department.servlets;

import com.department.database.EmployeeQueries;
import com.department.model.Employee;
import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet deletes Employee by id
 */
@Log4j
@WebServlet(urlPatterns = "/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        try {
            int employeeId = Integer.parseInt(req.getParameter("id"));
            Employee employee = EmployeeQueries.getEmployee(employeeId);
            EmployeeQueries.deleteEmployee(employeeId);
            resp.sendRedirect("/ListEmployee?id=" + employee.getDepartmentID());
        } catch (IOException | NumberFormatException e) {
            log.error("Dele employee error {GET}: " + e.getMessage());
        }
    }
}
