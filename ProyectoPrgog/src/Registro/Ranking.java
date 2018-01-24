package Registro;
/**
 * Ranking , esta clase o se utiliza en esta version.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

public class Ranking {
	private String nick;
	private int puntuacion;

	public Ranking(Usuario u){
		this.nick = u.getNick();
		this.puntuacion = 0;

	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
}