package Registro;

import javax.swing.JOptionPane;

public class Usuario {

	protected String nombre;
	protected String apellido;
	protected int edad;
	protected String contraseña;
	public int dinero;
	protected String nick;
	

	public Usuario(String nombre, String apellido, int edad, String contraseña, int dinero, String nick) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;

		this.contraseña = contraseña;
		this.dinero = dinero;
		this.nick = nick;
	}
	
	public Usuario() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.edad = 0;

		this.contraseña = "";
		this.dinero = 0;
		this.nick = "";
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

}
