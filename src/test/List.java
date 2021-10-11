package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.Utils;

public class List {

	public static void main(String[] args) {
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM COCHE");
			ResultSet rs = sentencia.executeQuery();
			
			Utils.printResult(rs);
			
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}		
	}
}