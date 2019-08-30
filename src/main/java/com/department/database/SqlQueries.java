package com.department.database;

/**
 * SQL queries for Database
 */
class SqlQueries {
    private SqlQueries() {
    }

    /**
     * Employee SQL queries
     */
    private static final String NAME_OF_TABLE = " EMPLOYEE ";
    static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS" + NAME_OF_TABLE
            + "(ID int(11)  NOT NULL AUTO_INCREMENT,"
            + " FIRSTNAME VARCHAR(50) NOT NULL, LASTNAME varchar(50) NOT NULL , "
            + " AGE int(120) NOT NULL, DEPARTMENTID int(11) NOT NULL, PRIMARY KEY(ID));";
    static final String INSERT_EMPLOYEE = "INSERT INTO" + NAME_OF_TABLE + "(FIRSTNAME, LASTNAME, AGE , DEPARTMENTID) "
            + " VALUES (?, ?, ?, ?);";
    static final String SELECT_ALL = "SELECT * FROM" + NAME_OF_TABLE + "WHERE DEPARTMENTID= ?;";
    static final String GET_EMPLOYEE = "SELECT ID,FIRSTNAME,LASTNAME,AGE,DEPARTMENTID FROM" + NAME_OF_TABLE + "WHERE ID = ?;";
    static final String UPDATE_EMPLOYEE = "UPDATE" + NAME_OF_TABLE + "SET FIRSTNAME = ?,LASTNAME = ?,AGE = ? WHERE ID = ?;";
    static final String DELETE_EMPLOYEE = "DELETE FROM" + NAME_OF_TABLE + "WHERE ID = ?;";
    static final String DROP_TABLE = "DROP TABLE" + NAME_OF_TABLE + ";";

    /**
     * Department SQL queries
     */
    static final String CREATE_DEPARTMENTS_TABLE = "CREATE TABLE IF NOT EXISTS DEPARTMENTS" +
            " (id int(11) NOT NULL AUTO_INCREMENT," +
            " name varchar(45) NOT NULL," +
            " PRIMARY KEY (id))";
    static final String INSERT_DEPARTMENT = "INSERT into DEPARTMENTS (name) VALUES(?);";
    static final String UPDATE_DEPARTMENT = "UPDATE DEPARTMENTS SET NAME = ? WHERE ID = ?;";
    static final String DELETE_DEPARTMENT = "DELETE from DEPARTMENTS WHERE ID = ?;";
    static final String SELECT_ALL_DEPARTMENTS = "SELECT * FROM DEPARTMENTS;";
    static final String SELECT_DEPARTMENT_BY_ID = "SELECT id,name From DEPARTMENTS where name=?";
    static final String DROP_DEPARTMENT_TABLE = "DROP TABLE DEPARTMENTS;";


}