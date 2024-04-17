package datacontroller;

import java.sql.SQLException;

import databasemodel.CustomerReports;

public class CustomerServiceRes {
	public void usercompliance(String username,String reports) {
		
		try {
			new CustomerReports().reportCompliance(username, reports);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
