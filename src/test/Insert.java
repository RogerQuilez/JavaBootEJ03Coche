package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Utils;

//IMPORTANTE
//EN TODAS LAS CONEXIONES A BBDD DEBEMOS DE USAR LA CLASE PREPARED STATEMENT EN LUGAR
//DE LA CLASE STATEMENT
public class Insert {

	public static void main(String[] args) {
		
		try (Connection con = Utils.getConnection()){
			
			String sql = "INSERT INTO COCHE (MARCA, MODEL, KM) VALUES (?, ?, ?)"; 
			
			String marca = "Renault";
			String model = "Clio";
			int km = 20000;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			
			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, marca);
			sentencia.setString(2, model);
			sentencia.setInt(3, km);
			
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al a�adir una nueva persona");
			System.out.println(e.getMessage());
		}
	}

}