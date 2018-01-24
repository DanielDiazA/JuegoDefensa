/**
 * Ventana en la que se inicia el jueg asi como los valores iniciales.Coordenadas de aparicion y colores.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Registro;

import java.util.ArrayList;

import java.awt.*;
import Modelos.*;
import javax.swing.JLabel;

public class Juego {
	static Usuario user;//Usuario
	static Inventario invent;//inventario
	static int vidas=3;//vidas
	static int puntos;//puntos
	
	/**
	 * Conseguir numero aleatoio semialeatorio
	 * @param Max
	 * @param Min
	 * @return
	 */
	public static int Aleatorio(int Max, int Min) {
		return (int) (Math.random() * (Max - Min));

	}
	
	public Juego(Usuario u, Inventario i) {
		this.user = u;
		this.invent = i;
		Initialize();
	}
	public static void Initialize() {
	
	
		Ventana nuestraventana = new Ventana("Wall Defense");//Ventana inicial
		nuestraventana.setVisible(true);

		
		nuestraventana.setLocation(400, 200);
		ArrayList ArregloDeObjetos = new ArrayList();
		nuestraventana.setVisible(true);
		PanelFG nuestroPanel = new PanelFG(ArregloDeObjetos, user, invent);
		Coordenada cor1 = new Coordenada(250, 250);
		Coordenada cor2 = new Coordenada(350, 350);

		// Coordenadas nave

		Coordenada cor3 = new Coordenada(475, 500);
		Coordenada cor4 = new Coordenada(425, 575);
		Coordenada cor5 = new Coordenada(525, 575);

		
		//orogorn
		if(user.getEleccion()==1){
		NaveGrafica nave = new NaveGrafica(cor3, cor4, cor5, Color.yellow);
		ArregloDeObjetos.add(nave);
		nuestroPanel.refNave(nave);
		}
		//legolos
		else if(user.getEleccion()==2){
		NaveGrafica nave = new NaveGrafica(cor3, cor4, cor5, Color.blue);
		ArregloDeObjetos.add(nave);
		nuestroPanel.refNave(nave);
		}
		//gondolf
		else{
		NaveGrafica nave = new NaveGrafica(cor3, cor4, cor5, Color.red);
		ArregloDeObjetos.add(nave);
		nuestroPanel.refNave(nave);
		}

		
		//texto vidas
		TextoGrafico Vidas = new TextoGrafico("Vidas", Color.red, 1700, 400);
		Vidas.setSize(35);
		ArregloDeObjetos.add(Vidas);
		//texto puntos
		TextoGrafico Puntos = new TextoGrafico("Puntos", Color.blue, 1700, 700);
		Puntos.setSize(30);
		ArregloDeObjetos.add(Puntos);
		//texto puntuaje
		TextoGrafico Puntuaje = new TextoGrafico("0", Color.blue, 1700, 850);
		Puntuaje.setSize(40);
		ArregloDeObjetos.add(Puntuaje);
		//texto numero de vidas
		TextoGrafico Numvidas = new TextoGrafico("3", Color.red, 1700, 550);
		Numvidas.setSize(40);
		ArregloDeObjetos.add(Numvidas);
		
		//		TextoGrafico textofinal = new TextoGrafico("FIN", Color.white, 900, 500);
		//		textofinal.setSize(120);

		//enemigo 1
		int rango1 = Aleatorio(800, 50);
		Coordenada Salida1 = new Coordenada(rango1, -40);
		RectanguloGrafico asteoride1 = new RectanguloGrafico(Salida1, 25, 25, Color.GREEN);
		//enemigo  2
		int rango2 = Aleatorio(800, 50);
		Coordenada Salida2 = new Coordenada(rango2, -25);
		RectanguloGrafico asteoride2 = new RectanguloGrafico(Salida2, 25, 25, Color.GREEN);
		//enemigo 3
		int rango3 = Aleatorio(800, 50);
		Coordenada Salida3 = new Coordenada(rango3, -80);
		RectanguloGrafico asteoride3 = new RectanguloGrafico(Salida3, 25, 25, Color.GREEN);
		//enemigo 
		int rango4 = Aleatorio(800, 50);
		Coordenada Salida4 = new Coordenada(rango4, -120);
		RectanguloGrafico asteoride4 = new RectanguloGrafico(Salida4, 25, 25, Color.GREEN);
		//enemigo 5
		int rango5 = Aleatorio(800, 50);
		Coordenada Salida5 = new Coordenada(rango5, -200);
		RectanguloGrafico asteoride5 = new RectanguloGrafico(Salida5, 25, 25, Color.GREEN);

		ArregloDeObjetos.add(asteoride1);
		ArregloDeObjetos.add(asteoride2);
		ArregloDeObjetos.add(asteoride3);
		ArregloDeObjetos.add(asteoride4);
		ArregloDeObjetos.add(asteoride5);
		
		nuestroPanel.refAst(asteoride1, asteoride2, asteoride3, asteoride4, asteoride5);

		//nuestroPanel.refFinal(textofinal);
		nuestroPanel.refPuntos(Numvidas);
		nuestroPanel.refVidas(Puntuaje);
		nuestraventana.getContentPane().add(nuestroPanel);
		nuestroPanel.setLayout(null);
		nuestraventana.setSize(1000, 600);//tamaño
		nuestraventana.setVisible(true);
		nuestraventana.setBackground(Color.black);//color
		nuestroPanel.iniciar();

	}
}