package edu.femxa.baseDatos.ejercicios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;

import javax.sql.PooledConnection;

public class ActualizarSalario {

	
		public static void main(String[] args) throws Exception {
			
			Savepoint savepoint =null;
			Connection conn = null;
			ResultSet rset = null;
			int rset2 = 0;
			Statement stmt = null;
			int salario1 = 0;
			int empleado_id = 0;
			
		try
			{
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
	  	        stmt = conn.createStatement();
	  	        conn.setAutoCommit(false);//normalmente esta a true y se hace commit siempre al cerrar la conexion de la db, pero se puede poner a false

	  	        rset = stmt.executeQuery(Consultas.CONSULTA_SELECT_EMPLEADOS);
	  	       
	  	        //rest = stmt.executeQuery("select department_id from departments where department_name='administration');
	  	        //rest = stmt.execute //Devuelve boolean
	  	       
	  	        rset2 = stmt.executeUpdate(Consultas.CONSULTA_SUBIDA_PORCENT);
	  	     	ConsultaTablaSQL.ConsultaHistoricoSalario(conn);
	  	       
	  	     	savepoint=conn.setSavepoint();
	  	       
	  	        while (rset.next())
				{
	  	        	
	  	        	//salario1 = rset.getInt("SALARY");
	  	        	//salario1 = (int) (salario1+(salario1*0.20));
					empleado_id = rset.getInt(2);
					 salario1 = rset.getInt(3);
					
			  	     conn.commit();//para realizar el commit 
				}
	  	        System.out.println("El departamento Administración: "+empleado_id+" aumenta su salario a "+salario1);
			}
			catch(Exception e)
			{ 
				e.printStackTrace();
				System.out.println("OCURRIO UN ERROR");
				conn.rollback(savepoint);
			}
			finally 
			{
				if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
			  	   
			} 
		}
	}
