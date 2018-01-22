/**
 * Clase padre de CirculoGrafico, hereda de la clase Coordenada.Se utiliza para que la clase CirculoGrafico 
 * herede el atributo radio.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */


package Modelos;

public class Circulo extends Coordenada {

	private float radio;//Radio del circulo.

	public Circulo() {

		super();
		this.radio = 0;
	}

	public Circulo(Coordenada cor, float r) {
		super(cor);
		this.radio = r;

	}

	public Circulo(Circulo cir) {
		super(cir);
		this.radio = cir.radio;

	}
	
	public float getRadio(){
		return this.radio;
	}
	public void setRadio(float r){
		 this.radio=r;
	}
	/**
	 * Metodo para obtener la coordenada central del circulo.
	 * @return Coordenada central
	 */
	public Coordenada getCentro(){
	Coordenada nva = new Coordenada(this.getX(),this.getY());
	return nva;
	}
	
}
