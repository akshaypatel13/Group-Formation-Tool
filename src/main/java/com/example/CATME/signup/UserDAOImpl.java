package com.example.CATME.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserDAOImpl implements UserDAO {

	@Override
	public void register(User user) {

		final String uuid = UUID.randomUUID().toString().replace("-", "");
		final String rid = UUID.randomUUID().toString().replace("-", "");

		try {
			Connection myConn = DriverManager.getConnection(

					"jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_21_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",

					"CSCI5308_21_TEST_USER", "CSCI5308_21_TEST_21529");

			Statement statement = myConn.createStatement();
			Statement statement1 = myConn.createStatement();
			System.out.println(user.getFirstname());
			String query1 = "Insert into USER(user_id ,banner_id, first_name , last_name ,email,password) "
					+ "Values ('" + uuid + "', '" + user.getBannerId() + "','" + user.getFirstname() + "','"
					+ user.getLastname() + "' , '" + user.getEmail() + "','" + user.getSetPassword() + "');";

			String query2 = "Insert into ROLE(role_id,user_id,role) " + "Values ('" + rid + "' ,'" + uuid + "',1 );";

			int resultSet1 = statement.executeUpdate(query1);
			statement1.executeUpdate(query2);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
