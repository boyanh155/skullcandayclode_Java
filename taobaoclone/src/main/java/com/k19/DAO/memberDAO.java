package com.k19.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.k19.models.member;

import connection.postgresJDBCConnection;

public class memberDAO {

    // insert
    // Sign-up
    public int insertMember(final member member) throws ClassNotFoundException, SQLException {
        // make a pool
        Connection connection = postgresJDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        // connectionPool pool = connectionPool.getInstance();
        // Connection connection = postgresJDBCConnection.getJDBCConnection();
        final String INSERT_USERS_SQL = "INSERT INTO member(id ,firstName, lastName,fullName, username, password,email,gentle,contact,created_on)"
                + " VALUES  (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, now());";
        int result = 0;
        // 0 : failure
        try {
            ps = connection.prepareStatement(INSERT_USERS_SQL);
            // set increase num for id in db
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getFullName());
            ps.setString(4, member.getUsername());
            ps.setString(5, member.getPassword());
            ps.setString(6, member.getEmail());
            ps.setString(7, member.getGentle());
            ps.setString(8, member.getContact());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            connection.close();
            ps.close();
        }
        return result;
    }

    // select single
    // Sign-in
    // mirage authentication to pure Servlet
    public static member selectMember(final String username) throws SQLException {
        ResultSet rs;
        // make a pool
        Connection connection = postgresJDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;

        final String SELECT_USERS_SQL = "SELECT * FROM member WHERE username = ?";
        member datamember = null;
        try {
            ps = connection.prepareStatement(SELECT_USERS_SQL);
            ps.setString(1, username);
            // ps.setString(2, member.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                datamember = new member();
                datamember.setFirstName(rs.getString("firstName"));
                datamember.setLastName(rs.getString("lastName"));
                datamember.setFullName(rs.getString("fullName"));
                datamember.setUsername(rs.getString("username"));
                datamember.setPassword(rs.getString("password"));
                datamember.setEmail(rs.getString("email"));
                datamember.setContact(rs.getString("contact"));
                datamember.setGentle(rs.getString("gentle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            connection.close();
            ps.close();
        }
        return datamember;

        // Process fail
    }

    public static member checkMember(final String uname, final String password) {
        ResultSet rs;
        // make a pool
        Connection connection = postgresJDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        final String SELECT_USERS_SQL = "SELECT * FROM member WHERE username = ? AND password = ?";

        member datamember = null;
        try {
            ps = connection.prepareStatement(SELECT_USERS_SQL);
            ps.setString(1, uname);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                datamember = new member();
                datamember.setFirstName(rs.getString("firstName"));
                datamember.setLastName(rs.getString("lastName"));
                datamember.setFullName(rs.getString("fullName"));
                datamember.setUsername(rs.getString("username"));
                datamember.setPassword(rs.getString("password"));
                datamember.setEmail(rs.getString("email"));
                datamember.setContact(rs.getString("contact"));
                datamember.setGentle(rs.getString("gentle"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Process fail
        return datamember;

    }
    // Sign-in
    // haven't code

}
