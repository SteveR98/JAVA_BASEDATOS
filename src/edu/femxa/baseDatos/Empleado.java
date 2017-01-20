package edu.femxa.baseDatos;

public class Empleado {
/**
 * Son los atributos de la clase 
 */
	
	private int id_nombre;
	private String nombre ;
	private int salario ;
	private int departamento_id ;
	
	public Empleado(int id_nombre, String nombre, int salario, int departamento_id)
	{	
		this.id_nombre = id_nombre;
		this.nombre = nombre;
		this.salario = salario;
		this.departamento_id = departamento_id;
	}
	
	
	public int getId_nombre() {
		return id_nombre;
	}
	public void setId_nombre(int id_nombre) {
		this.id_nombre = id_nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		nombre = nombre;
	}
	
public int getSalario() {
	return salario;
}
public void setSalario(int salario) {
	salario = salario;
}
public int getDepartamento_id() {
	return departamento_id;
}
public void setDepartamento_id(int departamento_id) {
	this.departamento_id = departamento_id;
}

	
	
	
}
