package ifpr.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySingleton {
	
	private static Connection connection = null;

	private MySingleton() {
		
	}
	
	public static Connection getConnection() {
		if(connection == null){
			newConnection();
		}
		return connection;
	}

	private static void newConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String local = ("jdbc:mysql://localhost:3306/db_aulacadastro");
			connection = DriverManager.getConnection(local, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
