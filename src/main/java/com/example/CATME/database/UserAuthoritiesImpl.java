package com.example.CATME.database;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserAuthoritiesImpl implements UserAuthorities {
    @Override
    public List<GrantedAuthority> getUserAuthorities(String username) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Connection conn = null;
        Statement st = null;
        String query = "select * from authorities where username = '" + username + "'";
        try {
            // step 1: object connection from Mysql Connection util
            conn = MySQLConnection.getConnection();
            // step 2: create the statement to run the sql
            st = conn.createStatement();
            // step 3: run the sql
            ResultSet myRs = st.executeQuery(query);
            while (myRs.next()) {
                System.out.print(myRs.getString("authority"));
                authorities.add(new SimpleGrantedAuthority(myRs.getString("authority")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // step 6: close the connection
            MySQLConnection.closeConnection(conn, st);
        }
        return authorities;
    }
}
