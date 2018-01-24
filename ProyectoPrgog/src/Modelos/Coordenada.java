/**
 * Clase padre de las clases Circulo,Nave,Rectangulo.Para que estas clases hereden 
 * los atributos Coordenada X y Coordenada Y.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Modelos;

public class Coordenada {

	private float x;// Coordenanda X
	private float y;// Coordenada Y

	public Coordenada() {
		this.x = 0;
		this.y = 0;

	}

	public Coordenada(float x, float y) {
		this.x = x;
		this.y = y;

	}

	public Coordenada(Coordenada nva) {
		this.x = nva.x;
		this.y = nva.y;

	}

	// Getters y Setters.

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Metodo para sumar coordenadas
	 * 
	 * @param Coordenada
	 *            S
	 * @return Cordenada nueva
	 */
	public Coordenada Suma(Coordenada S) {
		float Sumx = this.x + S.getX();
		float Sumy = this.y + S.getY();
		Coordenada Cor = new Coordenada(Sumx, Sumy);
		return Cor;

	}

}
