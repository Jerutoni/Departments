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
 * The servlet updates the department by id
 */
@Log4j
@WebServlet(urlPatterns = "/UpdateDepartment")
public class UpdateDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("WEB-INF/jsp/UpdateDepartment.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            log.error("Update Department error {GET} " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            int departmentId = Integer.parseInt(req.getParameter("id"));
            String newDepartmentName = req.getParameter("departmentname");
            DepartmentQueries.updateDepartment(departmentId, newDepartmentName);
            resp.sendRedirect("ListDepartment");
        } catch (IOException | NumberFormatException e) {
            log.error("Update Department Error {POST} " + e.getMessage());
        }
    }
}
