package Clases;

public class Protagonista {
	private int PV = 3;
	private int PosX;
	private int PosY;
	private int personaje;
	private int danyo;

	public Protagonista(int PosX, int PosY, int personaje){
		this.PosX = PosX;
		this.PosY = PosY;
		this.personaje = personaje;
	}


	public int getPV() {
		return PV;
	}


	public void setPV(int pV) {
		PV = pV;
	}


	public int getPosX() {
		return PosX;
	}


	public void setPosX(int posX) {
		PosX = posX;
	}


	public int getPosY() {
		return PosY;
	}


	public void setPosY(int posY) {
		PosY = posY;
	}


	public int getPersonaje() {
		return personaje;
	}


	public void setPersonaje(int personaje) {
		this.personaje = personaje;
	}

	public int getDanyo() {
		return danyo;
	}


	public void setDanyo(int danyo) {
		this.danyo = danyo;
	}
}

