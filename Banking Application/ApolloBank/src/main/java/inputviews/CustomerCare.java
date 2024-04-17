package inputviews;

import java.util.Scanner;

import datacontroller.CustomerServiceRes;

public class CustomerCare {

	protected Scanner scanner;
	private String username;
	private String text;
	
	public CustomerCare() {
        scanner = new Scanner(System.in);
    }
	
	public  void compliance(String username, double balance,int userid,int accountnumber){
		
		try {
		   System.out.println();
		   System.out.println("\tEnter Your Quetions or Compliance ✍");
		   System.out.println("****************************************************");
		   String text = scanner.nextLine();
		   this.username = username;
		   this.text = text;
		   System.out.println("\n\tSubmitted Successfully !");
		   new CustomerServiceRes().usercompliance(this.username, this.text);
		   new Login().user(username, balance, userid, accountnumber);
		}catch(Exception e) {
			System.out.println(e);
			scanner.nextLine();
		}finally {
			scanner.close();
		}
		}
	
	public  void compliance(){
		
		   System.out.println();
		   System.out.println("\tEnter Your Quetions or Compliance ✍");
		   System.out.println("****************************************************");
		   String text = scanner.nextLine();
		   this.text = text;
		   System.out.println();
		   System.out.println("\tThanks Your Feedback Submitted !");
		   scanner.close();
		   new CustomerServiceRes().usercompliance("Common", this.text);
		}

}
