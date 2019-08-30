package com.department.database;

import com.department.model.Department;
import lombok.extern.log4j.Log4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The class works with the table of Department
 */
@Log4j
public class DepartmentQueries {

    private DepartmentQueries() {
    }

    public static void createTableDepart() {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.CREATE_DEPARTMENTS_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Create Depart Table error: " + e.getMessage());
        }
    }

    public static void addDepartment(String name) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.INSERT_DEPARTMENT)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Add Department error: " + e.getMessage());
        }
    }

    public static void updateDepartment(int id, String name) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.UPDATE_DEPARTMENT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Update Department error: " + e.getMessage());
        }
    }

    public static void deleteDepartment(int id) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.DELETE_DEPARTMENT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Delete Department Error: " + e.getMessage());
        }
    }

    public static List<Department> selectAllDep() {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.SELECT_ALL_DEPARTMENTS)) {
            List<Department> departments = new CopyOnWriteArrayList<>();
            try (ResultSet res = preparedStatement.executeQuery()) {
                while (res.next()) {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    departments.add(new Department(id, name));
                }
                return departments;
            }
        } catch (SQLException e) {
            log.error("Select all department error: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static Department selectDepartment(String name) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.SELECT_DEPARTMENT_BY_ID)) {
            preparedStatement.setString(1, name);
            Department department = new Department();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    department.setDepartmentId(resultSet.getInt("id"));
                    department.setDepartmentName(resultSet.getString("name"));
                }
                return department;
            }
        } catch (SQLException e) {
            log.error("Select Department error: " + e.getMessage());
        }
        return new Department();
    }

    public static void dropDepartmentTable() {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(SqlQueries.DROP_DEPARTMENT_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error("Drop department table error: " + e.getMessage());
        }
    }
}