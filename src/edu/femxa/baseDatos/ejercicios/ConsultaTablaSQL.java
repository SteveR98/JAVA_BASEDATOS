package edu.femxa.baseDatos.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ConsultaTablaSQL {

	
public static void ConsultaHistoricoSalario (Connection conn) throws Exception
	
	{
		ResultSet rset = null;
		Statement stmt = null;
		int salario_anterior=0;
		int salario_poserior=0;
		Date fechaSubida =null;
		int employee_id =0;
	
		try 
		{	conn.setAutoCommit(false);
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
		    stmt = conn.createStatement();
		    conn.setAutoCommit(false);
		    rset = stmt.executeQuery(Consultas.CONSULTA_HISTORICO);
			conn.commit();
		  
			while (rset.next())
			{	
		    	employee_id = rset.getInt("EMPLOYEE_ID");
		    	salario_anterior= rset.getInt("SALARIO_ANTERIOR");
		    	salario_poserior=rset.getInt("SALARIO_POSTERIOR");
		    	fechaSubida =rset.getDate("FECHA_SUBIDA");
		    	
		    	System.out.println(employee_id+" "+salario_anterior+" "+salario_poserior+"  "+"FECHA "+fechaSubida);

			}
		    
		} 
		catch (Exception e) 
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
		
	}
		
	
	
	
	
	
}
