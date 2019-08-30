package com.department.database;

import com.department.model.Employee;
import lombok.extern.log4j.Log4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The class works with the table of Employees
 */
@Log4j
public class EmployeeQueries {

    private EmployeeQueries() {
    }

    public static void createEmployeeTable() {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.CREATE_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.info("Table Employee was not created " + e.getMessage());
        }
    }

    public static void insertEmployee(String firstName, String lastName, int age, int departmentID) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.INSERT_EMPLOYEE)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, departmentID);
            preparedStatement.executeUpdate();
            log.info("Insert Employee complete");

        } catch (SQLException e) {
            log.error("InsertEmployee error" + e.getMessage());
        }
    }

    public static void updateEmployee(String firstName, String lastName, int age, int id) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.UPDATE_EMPLOYEE)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            log.error("Update Employee error" + e.getMessage());
        }
    }

    public static Employee getEmployee(int id) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.GET_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            Employee employee = new Employee();
            try (ResultSet res = preparedStatement.executeQuery()) {
                while (res.next()) {
                    employee.setId(res.getInt("ID"));
                    employee.setFirstName(res.getString("FIRSTNAME"));
                    employee.setLastName(res.getString("LASTNAME"));
                    employee.setDepartmentID(res.getInt("departmentId"));
                }
                return employee;
            }
        } catch (SQLException e) {
            log.error("Get Employee error" + e.getMessage());
        }
        return new Employee();
    }

    public static List<Employee> selectAllEmployee(int departmentID) {
        List<Employee> employees = new CopyOnWriteArrayList<>();
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.SELECT_ALL)) {
            preparedStatement.setInt(1, departmentID);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String firstName = rs.getString("FIRSTNAME");
                    String lastName = rs.getString("LASTNAME");
                    int age = rs.getInt("AGE");
                    int departID = rs.getInt("departmentID");
                    Employee employee = new Employee(id, firstName, lastName, age, departID);
                    employees.add(employee);
                }
                return employees;
            }
        } catch (SQLException e) {
            log.error("Select All Employee error " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void deleteEmployee(int id) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("DeleteEmployee error " + e.getMessage());
        }
    }

    public static void dropEmployeeTable() {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.DROP_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Drop EmTable error " + e.getMessage());
        }
    }
}
