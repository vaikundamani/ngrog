package datacontroller;

import java.sql.SQLException;

import databasemodel.ConnectionLogin;
import databasemodel.NewAccountCreation;
import inputviews.Login;

public class NewAccountRes extends  NewAccountCreation{
	private String username;
	private double balance;
	private int user_id;
	private int accountnumber;
	

	public NewAccountRes() throws SQLException {
		super();
	}

 public boolean newusers(String username,String password, String email,String phone , String accounttype)  {
	 System.out.println("\u001B[34mPlease Wait...🛰 \u001B[0m");
		boolean entry = checkuserName(username);
		try {
		if(!entry) {
			super.newuser(username,password,email,phone,accounttype);
				new UserLoginRes(username, password);
				
				ConnectionLogin data = new ConnectionLogin();
				if(data.authentication(username, password)) {
					
					System.out.println("\u001B[32mLogin Successfully...! \u001B[0m");
					System.out.println();
					
					this.username = data.getUsername();
					this.balance = data.getBalance();
					this.user_id = data.getUserId();
					this.accountnumber = data.getAccountnumber();
					
					new Login().user(this.username, this.balance,this.user_id,this.accountnumber);
					return true;
				}else {
					System.err.println("User_Name or Password is Incorrect Please Try Again.");
				}
		}else {
			System.err.println("Username altready exists....");
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
