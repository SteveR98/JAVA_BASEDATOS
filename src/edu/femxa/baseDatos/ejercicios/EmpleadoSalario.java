package edu.femxa.baseDatos.ejercicios;

public class EmpleadoSalario {

	private int nombre_id ;
	private String nombre ;
	private int salario ;
	private int departamentoId;
	private String departamentoNombre;
	
	public EmpleadoSalario(int nombre_id, String nombre,int salario,int departamentoId, String departamentoNombre) {
		
		this.nombre_id=nombre_id;
		this.nombre = nombre;
		this.salario = salario;
		this.departamentoId = departamentoId;
		this.departamentoNombre = departamentoNombre;
		
	
	}
	public int getNombre_id() {
		return nombre_id;
	}
	
	public void setNombre_id(int nombre_id) {
		this.nombre_id = nombre_id;
	}
	
	public int getDepartamentoId() {
		return departamentoId;
	}
	
	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
	}
	public String getDepartamentoNombre() {
		return departamentoNombre;
	}
	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
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
