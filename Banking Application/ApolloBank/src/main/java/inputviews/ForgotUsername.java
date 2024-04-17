package inputviews;

import java.sql.SQLException;
import java.util.Scanner;

import databasemodel.ForgotUserName;

public class ForgotUsername {
	private String phoneNumber;
	
	void forgotusername() {
		Scanner scanner = new Scanner(System.in);
		 do {
	            System.out.print("Phone Number : ");
	            this.phoneNumber = scanner.nextLine();
	            System.out.print((isValidPhoneNumber(phoneNumber)?"":"\u001B[31mPlease Enter Valid \u001B[0m"));
	        } while (!isValidPhoneNumber(phoneNumber));
		 scanner.close();
		 
		 try {
			System.out.print("Your User Name is : "+new ForgotUserName().getUsername(phoneNumber));
			System.out.println("Go Try to Login....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10,13}");
    }

}
