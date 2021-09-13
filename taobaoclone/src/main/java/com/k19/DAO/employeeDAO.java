package com.k19.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.k19.models.employeeModel;

public class employeeDAO {
    private static final int PORT = 3306;
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:" + PORT + "/tikidb";
    private static final String ID = "root";
    private static final String PASS = "EaSport69696969";

    public int registerEmployee(final employeeModel employee) throws ClassNotFoundException {
        final String INSERT_USERS_SQL = "INSERT INTO employee  (id, first_name, last_name, username, password, address, contact,gentle) VALUES  (?, ?, ?, ?, ?,?,?,?);";
        int result = 0;
        Class.forName(DRIVER_NAME);
        try (final Connection connection = DriverManager.getConnection(DB_URL, ID, PASS);
                final PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
            ps.setInt(1, 1);
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getUsername());
            ps.setString(5, employee.getPassword());
            ps.setString(6, employee.getAddress());
            ps.setString(7, employee.getContact());
            ps.setString(8, employee.getGentle());
            System.out.println(ps);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
