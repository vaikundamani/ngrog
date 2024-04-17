package inputviews;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import datacontroller.MoneyTransferRes;

public class MoneyTransfer extends Withdraw{
	
	private String holdername;
	private int holderaccountnumber;
	private double transferAmount;
	private int accountnum1;
	private int accountnum2;

	void moneytransferInput(String username,double balance,int userid,int accountnumber) {
		
		boolean x =false;
		do{
		System.out.print("Enter Account Holder Name : ");
		String holdername = scanner.nextLine();
		this.holdername = holdername;
		Pattern pattern = Pattern.compile("^[a-zA-Z.]+$");
        Matcher matcher = pattern.matcher(holdername);
        
        if (matcher.matches()) {
            x = true;
        } else {
        	x = false;
        }
		}while(!x);
		
		double tamount = 0;
		try {
		System.out.print("Holder Account Number : ");
		 this.accountnum1 = scanner.nextInt();
		System.out.print("Confirm Account Number : ");
		this.accountnum2 = scanner.nextInt();
		System.out.print("Enter Transfer Amount : ");
		tamount = scanner.nextDouble();
		this.transferAmount = tamount;
		}catch(Exception e) {
			System.err.println("Wrong input Entry......");
			new Login().user(username, balance, userid, accountnumber);
		}
		
		if(balance < tamount) {
			System.err.println("Your Balance Is Low !");
			System.out.println();
			new Login().user(username, balance, userid, accountnumber);
		}
		
		if(this.accountnum1 == this.accountnum2) {
			this.holderaccountnumber = this.accountnum2;
			try {
				new MoneyTransferRes().transferMoney(username,balance,userid,accountnumber,this.holdername,this.holderaccountnumber,this.transferAmount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("Account Number Not Match..");
			new Login().user(username, balance, userid, accountnumber);
		}
		
	}

}
