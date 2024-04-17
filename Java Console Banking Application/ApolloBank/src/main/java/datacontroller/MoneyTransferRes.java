package datacontroller;

import java.sql.SQLException;

import databasemodel.AmountWithdraw;
import databasemodel.MoneyTransfer;
import databasemodel.Transactions;
import inputviews.Login;

public class MoneyTransferRes extends Transactions {

    private double updateAmount;

    public MoneyTransferRes() throws SQLException {
        super();
    }

    public void transferMoney(String username, double balance, int userid, int accountnumber, String holdername, int holderaccountnumber, double transferamount) {
        if (checkAccount(holderaccountnumber)) {
            try {
                // Money transfer to holder
                new MoneyTransfer().moneyTransfer(transferamount, holderaccountnumber);

                // Transaction history for transfer
                transactionHistory(accountnumber, "Transfer", transferamount, holdername, holderaccountnumber);

                AmountWithdraw obj = new AmountWithdraw();
                boolean entry = obj.depitedAmount(transferamount, userid);
                this.updateAmount = obj.getUpdateamount();
                
                //check accountblance

                if (entry == true) {
                    // Transaction history saving
                    new AmountWithdraw().depitedAmount(transferamount, userid);
                    
                    //this is history save to holder database receive
                    Transactions holderdata =  new Transactions();
                    holderdata.receiverHistory(holderaccountnumber);
                    holderdata.getHolderUser_id();
                    transactionHistory(holderaccountnumber, "Receive", transferamount, username,accountnumber );
                    
                    System.out.println("\u001B[32mAmount Transfered Successfully...\u001B[0m");
                    System.out.println();
                    new Login().user(username, updateAmount, userid, accountnumber);
                } else {
                    System.err.println("Wrong Account Number....");
                    new Login().user(username, balance, userid, accountnumber);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
        	System.err.println("Account Number Not Found...");
        	new Login().user(username, balance, userid, accountnumber);
        }
    }
}
