package utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

	
	public static void printResult(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.print(rs.getInt("ID"));
			System.out.print(" - "); 
			System.out.print(rs.getString("MARCA"));
			System.out.print(" - "); 
			System.out.print(rs.getString("MODEL"));
			System.out.print(" - "); 
			System.out.print(rs.getInt("KM"));
			System.out.println();
		}
	}
}
