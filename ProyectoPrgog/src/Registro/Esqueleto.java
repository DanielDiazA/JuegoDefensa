package Registro;

import javax.swing.ImageIcon;

public class Esqueleto extends Enemigo{
	private String img = "C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Esqueleto.png" ;
	
	public Esqueleto(int PosX, int PosY){
		setPV(1);
		setVelocidad(10);
		setDanyo(1);
		setImg(new ImageIcon(img));
		this.posX = PosX;
		this.posY = PosY;
	}
}
