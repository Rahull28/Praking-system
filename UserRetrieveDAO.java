package com.parking.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.parking.model.userretrive;
import com.parking.dbconnection.*;

public class UserRetrieveDAO {

    public List<userretrive> getAllUsers() {
        List<userretrive> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Get database connection
            conn = dbconnection.getConnection();

            // SQL query to fetch users from the usertable
            String query = "SELECT id, username, password FROM usertable";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            // Loop through result set and populate User objects
            while (rs.next()) {
            	userretrive user = new userretrive(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
