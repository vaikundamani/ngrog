package inputviews;

import java.sql.SQLException;
import java.util.Scanner;

import datacontroller.UserLoginRes;

public class ApolloBank {
    private Scanner scanner;
    private String username;
    private String password;

    public ApolloBank() {
        scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
    	ApolloBank bank =new ApolloBank();
    	bank.run();
    }

    public void run() {
       
            System.out.println("       Welcome To Apollo Bank 🏦");
            System.out.println("\u001b[34m********************************************\u001b[0m");
            System.out.println("1.🔐 Login\t\t2.✎ Create Account");
            System.out.println("3.😕 Forgot User Name\t4.📓 FeedBack\n");
            System.out.print("Enter your choice : ");
            

            boolean choice = false;
            int option = 0;
           do {
        	   try {
        	        option = scanner.nextInt();
        	        scanner.nextLine();
        	        choice = true;
        	      } catch (Exception e) {
        	        System.err.println("Enter your choice ( Please Enter Valid Option ) : ");
        	        scanner.nextLine();
        	      }
           }while(!choice);

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                   new NewAccount().newAccount();
                    break;
                case 3:
                    new ForgotUsername().forgotusername();
                    break;
                case 4:
                    feedback();
                    break;
                default:
                    System.err.println("Wrong Value Entry Restricted.....");
            }      
    }
    

    public void login() {
        System.out.print("User Name : ");
        this.username = scanner.nextLine();

        System.out.print("Enter Password : ");
        this.password = scanner.nextLine();
        try {
			new UserLoginRes(this.username,this.password);
		} catch (SQLException e) {
			e.printStackTrace();
			scanner.nextLine();
		}finally {
			scanner.close();
		}
    }
    
    void feedback() {
    	
    	new CustomerCare().compliance();
    	
    }
    
}
