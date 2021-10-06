package com.k19.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.k19.models.member;

import connection.postgresJDBCConnection;

public class memberDAO {
    private final Connection connection = postgresJDBCConnection.getJDBCConnection();

    // Sign-up
    public int registerMember(final member member) throws ClassNotFoundException, SQLException {
        // Connection connection = postgresJDBCConnection.getJDBCConnection();
        final String INSERT_USERS_SQL = "INSERT INTO member(id ,firstName, lastName,fullName, username, password,email,gentle,contact,created_on)"
                + " VALUES  (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, now());";
        int result = 0;
        try (final PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {

            // set increase num
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getFullName());
            ps.setString(4, member.getUsername());
            ps.setString(5, member.getPassword());
            ps.setString(6, member.getEmail());
            ps.setString(7, member.getGentle());
            ps.setString(8, member.getContact());
            System.out.println(ps);
            result = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return result;
    }

    // Sign-in
    // Authentication
    public boolean loginMember(final member member) throws ClassNotFoundException {
        ResultSet rs;
        boolean flagP = false;
        final String SELECT_USERS_SQL = "SELECT * FROM member WHERE username = ? AND password = ?";
        try (final PreparedStatement ps = connection.prepareStatement(SELECT_USERS_SQL)) {
            // String uname = employee.getUsername();
            // String passwd = employee.getPassword();
            ps.setString(1, member.getUsername());
            ps.setString(2, member.getPassword());

            rs = ps.executeQuery();
            System.out.println(rs);
            /*
             * while (rs.next()) {
             * 
             * // Display values // System.out.print("ID: " + rs.getInt("id")); // String
             * firstName = rs.getString("first_name"); // String lastName =
             * rs.getString("last_name"); // System.out.println("First name : " +
             * firstName); // Compare // if (rs.wasNull()) { // flagP = false; // return
             * flagP; // } else { // flagP = true; // return flagP; // }
             * 
             * 
             * }
             */
            flagP = rs.next();

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Process fail
        return flagP;
    }

}
