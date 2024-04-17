package datacontroller;

import java.sql.Connection;
import java.sql.SQLException;


import databasemodel.ChangePassword;
import inputviews.Login;

public class PasswordChangeRes extends ChangePassword{
	Connection connection;
	private String oldpassword;
	private String username;
	private String newpassword;
	
	public PasswordChangeRes() throws SQLException {
		super();
		connection = getConnection(); 
	}

	public void newpassword(String username, double balance, int userid,int accountnumber, String oldpassword,String newpassword) {
		
		this.username = username;
		this.oldpassword = oldpassword;
		this.newpassword = newpassword;
		
		try {
			if(checkPassword(username,oldpassword)) {
				
				updatepassword(this.username,this.oldpassword,this.newpassword);
				System.out.println("\u001B[32mPassword  Successfully Changed......\u001B[0m");
				new Login().user(username, balance, userid, accountnumber);
				return;
				
			}else {
				System.err.println("Wrong Password Entry......");
				new Login().user(username, balance, userid, accountnumber);
			}
		} catch (Exception e) {
			new Login().user(username, balance, userid, accountnumber);
			e.printStackTrace();
		}
		
	}
}
