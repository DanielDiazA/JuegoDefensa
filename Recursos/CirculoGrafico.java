/**
 * Hereda de la clase Circlo e implementa la Interfaz Dibujable.Crea un ovalo en las coordenadas deseadas con el colo que uno quiera.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */


package Modelos;

import java.awt.Color;
import java.awt.Graphics;

public class CirculoGrafico extends Circulo implements Dibujable {

	Color color1;//Color de la bala.
	
	
	public CirculoGrafico(Coordenada cor , float radio, Color uncolor)
	{
		super(cor,radio);
		this.color1=uncolor;
		
	}
	
	
	@Override
	public void dibujar(Graphics dw) {
		
		dw.setColor(color1);
		//Función para dibujar un ovalo.
		dw.fillOval((int )(this.getX()-this.getRadio()),(int ) (this.getY()-this.getRadio()),(int )(2*this.getRadio()),(int ) (2*this.getRadio()));
		
	}
/**
 * Pintar la bala del color deseado.
 * @param uncolor
 */
	public void pintar(Color uncolor) {
		
		color1=uncolor;
		
	}
	
	
}
