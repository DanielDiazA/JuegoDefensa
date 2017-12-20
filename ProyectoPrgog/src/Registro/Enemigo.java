package Clases;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class Enemigo {
	protected int PV;
	protected int velocidad;
	protected int danyo;
	protected String img;
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
	public void setImg(String img) {
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
	
	public void moverAbajo(int posY){
		posY += 1;
		setPosY(posY);
		//repaint();
		moverAbajo(posY);
	}
	public void paint(Graphics g) {
		paint(g);
		Toolkit t = Toolkit.getDefaultToolkit ();
		Image imagen = t.getImage(img);
		g.drawImage(imagen, PV, PV, null);
		
		
	}
	
}
