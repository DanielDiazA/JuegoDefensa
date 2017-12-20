package Clases;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Esqueleto extends Enemigo{
	Toolkit t = Toolkit.getDefaultToolkit();
	private Image img = t.getImage("C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Esqueleto.png") ;
	
	public Esqueleto(int PosX, int PosY){
		setPV(1);
		setVelocidad(10);
		setDanyo(1);
		this.posX = PosX;
		this.posY = PosY;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(img, this.getPosX(), this.getPosY(), null);
	}
}
