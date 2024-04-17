
package databasemodel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoneyTransfer extends ConnectionLogin{

	public MoneyTransfer() throws SQLException {
		super();
	}
	
	public void moneyTransfer(double amount,int accountnumber) {
		
		String query = "update accounts set balance=balance+? where account_id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDouble(1, amount);
			statement.setInt(2, accountnumber);
			statement.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}		

	}
	
