package edu.femxa.baseDatos.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {
	
	public List<EmpleadoDTO> seleccionarTodosEmpleados() throws SQLException {
		 	
		 	List<EmpleadoDTO> lista_empleados = null;
		 	
		 	lista_empleados = new ArrayList<EmpleadoDTO>();
		 	
		 	Connection conn=null;
		 	ResultSet rset = null;
			Statement stmt = null;
			
			
			
			int id_nombre = 0;
		 	String nombre = null;
		 	int salario = 0;

		 		try 
		 	{
		 		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
		 		
		 			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
		 	        stmt = conn.createStatement();
		 	        conn.setAutoCommit(false);
		 	        
		 	        rset = stmt.executeQuery(Consulta.SELECT_EMPLEADOS);
		 	        
		 	        	while (rset.next()) 
		 	        {
		 	        	id_nombre = rset.getInt("EMPLOYEE_ID");
		 				nombre= rset.getString("FIRST_NAME"); 
		 				salario = rset.getInt("SALARY");
		 				
		 				lista_empleados.add(new EmpleadoDTO(id_nombre, nombre, salario));
		 			}
		 	        
		 		} catch (SQLException e) 
		 		{
		 			e.printStackTrace();
		 			throw e;
		 		}
		 		finally
		 		{
		 			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		 			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		 			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		 			
		 		}
		 		
	
	 		return lista_empleados;

	}		 		
		 
				
}