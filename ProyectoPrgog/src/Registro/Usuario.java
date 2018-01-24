/**
 * Clase Usuario.Necesaria parala creación y adminstración de los usuarios 
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */


package Registro;

public class Usuario {

	protected String nombre;//nombre
	protected String apellido;//apellido
	protected int edad;//edad
	protected String contraseña;//contraseña
	public int monedas;//cantidad de monedas que tiene
	protected String nick;//nick
	private int eleccion;//personaje que tiene elegido
	
/**
 * 
 * @param nombre
 * @param apellido
 * @param edad
 * @param contraseña
 * @param dinero
 * @param nick
 * @param eleccion
 */
	public Usuario(String nombre, String apellido, int edad, String contraseña, int dinero, String nick, int eleccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.eleccion = eleccion;
		this.contraseña = contraseña;
		this.monedas = dinero;
		this.nick = nick;
	}
	
	public Usuario() {
		super();
		this.nombre = null;
		this.apellido = null;
		this.edad = 0;
		this.eleccion = 1;
		this.contraseña = null;
		this.monedas = 0;
		this.nick = null;
	}
	
	//getters y setters

	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
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
		return monedas;
	}

	public void setDinero(int dinero) {
		this.monedas = dinero;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public int getEleccion(){
		return eleccion;
	}

}