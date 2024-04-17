package databasemodel;

import java.sql.*;

public class ForgotUserName extends ConnectionLogin{

	Connection connection;
	
	public ForgotUserName() throws SQLException {
		super();
		connection = getConnection();
	}
	
	public String getUsername(String phonenumber) {
		
		String query = "select username from users where phone_number = ?";
		
		try {
			PreparedStatement smt = connection.prepareStatement(query);
			smt.setString(1, phonenumber);
			ResultSet result = smt.executeQuery();
			
			if(result.next()) {
				return result.getString("username");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
		
	}

}
