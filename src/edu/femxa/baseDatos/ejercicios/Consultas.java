package edu.femxa.baseDatos.ejercicios;

public class Consultas {

	
	
	public static final String CONSULTA_EMPLEADOS_SALARIO_ASC ="SELECT E.FIRST_NAME, E.EMPLOYEE_ID, E.SALARY, E.DEPARTMENT_ID, D.DEPARTMENT_NAME from EMPLOYEES E, DEPARTMENTS D where E.DEPARTMENT_ID = D.DEPARTMENT_ID ORDER BY E.SALARY DESC";

	
}
