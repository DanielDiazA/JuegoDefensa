/**
 * Hereda de la clase Nave e implementa la Interfaz Dibujable.Crea un triangulo en las coordenadas deseadas con el color que uno quiera.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

public class NaveGrafica extends Nave implements Dibujable{

	
	Color color;//Color que va a tener nuestra nave
	
	public NaveGrafica(Coordenada a,Coordenada b,Coordenada c,Color color) {
		
		super(a,b,c);
		this.color=color;
		
	}
	

	@Override
	public void dibujar(Graphics dw) {
		
		dw.setColor(color);
		
		int x[]={(int)this.getX(),(int)this.cor1.getX(),(int)this.cor2.getX()};
		int y[]={(int)this.getY(),(int)this.cor1.getY(),(int)this.cor2.getY()};
		//Crea poligono, en nuestro caso de 3 lados.
		Polygon p=new Polygon(x,y,3);
		
		dw.fillPolygon(p);
		
	}

	public void Pintar(Graphics dw, Color uncolor) {
	
		dw.setColor(uncolor);
		int x[]={(int)this.getX(),(int)this.cor1.getX(),(int)this.cor2.getX()};
		int y[]={(int)this.getY(),(int)this.cor1.getY(),(int)this.cor2.getY()};
		//Crea poligono, en nuestro caso de 3 lados.
		Polygon p=new Polygon(x,y,3);
		
		dw.fillPolygon(p);
		
	}
	public CirculoGrafico Bala()
	{
		
		//Punta de la nave de donde salen las balas
		Coordenada salida = new Coordenada(this.getX(),this.getY());
		
		//Color de nuestras balas
		CirculoGrafico bala =new CirculoGrafico(salida, 10, Color.red);
		return bala;
		
	}
	
	//Movimiento de la bala
	public void Ciclo(){
		for(int i =0; i<this.balas.size();i++){
			CirculoGrafico y= (CirculoGrafico) this.balas.get(i);
			float x=y.getY();
			//velocidad bala
			y.setY(x-=20);
		}
		
		
	}
	
	
}
