package datacontroller;

import java.sql.SQLException;

import databasemodel.*;
import inputviews.Login;

public class UserLoginRes {
	
	private int user_id;
	private String username;
	private String password;
    private double balance;
    private int accountnumber;
    
	public UserLoginRes(String username,String password) throws SQLException{
		System.out.println("\u001B[34mPlease Wait...🛰\u001B[0m");
		ConnectionLogin data = new ConnectionLogin();
		
		this.password = password;
		
		//entry authontication from database
		if(data.authentication(username, this.password)) {
			
			System.out.println("\u001B[32mLogin Successfully...! \u001B[0m");
			System.out.println();
			
			//recive from database
			this.username = data.getUsername();
			this.balance = data.getBalance();
			this.user_id = data.getUserId();
			this.accountnumber = data.getAccountnumber();
			
			//respose
			new Login().user(this.username, this.balance,this.user_id,this.accountnumber);
		}else {
			System.err.println("User_Name or Password is Incorrect Please Try Again.");
		}
	}
	

	public static void main(String[] args) {
		

	}

}
