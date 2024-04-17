package datacontroller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import databasemodel.TransactionHistory;
import inputviews.Login;

public class TransactionHistoryRes  {
	
	Scanner scanner;
	ArrayList<Date> date;
	ArrayList<String> type;
	ArrayList<Double> amount;
	ArrayList<String> holdername;
	ArrayList<Integer> holderaccount;
	
	public TransactionHistoryRes(){
		scanner = new Scanner(System.in);
        date = new ArrayList<>();
        type = new ArrayList<>();
        amount = new ArrayList<>();
        holdername = new ArrayList<>();
        holderaccount = new ArrayList<>();
	}
	
public void trasanctionres(String username, double balance, int userid,int accountnumber) {
		try {
			TransactionHistory	data = new TransactionHistory();
			
			if(data.transactionHistory(accountnumber)) {
				this.date  = data.getDate();
				this.type = data.getType();
				this.amount = data.getAmount();
				this.holdername = data.getHoldername();
				this.holderaccount = data.getHolderaccount();
				
				System.out.println("+------------------+------------------------+------------------+-------------------+------------------------+");
				System.out.println("| Date             | TransactionType        | Amount           | HolderAccount     | HolderName             |");
				System.out.println("+------------------+------------------------+------------------+-------------------+------------------------+");
				for (int x = 0; x < date.size(); x++) {
				    String transactionType = type.get(x);
				    
				    String amountColor = (transactionType.equals("Withdraw")) ? "\u001B[31m-" : 
	                     (transactionType.equals("Deposit")) ? "\u001B[32m+" :
	                     (transactionType.equals("Transfer")) ? "\u001B[33m-" : "\u001B[34m+";
				    
				    System.out.printf("| %-16s | %-22s | %s%-15.2f\u001B[0m | %-17d | %-21s |\n", 
				                      date.get(x), 
				                      transactionType, 
				                      amountColor, 
				                      amount.get(x), 
				                      holderaccount.get(x), 
				                      (holdername.get(x) == null) ? " " : holdername.get(x));
				}
				System.out.println("+------------------+------------------------+------------------+-------------------+------------------------+");
				
				System.out.println("Press Enter to Back ");
				scanner.nextLine();
				
				new Login().user(username, balance, userid, accountnumber);
			}else {
				new Login().user(username, balance, userid, accountnumber);
			}
		} catch (SQLException e) {
			new Login().user(username, balance, userid, accountnumber);
			e.printStackTrace();
		}
	}

}
