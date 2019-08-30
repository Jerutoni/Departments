package com.department.databasetest;

import com.department.database.EmployeeQueries;
import com.department.model.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class EmployeeQueriesTest {
    @Before
    public void initialize() {
        EmployeeQueries.createEmployeeTable();
        EmployeeQueries.insertEmployee("Eugene", "Ivan", 24, 1);
    }

    @After
    public void destroy() {
        EmployeeQueries.dropEmployeeTable();
    }

    @Test
    public void getEmployee() {
        Employee employee = EmployeeQueries.getEmployee(1);
        String firstName = employee.getFirstName();
        Assert.assertEquals("Eugene",firstName);
    }
    @Test
    public void updateEmployee() {
        EmployeeQueries.updateEmployee("Oleg","Kalash",24,1);
        Employee employee = EmployeeQueries.getEmployee(1);
        String firstName = employee.getFirstName();
        Assert.assertEquals("Oleg",firstName);
    }
    @Test
    public void getAllEmployee() {
        List<Employee> employees = EmployeeQueries.selectAllEmployee(1);
        Assert.assertFalse(employees.isEmpty());
    }
    @Test
    public void deleteEmployee() {
        EmployeeQueries.deleteEmployee(1);
        Employee employee = EmployeeQueries.getEmployee(1);
        String firstName = employee.getFirstName();
        Assert.assertNull(firstName);
    }
}
