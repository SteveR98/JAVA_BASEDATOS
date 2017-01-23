package edu.femxa.baseDatos.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.femxa.baseDatos.Empleado;

public class Empleados {
	
	
	public static void mostrarArray  (ArrayList<EmpleadoSalario>lemp)
	{
		for (EmpleadoSalario emp : lemp) 
		{
			
			
			System.out.println("NOMBRE: "+emp.getNombre_id()+"---"+emp.getNombre()+ " --- "+emp.getSalario() +"€");
		System.out.println("DEPARTAMENTO: "+emp.getDepartamentoId()+"---" + emp.getDepartamentoNombre());
		
		}
	}
	
public static void main(String[] args) {
	
	Connection conn = null;
	ResultSet rset = null;
	Statement stmt = null;
	
	
	try {
	DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
	conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "password");
    stmt = conn.createStatement();
	rset = stmt.executeQuery(Consultas.CONSULTA_EMPLEADOS_SALARIO_ASC);
	
	ArrayList <EmpleadoSalario> listaEmpleados =null;
	listaEmpleados = new ArrayList<EmpleadoSalario>();

		int nombre_id =0;
		String nombre=null;
		int salario =0;
		int departamentoId =0;
		String departamentoNombre =null;
		EmpleadoSalario empleados =null;
		
		while (rset.next())
	{ 		 
			nombre_id =rset.getInt("EMPLOYEE_ID");
	 		 nombre=rset.getString ("FIRST_NAME");
	 		 salario =rset.getInt("SALARY");
	 		 departamentoId =rset.getInt("DEPARTMENT_ID");
	 		 departamentoNombre =rset.getString("DEPARTMENT_NAME");

	 		 empleados = new EmpleadoSalario(nombre_id, nombre, salario, departamentoId, departamentoNombre);

	 		listaEmpleados.add(empleados);
	 		
	}
	mostrarArray(listaEmpleados);
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
