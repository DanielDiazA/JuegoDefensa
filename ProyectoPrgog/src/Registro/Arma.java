package Registro;

import javax.swing.ImageIcon;

public class Arma {
	private int PosX;
	private int PosY;
	private ImageIcon img;
	
	
	public Arma(int PosX, int PosY){
		this.PosX = PosX;
		this.PosY = PosY;
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

}