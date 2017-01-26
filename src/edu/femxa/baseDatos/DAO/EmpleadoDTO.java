package edu.femxa.baseDatos.DAO;


public class EmpleadoDTO {
	
	private int nombre_id;
	private String nombre ;
	private int salario ;
	
	public EmpleadoDTO(int id_nombre, String nombre, int salario) {
		this.nombre_id = id_nombre;
		this.nombre = nombre;
		this.salario = salario;
	}
	
	public int getId_nombre() {
		return nombre_id;
	}
	public void setId_nombre(int id_nombre) {
		this.nombre_id = id_nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
	
}
