package com.department.servlets;

import com.department.database.DepartmentQueries;
import lombok.extern.log4j.Log4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet deletes department by id
 */
@Log4j
@WebServlet(urlPatterns = "/DeleteDepartment")
public class DeleteDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int departmentId = Integer.parseInt(req.getParameter("id"));
            DepartmentQueries.deleteDepartment(departmentId);
            resp.sendRedirect("ListDepartment");
        } catch (IOException | NumberFormatException e) {
            log.error("Delete department error {GET} : " + e.getMessage());
        }
    }
}
