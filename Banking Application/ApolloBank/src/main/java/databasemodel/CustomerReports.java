package databasemodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerReports extends ConnectionLogin{
	Connection connection;
	private String username;
	private String text;

	public CustomerReports() throws SQLException {
		super();
		connection = getConnection();
	}
	
	public void reportCompliance(String username, String text) {
		String query = "insert into customer_care(username,compliance) values(?,?);";
		this.username = username;
		this.text = text;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, this.username);
			statement.setString(2,this. text);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
}
