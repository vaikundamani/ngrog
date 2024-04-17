package inputviews;

import java.util.Scanner;

import datacontroller.WithdrawRes;

public class Withdraw {
	Scanner scanner;
	private double depitamount;
	private int user_id;
	private double balance;
	private String username;
	private int accountnumber;
	
	Withdraw(){
		scanner = new Scanner(System.in);
	}

	public void withdrawAmount(String username,int userid,double balance,int accountnumber) {
		this.user_id = userid;
		this.balance= balance;
		this.username = username;
		this.accountnumber = accountnumber;
		System.out.print("Enter The Your Withdraw Amount : ₹  ");
		
		try {
            double amount = scanner.nextDouble();
            if (amount <= balance ) {
                this.depitamount =amount ;
                new WithdrawRes().withdrawamount(this.user_id,this.username,this.depitamount,accountnumber);
                
            }else if( amount <= this.balance && amount > 0){
            	System.out.println("Your Bank Balance is Low.....");
            	new Login().user(username, balance, userid, accountnumber);
            }
            else {
                System.err.println("Deposit Declined: Invalid amount.");
                new Login().user(username, balance, userid, this.accountnumber);
            }
        } catch (Exception e) {
            System.err.println("Invalid Input: Please enter a valid amount.");
            System.out.println("\2");
            new Login().user(username, balance, userid, accountnumber);
        } finally {
            scanner.close(); 
        }
		
	}

}
