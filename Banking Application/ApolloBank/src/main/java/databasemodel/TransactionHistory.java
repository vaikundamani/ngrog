package databasemodel;

import java.sql.*;
import java.util.ArrayList;

public class TransactionHistory extends ConnectionLogin{
	
	Connection connection;
	private int accountNumber;
	ArrayList<Date> date;
	ArrayList<String> type;
	ArrayList<Double> amount;
	ArrayList<String> holdername;
	ArrayList<Integer> holderaccount;

	public TransactionHistory() throws SQLException {
		super();
		connection = getConnection(); 
        date = new ArrayList<>();
        type = new ArrayList<>();
        amount = new ArrayList<>();
        holdername = new ArrayList<>();
        holderaccount = new ArrayList<>();
	}

	public boolean transactionHistory(int accountnumber) {
		this.accountNumber = accountnumber;
		
		String history = "select * from transactions where account_id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(history);
			statement.setInt(1, this.accountNumber);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				this.date.add(result.getDate("transaction_date")) ;
				this.type.add(result.getString("transaction_type"));
				this.amount.add(result.getDouble("amount"));
				this.holderaccount.add(result.getInt("accountholder_number"));
				this.holdername.add(result.getString("accountholder_name"));
			}
			return true;
		}catch(Exception e) {
			System.out.println();
			return false;
		}
	}

	public ArrayList<Date> getDate() {
        return date;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public ArrayList<Double> getAmount() {
        return amount;
    }

    public ArrayList<String> getHoldername() {
        return holdername;
    }

    public ArrayList<Integer> getHolderaccount() {
        return holderaccount;
    }	

}
