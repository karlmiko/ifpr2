package ifpr.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton 
{	
	public static Connection conn = null;
	
	private Singleton(){}
	
	public static Connection getConnection()
	{
		if (conn == null)
		{
			newConnection();
		}
		
		return conn;
	}
	
	public static void newConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_prova","root", "");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void closeConnection()
	{
		try
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}