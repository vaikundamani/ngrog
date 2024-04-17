package inputviews;

import datacontroller.DepositRes;
import java.util.Scanner;

public class Deposit {
    private Scanner scanner;
    private int userId;
    private String username;
    private int accountNumber;
    private double balance;

    public Deposit() {
        scanner = new Scanner(System.in);
    }

    public void amount(int userId, String username, double balance, int accountNumber) {
        this.userId = userId;
        this.username = username;
        this.balance = balance;
        this.accountNumber = accountNumber;

        System.out.println();
        System.out.print("Enter Deposit Amount: ₹ ");

        try {
            double amount = scanner.nextDouble();
            if (amount > 0 && amount <= 9999999999.99) {
                this.balance = amount;
                new DepositRes().depositToAccount(this.username, this.balance, this.userId, this.accountNumber,amount);
            } else {
                System.out.println("");
                System.err.println("Deposit Declined: Invalid amount.");
                new Login().user(username, balance, userId, accountNumber);
            }
        } catch (Exception e) {
            System.err.println("Invalid Input: Please enter a valid amount.");
            System.out.println("\2");
            new Login().user(username, balance, userId, accountNumber);
        } finally {
            scanner.close(); 
        }
    }
}
