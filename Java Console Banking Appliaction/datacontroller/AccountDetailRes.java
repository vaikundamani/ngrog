package datacontroller;

import java.sql.SQLException;
import java.util.HashMap;
import databasemodel.*;
import inputviews.AccountDetails;

public class AccountDetailRes {
	private int user_id;
	
	public void userInformation(int userid) {
		
		 AccountInformation acc = new AccountInformation();
		this.user_id = userid;
		try {
			acc.accountInformation(this.user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HashMap<String,Object> details = new HashMap<>();
		details.put("userid",acc.getUser_id());
		details.put("username",acc.getUsername());
		details.put("accountnumber",acc.getAccountNumber());
		details.put("accounttype",acc.getAccount_type());
		details.put("branch",acc.getBranch());
		details.put("ifsc",acc.getIfsc());
		details.put("email",acc.getEmail());
		details.put("phonenumber",acc.getPhone_number());
		details.put("registerdate",acc.getRegister_date());
		details.put("balance",acc.getBalance());
		new AccountDetails().accountinformation(details);
	}

	public static void main(String[] args) {
		AccountDetailRes  a = new AccountDetailRes();
		a.userInformation(101);
		
	}

}
