package databasemodel;

import java.sql.*;

public class NewAccountCreation extends ConnectionLogin{
	
	Connection connection;
	private String username;
	private int user_id;
	private String password;
	private String email;
	private String phone;
	private String accountType;
	
	
	public NewAccountCreation() throws SQLException {
		super();
	}

	protected boolean checkuserName(String user_name)  {
		
		String username = "Select * from users where username = ?";
		this.connection = getConnection();
		
		try {
		PreparedStatement statement = connection.prepareStatement(username);
		statement.setString(1, user_name);
		ResultSet result = statement.executeQuery();
		return result.next();
				
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public int newuser(String username,String password, String email,String phone , String accounttype) {
		
		this.connection = getConnection();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.accountType = accounttype;
		
		String newaccountQuery = "insert into users( username,password, email,phone_number) "
				+ "values (?,?,?,?);";
		try {
		PreparedStatement statement = connection.prepareStatement(newaccountQuery);
		statement.setString(1, this.username);
		statement.setString(2, this.password);
		statement.setString(3, this.email);
		statement.setString(4, this.phone);
		
		statement.executeUpdate();
		 
		 accountSetup();
		return this.user_id;
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	boolean accountSetup() {
		
		String accountsetup = "insert into accounts(user_id, account_type) values(?,?);";
		
		try {
			authentication(this.username,this.password);
			this.user_id = getUserId();
			
		PreparedStatement statement = connection.prepareStatement(accountsetup);
		statement.setInt(1, this.user_id);
		statement.setString(2, this.accountType);
		
		int result = statement.executeUpdate();
		
		
		 if(result > 0) {
			 return true;
		 }else {
			 return false;
		 }
		}catch(Exception e) {	
			System.out.println(e);
			return false;
		}
		
	}

}
