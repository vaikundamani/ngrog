package inputviews;

import java.sql.SQLException;
import java.util.Scanner;

import datacontroller.*;

public class NewAccount {
	
	private Scanner scanner;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String accountType;

    public NewAccount() {
        scanner = new Scanner(System.in);
    }

	 public void newAccount() {
	    	
	    	boolean validUsername = false;
	    	//User Name validation
	        do {
	            System.out.print("\nCreate New User Name  : ");
	            this.username = scanner.nextLine(); 
	            if (username.length() >= 3) {
	                validUsername = true;
	            } else {
	            	System.out.println();
	                System.err.println("Invalid username! Username must be at least 3 characters long.");
	            }
	        } while (!validUsername);

	        //Password Validation
	        boolean validPassword = false;
	        do {
	            System.out.print("Create New Password : ");
	            String newPassword = scanner.nextLine();

	            System.out.print("Confirm Password : ");
	            String confirmPassword = scanner.nextLine();

	            if (newPassword.equals(confirmPassword)) {
	                this.password = newPassword;
	                validPassword = true;
	            } else {
	                System.err.println("Password Mismatch. Please Enter the Same Password Again.");
	            }
	        } while (!validPassword);

	        //Email id Validation
	        do {
	            System.out.print("Email-Id : ");
	            this.email = scanner.nextLine();
	            System.out.print((isValidEmail(email)?"":"\u001B[31mPlease Enter Valid \u001B[0m"));
	        } while (!isValidEmail(email));

	        //Phone Number Validation
	        do {
	            System.out.print("Phone Number : ");
	            this.phoneNumber = scanner.nextLine();
	            System.out.print((isValidPhoneNumber(phoneNumber)?"":"\u001B[31mPlease Enter Valid \u001B[0m"));
	        } while (!isValidPhoneNumber(phoneNumber));
	        
	        //AccountType Validation
	      boolean accountchoice = false;
	        do {
	     	   try {
	     		   System.out.print("Choose Account Type ( 1.Normal Account 2.Saving Account ) : ");
	     	        int choice = scanner.nextInt();
	     	        scanner.nextLine();
	     	       accountchoice = true;
	     	       this.accountType = (choice==1)?"Normal":(choice==2)?"Saving":"";
	     	       
	     	      } catch (Exception e) {
	     	        System.err.println("Enter your choice  Please Enter Valid Option ) : ");
	     	        scanner.nextLine();
	     	      }
	     	   
	        }while(!accountchoice);
	        
	        //call userlogin
	        try {
				new NewAccountRes().newusers(this.username,this.password, this.email, this.phoneNumber, this.accountType);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	    }
	 
	 //email vaildatimg method
	 private boolean isValidEmail(String email) {
	        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	    }

	 //phone number validating method
	    private boolean isValidPhoneNumber(String phoneNumber) {
	        return phoneNumber.matches("\\d{10,12}");
	    }

}
