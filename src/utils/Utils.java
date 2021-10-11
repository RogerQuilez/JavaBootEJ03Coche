package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {
	

	public static Connection getConnection() throws SQLException{
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		Connection con = DriverManager.getConnection(cadenaConexion, user, pass);
		
		return con;
		
	}
	
	public static void printResult(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.print(rs.getInt("ID"));
			System.out.print(" - "); 
			System.out.print(rs.getString("MARCA"));
			System.out.print(" - "); 
			System.out.print(rs.getString("MODEL"));
			System.out.print(" - "); 
			System.out.print(rs.getInt("KM") + "km");
			System.out.println();
		}
	}
}
