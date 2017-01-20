package edu.femxa.baseDatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.net.aso.r;


public class BaseDatos {

	public static void mostrarArray  (ArrayList<Empleado>lemp)
	{
		for (Empleado emp : lemp){
			System.out.println("NOMBRE: "+emp.getNombre());
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		
		ArrayList <Empleado> listaEmpleados =null;
		
		
		listaEmpleados = new ArrayList<Empleado>(); //EN LOS PARENTESIS SI PONES NUM CREEA LISTA CON X ESPACIOS
		
		
	try
		{
			//registro el driver, en realidad, hago que se ejecuten unas pocas líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());// método equivalente al anterior
			//Sea como sea, es, <<oye, si te piden una conexión, se la pides a esa clase!>>
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
  	        stmt = conn.createStatement();
			rset = stmt.executeQuery("SELECT E.FIRST_NAME, E.EMPLOYEE_ID, E.SALARY, E.DEPARTMENT_ID, D.DEPARTMENT_NAME from EMPLOYEES E, DEPARTMENTS D where E.DEPARTMENT_ID = D.DEPARTMENT_ID ORDER BY E.SALARY DESC");
			while (rset.next())
			{
			      //  System.out.println (rset.getString(1));  
			 		//System.out.print (rset.getString(2));  
		 		
					int id_nombre =rset.getInt("NOMBRE_ID");
					String nombre =rset.getString ("FIRST_NAME");
			 		int salario =rset.getInt ("SALARY");
			 		int departamento_id = rset.getInt("DEPARTMENT_ID");
			 		
			 		Empleado emp =new Empleado(id_nombre, nombre, salario, departamento_id);
			 		
			 		listaEmpleados.add(emp);
					mostrarArray(listaEmpleados);

			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	   
		}   

	}

}
	
	
	
	
	

