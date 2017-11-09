package Registro;

import javax.swing.JOptionPane;

public class Usuario {

	protected String nombre;
	protected String apellido;
	protected int edad;
	protected String nombreUsuario;
	protected String contraseña;
	
	
	
	public Usuario(String nombre, String apellido, int edad, String nombreUsuario, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
