package Registro;

import javax.swing.JOptionPane;

public class Usuario {

	protected String nombre;
	protected String apellido;
	protected int edad;
	protected String nombreUsuario;
	protected String contrase�a;
	
	
	
	public Usuario(String nombre, String apellido, int edad, String nombreUsuario, String contrase�a) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
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



	public String getContrase�a() {
		return contrase�a;
	}



	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
