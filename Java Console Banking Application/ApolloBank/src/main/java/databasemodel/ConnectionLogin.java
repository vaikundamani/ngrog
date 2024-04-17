package databasemodel;

import java.sql.*;

public class ConnectionLogin {
  
	public Connection connection;
    private String database_url;
    private String database_user;
    private String database_password;
    private int user_id;
    private String username;
    private String password;
    private double balance;
    private int accountnumber;
    
    public ConnectionLogin() throws SQLException {
        this.database_url = "jdbc:mysql://localhost:3306/apollobank";
        this.database_user = "root";
        this.database_password = "Mani498@1";
        connection = DriverManager.getConnection(database_url, database_user, database_password);
    }
    
    public boolean authentication(String username, String password) {
        String userquery = "SELECT password, user_id FROM users WHERE username = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(userquery)) {
            statement.setString(1, username);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    String storedPassword = result.getString("password");
                    int storedId = result.getInt("user_id");
                    
                    if (password.equals(storedPassword)) {
                        this.username = username;
                        this.password = storedPassword;
                        this.user_id = storedId;
                        
                        String accountQuery = "SELECT account_id FROM accounts WHERE user_id = ?";
                        
                        try (PreparedStatement accountStatement = connection.prepareStatement(accountQuery)) {
                            accountStatement.setInt(1, this.user_id);
                            
                            try (ResultSet accountResult = accountStatement.executeQuery()) {
                                if (accountResult.next()) {
                                    this.accountnumber = accountResult.getInt("account_id");
                                    this.balance = balance();
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
double balance() throws SQLException {
    	String query = "select balance from accounts where account_id = ?";
    	PreparedStatement smt = connection.prepareStatement(query);
    	smt.setInt( 1, this.accountnumber);
    	ResultSet result = smt.executeQuery();
    	result.next();
    	return result.getDouble("balance");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public int getUserId() {
        return user_id;
    }

    public Connection getConnection() {
		return connection;
	}
    
    public int getAccountnumber() {
 		return accountnumber;
 	}


	public static void main(String[] args) {
        // You can write test cases or usage examples here
    }
}
