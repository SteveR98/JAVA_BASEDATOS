package edu.femxa.baseDatos.ficherosDePropie;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Propiedades {

	public static void main(String[] args) throws IOException 
	{
		Properties fichero_propiedades =null;
		fichero_propiedades=new Properties();
		
		FileReader fr =null;
		fr= new FileReader("db.properties");

		fichero_propiedades.load(fr);
		String vDriver= fichero_propiedades.getProperty("driver");
		String cadena_conexion= fichero_propiedades.getProperty("cadena_conexion");
		String user= fichero_propiedades.getProperty("user");
		String password= fichero_propiedades.getProperty("password");
		
		
		System.out.println(vDriver+" "+cadena_conexion+" "+user+" "+password);
		
		fr.close();
		
	}
	
	
}
