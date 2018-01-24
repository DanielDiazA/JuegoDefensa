/**
 * Hereda de la clase Rectangulo e implementa la Interfaz Dibujable.Crea un Rectangulo(Enemigos) en las coordenadas deseadas con el color que uno quiera.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RectanguloGrafico extends Rectangulo implements Dibujable {

	Color color;// Color del Enemigo

	/**
	 * Funcion randm para posición inicialdel enemigo.
	 * @param Max
	 *            posicion en el eje X
	 * @param Min
	 *            posicion en el eje X
	 * @return Coordenada en el eje X
	 */
	public static int Aleatorio(int Max, int Min) {
		return (int) (Math.random() * (Max - Min));
	}

	public RectanguloGrafico(Coordenada cor, float x, float y, Color uncolor) {
		super(cor, x, y);
		this.color = uncolor;
	}

	@Override
	public void dibujar(Graphics dw) {

		dw.setColor(color);
		// Funcion para dibujar un rectangulo
		dw.fillRect((int) this.getX(), (int) this.getY(), (int) this.Getlado(1), (int) this.Getlado(2));
	}

	//Función para pintar del color deseado
	public void pintar(Color uncolor) {

		this.color = uncolor;

	}

	// Movimiento enemigo
	public void Ciclo(int mov) {

		float x = this.getY();

		// velocidad del enemigo
		this.setY(x += mov);

	}

}
