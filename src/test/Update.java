package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {		
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
			
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			
			String sql = "update COCHE set MARCA=?, MODEL=?, KM=? WHERE ID=?";
			
			String marca = "Seat";
			String model = "Leon FR";
			int km = 30000;
			int id = 1;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, marca);
			sentencia.setString(2, model);
			sentencia.setInt(3, km);
			sentencia.setInt(4, id);
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir nuevo cliente");
			System.out.println(e.getMessage());
		}		
	}
}