package Registro;

import javax.swing.ImageIcon;

public class Zombie extends Enemigo{
	private String img = "C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Zombie.png";
	
	public Zombie(int PosX, int PosY){
		setPV(2);
		setVelocidad(5);
		setDanyo(1);
		setImg(new ImageIcon(img));
		this.posX = PosX;
		this.posY = PosY;
	}
}
