package datacontroller;

import java.sql.SQLException;

import databasemodel.AmountWithdraw;
import databasemodel.Transactions;
import inputviews.Login;

public class WithdrawRes {
	private int user_id;
	private String username;
	private double debitamount;
	private double updatedamount;
	private int accountnumber;
	
	public void withdrawamount(int userid,String username,double amount,int accountnumber) throws SQLException {
		this.user_id = userid;
		this.debitamount= amount;
		this.username = username;
		this.accountnumber = accountnumber;
		
		AmountWithdraw obj = new AmountWithdraw();
		boolean entry =obj.depitedAmount(amount, userid);
		this.updatedamount= obj.getUpdateamount();
		
		if(entry ==true) {
			//transaction history saving
			new Transactions().transactionHistory(this.accountnumber, "Withdraw", amount);
			
			System.out.println("\u001B[32mAmount "+this.debitamount+" is Debited From You Account...\u001B[0m");
			System.out.println();
			new Login().user(this.username,this.updatedamount,this.user_id,this.accountnumber);
		}else {
			System.out.println("Entry Restricted....");
		}
	}
}
