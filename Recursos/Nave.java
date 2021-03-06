/**
 * Clase padre de las clases NaveGrafica, hereda de la clase Coordenada. Se utiliza para que la clase NaveGrafica
 * herede los atributos coordenada 1 y coordenada 2 , asi como los metodos.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Modelos;

import java.util.ArrayList;

public class Nave extends Coordenada {

	// Coordenadas para la crecion de la nave.
	public Coordenada cor1 = new Coordenada();
	public Coordenada cor2 = new Coordenada();

	ArrayList balas = new ArrayList();// Arraylist donde se guardan las
										// balas(CirculosGraficos) que se
										// disparan.

	public Nave() {
		super();

		this.cor1.setX(0);
		this.cor1.setY(0);

		this.cor2.setX(0);
		this.cor2.setY(0);

	}

	public Nave(Coordenada a, Coordenada b, Coordenada c) {

		super(a.getX(), a.getY());
		this.cor1.setX(b.getX());
		this.cor1.setY(b.getY());
		this.cor2.setX(c.getX());
		this.cor2.setY(c.getY());
	}

	public Nave(Nave n) {

		super(n.getX(), n.getY());

		this.cor1.setX(n.getX());
		this.cor1.setY(n.getY());
		this.cor2.setX(n.getX());
		this.cor2.setY(n.getY());

	}

	public void setVertice(Coordenada nva, int lado) {

		if (lado == 1) {
			this.setX(nva.getX());
			this.setY(nva.getY());
		}
		if (lado == 2) {
			this.cor1.setX(nva.getX());
			this.cor1.setY(nva.getY());
		}
		if (lado == 3) {
			this.cor2.setX(nva.getX());
			this.cor2.setY(nva.getY());
		}

	}

	/**
	 * Metodo para mover la nave.
	 * @param NvaCor
	 */
	public void mover(Coordenada NvaCor) {

		setVertice((this.Suma(NvaCor)), 1);
		setVertice((this.cor1.Suma(NvaCor)), 2);
		setVertice((this.cor2.Suma(NvaCor)), 3);

	}

}
