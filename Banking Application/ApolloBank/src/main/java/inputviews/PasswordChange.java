package inputviews;

import java.sql.SQLException;
import java.util.Scanner;

import datacontroller.PasswordChangeRes;

public class PasswordChange {
	private String oldpassword;
	private String newpassword;

	public void passwordres(String username, double balance, int userid,int accountnumber) {
		
		Scanner scanner = new Scanner(System.in);
		boolean validPassword = false;
		System.out.print("Enter Your Password : ");
		this.oldpassword = scanner.nextLine();
        do {
            System.out.print("Create New Password : ");
            String newPassword = scanner.nextLine();

            System.out.print("Confirm Password : ");
            String confirmPassword = scanner.nextLine();

            if (newPassword.equals(confirmPassword)) {
                this.newpassword = newPassword;
                validPassword = true;
            } else {
                System.err.println("Password Mismatch. Please Enter the Same Password Again.");
            }
        } while (!validPassword);
        try {
			new PasswordChangeRes().newpassword(username, balance, userid, accountnumber,this.oldpassword,this.newpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			scanner.close();
		}
	}

}
