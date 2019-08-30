package com.department.databasetest;

import com.department.database.DepartmentQueries;
import com.department.model.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DepartmentQueriesTest {
    @Before
    public void initialize() {
        DepartmentQueries.createTableDepart();
        DepartmentQueries.addDepartment("TestDP");
    }
    @After
    public void destroy() {
        DepartmentQueries.dropDepartmentTable();
    }
    @Test
    public void updateDepartment() {
        DepartmentQueries.updateDepartment(1,"TestDP");
        Department department =  DepartmentQueries.selectDepartment("TestDP");
        String name = department.getDepartmentName();
        Assert.assertEquals("TestDP",name);
    }
    @Test
    public void getAllDepartment() {
        List<Department> departments = DepartmentQueries.selectAllDep();
        Assert.assertFalse(departments.isEmpty());
    }
    @Test
    public void dropDepartmentTable() {
        DepartmentQueries.deleteDepartment(1);
        Department department = DepartmentQueries.selectDepartment("TestDP");
        Assert.assertNull(department.getDepartmentName());
    }
}
