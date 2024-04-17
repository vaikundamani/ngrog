package inputviews;

import java.util.HashMap;
import java.util.Scanner;

public class AccountDetails {
	
	public void accountinformation(HashMap<String,Object> detail) {
		System.out.println("*********************************************************");
		System.out.println("\t\tAccount Information 🔍 .");
		System.out.println("*********************************************************");
		System.out.println("\tUser-ID             : " + "\u001B[32m" + detail.get("userid") + "\u001B[0m"); 
		System.out.println("\tUser Name           : " + "\u001B[32m" + detail.get("username") + "\u001B[0m"); 
		System.out.println("\tAccount Number      : " + "\u001B[32m" + detail.get("accountnumber") + "\u001B[0m");
		System.out.println("\tAccount Type        : " + "\u001B[32m" + detail.get("accounttype") + "\u001B[0m"); 
		System.out.println("\tBranch              : " + "\u001B[32m" + detail.get("branch") + "\u001B[0m"); 
		System.out.println("\tIFSC Code           : " + "\u001B[32m" + detail.get("ifsc") + "\u001B[0m");
		System.out.println("\tEmail-Id            : " + "\u001B[32m" + detail.get("email") + "\u001B[0m"); 
		System.out.println("\tPhone Number        : " + "\u001B[32m" + detail.get("phonenumber") + "\u001B[0m"); 
		System.out.println("\tRegistered Date     : " + "\u001B[32m" + detail.get("registerdate") + "\u001B[0m");
		System.out.println("*********************************************************");
		System.out.println("Press Enter To Back  ");
		 Scanner scan = new Scanner(System.in);
		 scan.nextLine();
		 System.out.println();
		 
		 new Login().user(detail.get("username").toString(), 
				 Double.parseDouble(detail.get("balance").toString()), 
				 Integer.parseInt(detail.get("userid").toString()),
				 Integer.parseInt(detail.get("accountnumber").toString()));
		 scan.close();
		
	}
}
