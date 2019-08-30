package com.department.servlets;

import com.department.database.DepartmentQueries;
import com.department.database.EmployeeQueries;
import com.department.model.Department;
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
 * departments
 */
@Log4j
@WebServlet(urlPatterns = "/ListDepartment")
public class ListDepartment extends HttpServlet {
    @Override
    public void init() {
        EmployeeQueries.createEmployeeTable();
        DepartmentQueries.createTableDepart();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Department> departments = DepartmentQueries.selectAllDep();
            req.setAttribute("departments", departments);
            req.getRequestDispatcher("WEB-INF/jsp/list.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.error("List departments error {GET}: " + e.getMessage());
        }
    }
}
