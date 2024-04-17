package databasemodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePassword extends ConnectionLogin{
		Connection connection;

	public ChangePassword () throws SQLException {
		super();
		connection = getConnection(); 
	}
	public boolean updatepassword(String username,String oldpassword,String newpassword) {
		String query = "update users set password = ? where username = ?";
		
		try {
			PreparedStatement smt = connection.prepareStatement(query);
			smt.setString(1, newpassword);
			smt.setString(2, username);
			int result= smt.executeUpdate();
			
			if(result >0 ) {
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
public boolean checkPassword(String username, String password) {
	if(authentication(username,password)) {
		return true;
	}else {
		return false;
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
