package com.k19.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.k19.models.product;

import connection.postgresJDBCConnection;

public class productDAO {

    // insert
    public int insertProduct(final product product) throws ClassNotFoundException, SQLException {
        // make a pool
        Connection connection = postgresJDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;
        // connectionPool pool = connectionPool.getInstance();
        // Connection connection = postgresJDBCConnection.getJDBCConnection();
        final String INSERT_PRODUCT_SQL = "insert into product(code,description,price) values(?,?,?)";
        int result = 0;
        // 0 : failure
        try {
            ps = connection.prepareStatement(INSERT_PRODUCT_SQL);
            // set increase num for id in db
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDesc());
            ps.setDouble(3, product.getPrice());
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

    // select
    public static product selectMember(final String productCode) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        // make a pool
        Connection connection = postgresJDBCConnection.getJDBCConnection();
        PreparedStatement ps = null;

        final String SELECT_USERS_SQL = "select * from product where code = ?";
        product dataproduct = null;
        try {
            ps = connection.prepareStatement(SELECT_USERS_SQL);
            ps.setString(1, productCode);
            // ps.setString(2, member.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                dataproduct = new product();
                dataproduct.setCode(productCode);
                dataproduct.setDesc(rs.getString("description"));
                dataproduct.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            connection.close();
            ps.close();
        }
        return dataproduct;

        // Process fail
    }
}
