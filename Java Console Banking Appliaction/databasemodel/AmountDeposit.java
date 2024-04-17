package databasemodel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AmountDeposit {
	
	private int accountnumber;
	private double updatebalance;
	
	
    public boolean depositAmount(double amount, int accountnumber) {
        this.accountnumber = accountnumber;

        String depositquery = "update accounts set balance = balance + ? where account_id = ?";
        String balancequery = "select balance from accounts where account_id = ?";

        try {
            PreparedStatement deposit = new ConnectionLogin().getConnection().prepareStatement(depositquery);
            deposit.setDouble(1, amount);
            deposit.setInt(2, this.accountnumber);
            int result = deposit.executeUpdate();
            deposit.close();

            PreparedStatement balance = new ConnectionLogin().getConnection().prepareStatement(balancequery);
            balance.setInt(1, this.accountnumber);
            ResultSet resultbalance = balance.executeQuery();
            if (resultbalance.next()) {
                this.updatebalance = resultbalance.getDouble("balance");
            }
            balance.close();

            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

	public double getBalance() {
		return updatebalance;
	}

}
