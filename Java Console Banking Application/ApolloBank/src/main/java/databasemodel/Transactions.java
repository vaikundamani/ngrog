package databasemodel;

import java.sql.*;
import java.sql.SQLException;

public class Transactions {
	
	private Connection connection;
	private int accountid;
	private String transactiontype;
	private double amount;
	private String holdername;
	private int holderaccountnum;
	private int holderUser_id;
	
	public Transactions() throws SQLException{
		connection = new ConnectionLogin().getConnection();
	}
	
	public static void main(String[] args) throws SQLException {
		Transactions x = new Transactions();
		System.out.println(x.checkAccount(101001));

	}
	
	public void transactionHistory(int accountnumber,String transactiontype, double amount) {
		this.accountid = accountnumber;
		this.transactiontype = transactiontype;
		this.amount = amount;
		
		//this query is the deposit withdraw transaction history save to database
		String transaction = "insert into transactions(account_id,transaction_type,amount) values(?,?,?) ";
		try {
		PreparedStatement statement = connection.prepareStatement(transaction);
		statement.setInt(1, this.accountid);
		statement.setString(2, this.transactiontype);
		statement.setDouble(3, this.amount);
		
		statement.executeUpdate();
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void transactionHistory(int accountid,String transactiontype, double amount,String holdername,int holderaccountnum) {
		this.accountid = accountid;
		this.transactiontype = transactiontype;
		this.amount = amount;
		this.holdername = holdername;
		this.holderaccountnum =holderaccountnum;
		
		//this query is the money transfer transaction history save to database
		String transaction = "insert into "
				+ "transactions(account_id,transaction_type,amount,accountholder_name,accountholder_number) "
				+ "values(?,?,?,?,?) ";
		try {
		PreparedStatement statement = connection.prepareStatement(transaction);
		statement.setInt(1, this.accountid);
		statement.setString(2, this.transactiontype);
		statement.setDouble(3, this.amount);
		statement.setString(4,this.holdername);
		statement.setInt(5, this.holderaccountnum);
		statement.executeUpdate();
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}	
	
	public boolean checkAccount(int accountnumber) {
		this.accountid = accountnumber;
		
		String checking = "select * from accounts where account_id = ?";
		try {
		PreparedStatement statement = connection.prepareStatement(checking);
		statement.setInt(1, this.accountid);
		ResultSet result = statement.executeQuery();
		return result.next();
		
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}

	}
	
	public boolean receiverHistory(int accountnumber) {
	    String checking = "SELECT user_id FROM accounts WHERE account_id = ?";
	    try {
	        PreparedStatement statement = connection.prepareStatement(checking);
	        statement.setInt(1, accountnumber);
	        ResultSet result = statement.executeQuery();
	        
	        if (result.next()) {
	            int userid = result.getInt("user_id");
	            this.holderUser_id = userid;
	            return true;
	        } else {
	            System.err.println("No user found for the provided account number.");
	            return false;
	        }
	    } catch (SQLException e) {
	        System.err.println("Error executing SQL query: " + e.getMessage());
	        return false;
	    }
	}


	public int getHolderUser_id() {
		return holderUser_id;
	}

}
