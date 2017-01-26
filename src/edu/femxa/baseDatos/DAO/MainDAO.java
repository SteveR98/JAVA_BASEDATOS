package edu.femxa.baseDatos.DAO;

import java.sql.SQLException;
import java.util.List;

public class MainDAO
{
public static void main(String[] args) throws SQLException {
	
	EmpleadoDAO empDao =null;
	
	 empDao= new EmpleadoDAO();
	
	List<EmpleadoDTO>le =empDao.seleccionarTodosEmpleados();
	
	for (EmpleadoDTO emDto :le)
	{
		System.out.println(emDto.getId_nombre()+"  "+ emDto.getNombre()+" "+ emDto.getSalario()+"€");
	}
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
}
