package Registro;

import javax.swing.ImageIcon;

public class Enemigo {
	protected int PV;
	protected int velocidad;
	protected int danyo;
	protected ImageIcon img;
	protected int posX;
	protected int posY;
	
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public void setImg(ImageIcon img) {
		this.img = img;
	}
	public int getPV() {
		return PV;
	}
	public void setPV(int pV) {
		PV = pV;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getDanyo() {
		return danyo;
	}
	public void setDanyo(int danyo) {
		this.danyo = danyo;
	}
	
}
