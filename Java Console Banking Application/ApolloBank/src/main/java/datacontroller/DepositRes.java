package datacontroller;

import java.sql.SQLException;

import databasemodel.AccountInformation;
import databasemodel.AmountDeposit;
import databasemodel.Transactions;
import inputviews.Login;

public class DepositRes {
	
	private String username;
	private int user_id;
	private double updateAmount;
	private int accountnumber;
	
	public void depositToAccount(String username ,double amount,int userid, int accountnumber,double depAmount) throws SQLException {
		
		this.username = username;
		this.user_id = userid;
		this.accountnumber = accountnumber;
		AmountDeposit amtdept = new AmountDeposit();
		
		//saving account add 8% interest depsit time condition
		AccountInformation accounttype = new AccountInformation();
		accounttype.accountInformation(userid);
		String actype = accounttype.getAccount_type();
		
		if(actype.equals("Saving")) {
			depAmount*=0.08;
		}
		
		boolean condition =amtdept.depositAmount(depAmount, this.accountnumber);
		
		if(condition) {
			//transaction history saving
			new Transactions().transactionHistory(this.accountnumber, "Deposit", amount);
			
			System.out.println("\u001B[32mAmount Successfully Credited.....\u001B[0m");
			this.updateAmount = amtdept.getBalance();
			System.out.println();
			
			new Login().user(this.username, this.updateAmount, this.user_id, accountnumber);
			System.out.println("\n");
		}else {
			System.err.println("mAmount Not credited....");
			new Login().user(username, amount, userid, accountnumber);
			System.out.println();
		}
		
		
	}

}
