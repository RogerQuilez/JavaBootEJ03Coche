package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Utils;

public class Delete {

	public static void main(String[] args) {
		
		try (Connection con = Utils.getConnection()){
			
			String sql = "DELETE FROM COCHE WHERE ID=?"; 
			
			int id = 2;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			sentencia.setInt(1, id);
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al borrar el cliente");
			System.out.println(e.getMessage());
		}
	}
}