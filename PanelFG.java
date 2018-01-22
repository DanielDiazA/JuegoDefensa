package Modelos;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Registro.Inventario;
import Registro.Usuario;
import Registro.VentanaMenu;

public class PanelFG extends JPanel implements KeyListener {
	Usuario user;
	Inventario invent;
	
	public JPanel PanelEmergente;

	public static int Aleatorio(int Max, int Min) {
		return (int) (Math.random() * (Max - Min));
	}

	ArrayList v;
	ArrayList ast = new ArrayList();

	NaveGrafica nave;
	Coordenada movimientoIzq = new Coordenada(-25, 0);
	Coordenada movimientoDer = new Coordenada(25, 0);
	Coordenada movimientoNulo = new Coordenada(0, 0);

	Boolean FinDeJuego = true;

	int ContadorAsteroides = 5;

	TextoGrafico puntos;
	TextoGrafico vidas;
	TextoGrafico Final;

	int Score;
	int Vidas = 3;

	int Mov = 6;
	int MAXAST = 5;

	public PanelFG(ArrayList vectordeO, Usuario u, Inventario i) {
		this.v = vectordeO;
		this.user = u;
		this.invent = i;
		this.addKeyListener(this);
		setFocusable(true);
	}

	public void paint(Graphics g) {
		// para no parpadeos
		Dimension d = getSize();
		Image Imagen = createImage(d.width, d.height);
		Graphics buff = Imagen.getGraphics();
		//
		Dibujable dib;
		for (int i = 0; i < v.size(); i++) {

			dib = (Dibujable) v.get(i);
			dib.dibujar(buff);
		}

		g.drawImage(Imagen, 0, 0, null);
	}

	public void update(Graphics g) {

		paint(g);

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_LEFT) {
			if (this.nave.getX() <= 0) {
				nave.mover(movimientoNulo);

			} else {
				this.nave.mover(movimientoIzq);
			}
		}
		if (tecla == KeyEvent.VK_RIGHT) {
			if (this.nave.getX() >= 800) {
				nave.mover(movimientoNulo);
			} else {
				this.nave.mover(movimientoDer);
			}
		}
		if (tecla == KeyEvent.VK_Q) {
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_LEFT) {
			if (this.nave.getX() <= 0) {
				nave.mover(movimientoNulo);

			} else {
				this.nave.mover(movimientoIzq);
			}

		}
		if (tecla == KeyEvent.VK_RIGHT) {
			if (this.nave.getX() >= 800) {
				nave.mover(movimientoNulo);
			} else {
				this.nave.mover(movimientoDer);
			}
		}
		if (tecla == KeyEvent.VK_Q) {
			CirculoGrafico bala = nave.Bala();
			nave.balas.add(bala);
			v.add(bala);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void refNave(NaveGrafica n) {
		this.nave = n;
	}

	public void refAst(RectanguloGrafico a, RectanguloGrafico b, RectanguloGrafico c, RectanguloGrafico d,
			RectanguloGrafico e) {

		ast.add(a);
		ast.add(b);
		ast.add(c);
		ast.add(d);
		ast.add(e);
	}

	public void refPuntos(TextoGrafico a) {

		this.puntos = a;

	}

	public void refVidas(TextoGrafico b) {

		this.vidas = b;

	}

	public void refFinal(TextoGrafico c) {

		this.Final = c;

	}

	public void Colision() {
		for (int i = 0; i < nave.balas.size(); i++) {

			CirculoGrafico bala = (CirculoGrafico) nave.balas.get(i);
			for (int j = 0; j < ast.size(); j++) {

				RectanguloGrafico aste = (RectanguloGrafico) ast.get(j);
				Coordenada Corbala = new Coordenada(bala.getX(), bala.getY());
				Coordenada derecha = new Coordenada(aste.getX() + 30, aste.getY());
				Coordenada izquierda = new Coordenada(aste.getX() - 15, aste.getY());
				Coordenada medio = new Coordenada(aste.getX(), aste.getY());

				if (Corbala.getX() > izquierda.getX() && Corbala.getX() < derecha.getX()
						&& Corbala.getY() < medio.getY() && Corbala.getY() + 25 > medio.getY()) {

					aste.pintar(Color.black);
					bala.pintar(Color.black);
					bala.setY(2000);
					aste.setY(2000);
					nave.balas.remove(bala);
					ast.remove(aste);
					ContadorAsteroides--;
					Score += 5;
					puntos.SetColor(Color.black);
					String NuevoScore = "" + Score;
					TextoGrafico Nrpuntos = new TextoGrafico(NuevoScore, Color.blue, 1700, 850);
					Nrpuntos.setSize(40);
					puntos = Nrpuntos;
					v.add(puntos);

				}
				if ((medio.getY() > 475 && medio.getY() < 550) && (nave.cor1.getX() < medio.getX())
						&& (nave.cor2.getX() > medio.getX())) {

					Score = Score - 5;
					Vidas--;
					System.out.println(Vidas);

					String nuevoScore = "" + Score;
					String nuevaaVidaa = "" + Vidas;
					vidas.SetColor(Color.black);
					puntos.SetColor(Color.black);

					TextoGrafico Nrvidas = new TextoGrafico(nuevaaVidaa, Color.red, 1700, 550);
					Nrvidas.setSize(40);
					vidas = Nrvidas;

					TextoGrafico NrPuntos = new TextoGrafico(nuevoScore, Color.blue, 1700, 850);
					NrPuntos.setSize(40);
					puntos = NrPuntos;

					v.add(vidas);
					v.add(puntos);
					ast.remove(aste);
					aste.setY(2000);

					ContadorAsteroides--;

				}

			}

		}

	}
	
	
	
	
	
	
	
	static int vidas1=3;
	static int puntos1;
	
	public void jugar (){
		
		Ventana nuestraventana = new Ventana("Wall Defense");
		nuestraventana.setResizable(false);
		nuestraventana.setLocation(400, 200);
		ArrayList ArregloDeObjetos = new ArrayList();

		Coordenada cor1 = new Coordenada(250, 250);
		Coordenada cor2 = new Coordenada(350, 350);

		// NAVEEEE

		Coordenada cor3 = new Coordenada(475, 500);
		Coordenada cor4 = new Coordenada(425, 575);
		Coordenada cor5 = new Coordenada(525, 575);

		NaveGrafica nave = new NaveGrafica(cor3, cor4, cor5, Color.yellow);

		

		TextoGrafico Vidas = new TextoGrafico("Vidas", Color.red, 1700, 400);
		Vidas.setSize(35);
		ArregloDeObjetos.add(Vidas);
		TextoGrafico Puntos = new TextoGrafico("Puntos", Color.blue, 1700, 700);

		Puntos.setSize(30);
		ArregloDeObjetos.add(Puntos);

		TextoGrafico Puntuaje = new TextoGrafico("0", Color.blue, 1700, 850);
		Puntuaje.setSize(40);
		ArregloDeObjetos.add(Puntuaje);

		TextoGrafico Numvidas = new TextoGrafico("3", Color.red, 1700, 550);
		Numvidas.setSize(40);
		ArregloDeObjetos.add(Numvidas);

		TextoGrafico textofinal = new TextoGrafico("FIN", Color.white, 900, 500);
		textofinal.setSize(120);

		int rango1 = Aleatorio(800, 50);
		Coordenada Salida1 = new Coordenada(rango1, -40);
		RectanguloGrafico asteoride1 = new RectanguloGrafico(Salida1, 25, 25, Color.GREEN);
		int rango2 = Aleatorio(800, 50);
		Coordenada Salida2 = new Coordenada(rango2, -25);
		RectanguloGrafico asteoride2 = new RectanguloGrafico(Salida2, 25, 25, Color.GREEN);
		int rango3 = Aleatorio(800, 50);
		Coordenada Salida3 = new Coordenada(rango3, -80);
		RectanguloGrafico asteoride3 = new RectanguloGrafico(Salida3, 25, 25, Color.GREEN);
		int rango4 = Aleatorio(800, 50);
		Coordenada Salida4 = new Coordenada(rango4, -120);
		RectanguloGrafico asteoride4 = new RectanguloGrafico(Salida4, 25, 25, Color.GREEN);
		int rango5 = Aleatorio(800, 50);
		Coordenada Salida5 = new Coordenada(rango5, -200);
		RectanguloGrafico asteoride5 = new RectanguloGrafico(Salida5, 25, 25, Color.GREEN);

		ArregloDeObjetos.add(asteoride1);
		ArregloDeObjetos.add(asteoride2);
		ArregloDeObjetos.add(asteoride3);
		ArregloDeObjetos.add(asteoride4);
		ArregloDeObjetos.add(asteoride5);
		ArregloDeObjetos.add(nave);

		PanelFG nuestroPanel = new PanelFG(ArregloDeObjetos, user, invent);
		

		nuestroPanel.refNave(nave);
		
		nuestroPanel.refAst(asteoride1, asteoride2, asteoride3, asteoride4, asteoride5);
		
		
		nuestroPanel.refFinal(textofinal);
		nuestroPanel.refPuntos(Numvidas);
		nuestroPanel.refVidas(Puntuaje);
		
		
		nuestraventana.getContentPane().add(nuestroPanel);
		nuestroPanel.setLayout(null);
	
		nuestraventana.setSize(1000, 600);
		nuestraventana.setVisible(true);
		nuestraventana.setBackground(Color.black);
		nuestroPanel.iniciar();
	

	}

	
	
	
	
	
	
	
	
	
	
	
	public void iniciar() {
		while (FinDeJuego) {

			try {
				if (!nave.balas.isEmpty()) {
					nave.Ciclo();
				}
				for (int i = 0; i < ast.size(); i++) {

					RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
					rect.Ciclo(Mov);
					if (rect.getY() > 525) {

						int rango = Aleatorio(800, 50);
						rect.setY(0);
						rect.setX(rango);

						Score = Score - 5;
						Vidas--;
						System.out.println(Vidas);

						String nuevoScore = "" + Score;
						String nuevaaVidaa = "" + Vidas;
						vidas.SetColor(Color.black);
						puntos.SetColor(Color.black);

						TextoGrafico Nrvidas = new TextoGrafico(nuevaaVidaa, Color.red, 1700, 550);
						Nrvidas.setSize(40);
						vidas = Nrvidas;

						TextoGrafico NrPuntos = new TextoGrafico(nuevoScore, Color.blue, 1700, 850);
						NrPuntos.setSize(40);
						puntos = NrPuntos;

						v.add(vidas);
						v.add(puntos);

					}

				}
				if (ContadorAsteroides < MAXAST) {

					int rango = Aleatorio(800, 50);
					Coordenada Inicio = new Coordenada(rango, 0);
					RectanguloGrafico nuevo = new RectanguloGrafico(Inicio, 25, 25, Color.green);
					ast.add(nuevo);
					v.add(nuevo);
					nuevo.Ciclo(Mov);
					ContadorAsteroides++;
				}
				int nivel = 1;
				String niveles = "" + nivel;
				TextoGrafico TextoNivel = new TextoGrafico("Nivel", Color.ORANGE, 1700, 950);
				TextoNivel.setSize(60);
				TextoGrafico TextoNrNivel = new TextoGrafico(niveles, Color.pink, 1700, 1050);
				TextoNrNivel.setSize(60);
				v.add(TextoNrNivel);
				v.add(TextoNivel);

				if (Score >= 50 && Score < 100) {
					nivel = 2;
					String NuevoNivel = "" + nivel;
					TextoNrNivel.SetColor(Color.black);
					TextoGrafico NrNivel = new TextoGrafico(NuevoNivel, Color.ORANGE, 1700, 1050);
					NrNivel.setSize(60);
					TextoNrNivel = NrNivel;
					v.add(TextoNrNivel);
					Mov = 4;
					MAXAST = 6;
					for (int i = 0; i < ast.size(); i++) {

						RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
						rect.pintar(Color.MAGENTA);

					}
				}
				if (Score >= 101 && Score < 150000000) {
					nivel = 3;
					String NuevoNivel = "" + nivel;
					TextoNrNivel.SetColor(Color.black);
					TextoGrafico NrNivel = new TextoGrafico(NuevoNivel, Color.ORANGE, 1700, 1050);
					NrNivel.setSize(60);
					TextoNrNivel = NrNivel;
					v.add(TextoNrNivel);
					Mov = 6;
					MAXAST = 7;
					for (int i = 0; i < ast.size(); i++) {

						RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
						rect.pintar(Color.BLUE);

					}
				}

				if (Vidas <= 0) {
					FinDeJuego = false;
					// Icon icono = new
					// ImageIcon(getClass().getResource("C:\\Users\\Dani\\Desktop\\Recursos\\Esqueleto"));
					String[] options = { "Volver al Menu", "Ver puntuacion", "Volver a jugar", "Cerrar Juego" };
					int seleccion = JOptionPane.showOptionDialog(PanelEmergente,
							"Es necesario que seleccione una opcion", "Titulo", JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (seleccion == 0) {

						new VentanaMenu(user, invent);
						Window w = SwingUtilities.getWindowAncestor(PanelFG.this);
						w.setVisible(false);

					} else if (seleccion == 1) {

						JOptionPane.showMessageDialog(null, "Tu puntuacion ha sido de "+Score);
						//Ranking
						
					} else if (seleccion == 2) {
						
						Window w = SwingUtilities.getWindowAncestor(PanelFG.this);
						w.setVisible(false);
						jugar();
						
					} else if (seleccion == 3) {

						System.exit(0);
					}

					// v.add(Final);
				}
				Colision();
				Thread.sleep(50);
			} catch (InterruptedException err) {
				System.out.println(err);
			}
			repaint();

		}

	}

}
