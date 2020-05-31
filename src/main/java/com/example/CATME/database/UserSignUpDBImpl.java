package com.example.CATME.database;

import java.util.UUID;

import com.example.CATME.user.User;

public class UserSignUpDBImpl implements UserSignUpDB {

	private MySQLConnection myConn = new MySQLConnection();

	@Override
	public void insertGuestUser(User user) {

		final String uuid = UUID.randomUUID().toString().replace("-", "");
		final String rid = UUID.randomUUID().toString().replace("-", "");
		String query1 = "Insert into USER(user_id ,banner_id, first_name , last_name ,email,password) " + "Values ('"
				+ uuid + "', '" + user.getBannerId() + "','" + user.getFirstName() + "','" + user.getLastName()
				+ "' , '" + user.getEmail() + "','" + user.getPassword() + "');";

		String query2 = "Insert into ROLE(role_id,user_id,role) " + "Values ('" + rid + "' ,'" + uuid + "',1 );";

		myConn.updateQuery(query1);
		myConn.updateQuery(query2);

	}
}
