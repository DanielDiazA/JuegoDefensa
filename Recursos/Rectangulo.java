/**
 * Clase padre de RectanguloGrafico, hereda de la clase Coordenada.Se utiliza para que la clase RectanguloGrafico 
 * herede los atributos lado1 y lado2.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Modelos;

public class Rectangulo extends Coordenada {

	private float lado1;//Primer Lado
	private float lado2;//Segundo Lado
	
	public Rectangulo(){
		
		super();
		this.lado1=0;
		this.lado2=0;
	}
	
	public Rectangulo(Coordenada cor,float x,float y){
		
		super(cor);
		this.lado1=x;
		this.lado2=y;
		
	}

	public Rectangulo(Rectangulo rc){
		super(rc.getX(),rc.getY());
		this.lado1=rc.lado1;
		this.lado2=rc.lado2;
	}
	
	//Getters y Setters. 
	
	public float Getlado(int lado){
		
		if(lado==1){
			
			return this.lado1;
		}
		if(lado==2){
			
			return this.lado2;
		}
		if(lado !=1 && lado !=2){
			return 0;
		}
		
		return 0;
		
	}
	
	
}
