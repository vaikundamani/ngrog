package databasemodel;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountInformation {
	private int user_id;
	private String username;
	private int accountNumber;
	private String account_type;
	private String branch;
	private String ifsc;
	private String email;
	private String Phone_number;
	private Date register_date;
	private double balance;

	public void accountInformation(int userid) throws SQLException {
		//Connection to database from Connection Login Class
		ConnectionLogin con = new ConnectionLogin();
		
		//fetchinng data from 2 tables users table and accounts table
		String query = "SELECT users.*, accounts.account_id, accounts.user_id, accounts.account_type, accounts.branch, accounts.ifsc, accounts.balance " +
	               "FROM users " +
	               "INNER JOIN accounts ON users.user_id = accounts.user_id " +
	               "WHERE users.user_id = ?";
		
		PreparedStatement smt = con.getConnection().prepareStatement(query);
		smt.setInt(1, userid);
		ResultSet result = smt.executeQuery();
		result.next();
		
		this.user_id =result.getInt("user_id");
		this.username =  result.getString("username");
		this.accountNumber = result.getInt("account_id");
		this.account_type = result.getString("account_type");
		this.branch = result.getString("branch");
		this.ifsc = result.getString("ifsc");
		this.email = result.getString("email");
		this.Phone_number = result.getString("phone_number");
		this.register_date =  result.getDate("registration_date");
		this.balance = result.getDouble("balance");

	}
	

	public int getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccount_type() {
		return account_type;
	}

	public String getBranch() {
		return branch;
	}

	public String getIfsc() {
		return ifsc;
	}

	public String getEmail() {
		return email;
	}


	public String getPhone_number() {
		return Phone_number;
	}

	public Date getRegister_date() {
		return register_date;
	}
	public double getBalance() {
		return balance;
	}

}
