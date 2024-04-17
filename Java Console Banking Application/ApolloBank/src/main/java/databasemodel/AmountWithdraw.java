package databasemodel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AmountWithdraw extends AccountInformation{
	private int user_id;
	private int accountnumber;
	private double updateamount;
	private double depitamount;
	
	
	public boolean depitedAmount(double amount,int userid) {
		this.user_id = userid;
		this.depitamount = amount;
		
		String depitequery = "update accounts set balance=balance-? where account_id = ?";
		
		try {
			Connection connection= new ConnectionLogin().getConnection();
			PreparedStatement statement =connection.prepareStatement(depitequery);
			
			//get account number
			accountInformation(this.user_id);
			this.accountnumber = getAccountNumber();
			
			statement.setDouble(1, this.depitamount);
			statement.setInt(2, this.accountnumber);
			
			int updated = statement.executeUpdate();
			accountInformation(this.user_id);
			this.updateamount = getBalance();
			if(updated > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	public int getUser_id() {
		return user_id;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public double getUpdateamount() {
		return updateamount;
	}

	public double getDepitamount() {
		return depitamount;
	}

}
