import java.sql.*;
import javax.swing.*;

public class hotelData {
	
	public static Connection ConnectDB()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection
					("jdbc:sqlite:C:\\Users\\S A\\Desktop\\java\\Hotel Management System in Java\\hoteldb.db");
			//JOptionPane.showMessageDialog(null,"Connection Made");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
