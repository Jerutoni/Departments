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

/**
 * The servlet updates the Employee by id
 */
@Log4j
@WebServlet(urlPatterns = "/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String employeeID = req.getParameter("id");
            req.setAttribute("employeeID", employeeID);
            req.getRequestDispatcher("WEB-INF/jsp/UpdateEmployee.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.error("Update Employee error {GET}: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            int age = Integer.parseInt(req.getParameter("age"));
            int employeeId = Integer.parseInt(req.getParameter("employeeID"));
            Employee employee = EmployeeQueries.getEmployee(employeeId);
            EmployeeQueries.updateEmployee(firstName, lastName, age, employeeId);
            resp.sendRedirect("ListEmployee?id=" + employee.getDepartmentID());
        } catch (IOException | NumberFormatException e) {
            log.error("Update Employee error {POST}: " + e.getMessage());
        }
    }
}
