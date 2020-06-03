package com.example.CATME.signup;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.*;

import com.example.CATME.user.User;

public class EmailValidatorImpl implements ConstraintValidator<EmailValidator, Object> {

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		User user = (User) obj;
		String value = user.getEmail();

		Connection myConn;
		try {
			myConn = DriverManager.getConnection(

					"jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_21_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",

					"CSCI5308_21_TEST_USER", "CSCI5308_21_TEST_21529");
			Statement statement = myConn.createStatement();
			String query = "Select * from USER where email='" + value + "';";

			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				return false;
			} else
				return true;

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
}
