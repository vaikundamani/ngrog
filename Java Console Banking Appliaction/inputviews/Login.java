package inputviews;

import java.util.Scanner;
import datacontroller.*;

public class Login {
	
	private Scanner scanner;
	private int user_id;
	private String username;
	private double balance;
	private int accountnumber;
	
	
	public Login(){
		scanner = new Scanner(System.in);
	}
  
	public void user(String username, double balance, int userid,int accountnumber) {
		this.username = username;
		this.balance =balance;
		this.user_id = userid;
		this.accountnumber = accountnumber;
		
		System.out.println("*********************************************************");
    	System.out.println("\tHello \u001B[38;2;138;43;226m"+"*ੈ✩‧₊˚"+this.username+"*ੈ✩‧₊˚\u001B[0m Welcome To Apollo Bank 🙏");
    	System.out.println("*********************************************************");
    	System.out.println("\t\tAccount Balance : \u001B[32m₹ "+this.balance+"\u001B[0m");
    	System.out.println();
    	System.out.println("\t1.🧾 Account Deatails\t5.📤 Transactions History");
    	System.out.println("\t2.💳 Deposite\t\t6.🖊️ Change Password");
    	System.out.println("\t3.🎰 Withdraw\t\t7.👨‍💼 Customer Care");
    	System.out.println("\t4.📮 Transfer Money\t8.📴 Log out");
    	System.out.println();
    	
    	
    	boolean choice = false;
        int option = 0;
       do {
    	   try {
    		   System.out.print("Enter your choice : ");
    	        option = scanner.nextInt();
    	        choice = true;
    	      } catch (Exception e) {
    	        System.err.println("Enter your choice ( Please Enter Valid Option ) : ");
    	        scanner.nextLine();
    	      }
       }while(!choice);
       
       
       switch (option) {
       case 1:
           new AccountDetailRes().userInformation(this.user_id);
           break;
       case 2:
          new Deposit().amount(this.user_id, this.username,this.balance,this.accountnumber);
           break;
       case 3:
          new  Withdraw().withdrawAmount(this.username, this.user_id,this.balance,this.accountnumber);
           break;
       case 4:
           new MoneyTransfer().moneytransferInput(this.username, this.balance, this.user_id, this.accountnumber);
           break;
       case 5:
           new TransactionHistoryRes().trasanctionres(username, balance, userid, accountnumber);
           break;
       case 6:
           new PasswordChange().passwordres(username, balance, userid, accountnumber);
           break;
       case 7:
           new CustomerCare().compliance(username, balance, userid, accountnumber);
           break;
       case 8:
           System.out.println("\n\u001B[35m\t\tThank For Visiting ApolloBank ❤️. \u001B[0m");
           break;  
       default:
    	   System.err.println("Enter your choice ( Please Enter Valid Option ) : ");
           user(this.username,this.balance,this.user_id,this.accountnumber);
   }
       
	}
	
}



