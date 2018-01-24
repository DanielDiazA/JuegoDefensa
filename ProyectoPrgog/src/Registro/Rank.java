
/**
 * Puntuación que se consigue en una partida.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */



package Registro;

public class Rank {

	
	public String nick;//nombre
	public int muertes;//numero de muertes
	public int puntuacion;//puntuacion final conseguida
	
	public Rank(String nick, int muertes, int puntuacion) {
		super();
		this.nick = nick;
		this.muertes = muertes;
		this.puntuacion = puntuacion;
	}

	
	//getters y setters
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getMuertes() {
		return muertes;
	}

	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
	

}
