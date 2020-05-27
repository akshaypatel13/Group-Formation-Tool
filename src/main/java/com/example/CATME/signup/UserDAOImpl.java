package com.example.CATME.signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO {

	@Override
	public void register(User user) {

		System.out.println("reached daooo!!");
		try {
			Connection myConn = DriverManager.getConnection(

					"jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_21_DEVINT?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",

					"CSCI5308_21_DEVINT_USER", "CSCI5308_21_DEVINT_21168");

			Statement statement = myConn.createStatement();
			System.out.println(user.getFirstname());
			String query1 = "Insert into USER(user_id , first_name , last_name ,email) " + "Values (6,'"
					+ user.getFirstname() + "','" + user.getLastname() + "' , '" + user.getEmail() + "');";
			int resultSet1 = statement.executeUpdate(query1);

			System.out.println("reached connection!!");
			System.out.println(resultSet1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
