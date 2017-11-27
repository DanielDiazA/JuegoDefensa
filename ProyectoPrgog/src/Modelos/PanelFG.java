package Modelos;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.xml.soap.Text;

public class PanelFG extends JPanel implements KeyListener {

	public static int Aleatorio(int Max, int Min) {
		return (int) (Math.random() * (Max - Min));
	}

	ArrayList v;
	ArrayList ast = new ArrayList();

	NaveGrafica nave;
	Coordenada movimientoIzq = new Coordenada(-25, 0);
	Coordenada movimientoDer = new Coordenada(25, 0);
	Coordenada movimientoNulo = new Coordenada(0, 0);

	int ContadorAsteroides = 5;
	TextoGrafico puntos;
	TextoGrafico vidas;
	TextoGrafico Final;
	
	int score;
	int Vidas=3;

	public PanelFG(ArrayList vectordeO) {
		this.v = vectordeO;
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
			this.nave.mover(movimientoIzq);

		}
		if (tecla == KeyEvent.VK_RIGHT) {
			this.nave.mover(movimientoDer);
		}
		if (tecla == KeyEvent.VK_Q) {
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int tecla = e.getKeyCode();
		if (tecla == KeyEvent.VK_LEFT) {
			this.nave.mover(movimientoIzq);

		}
		if (tecla == KeyEvent.VK_RIGHT) {
			this.nave.mover(movimientoDer);
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
	public void refPuntos(TextoGrafico a){
		
		this.puntos=a;
		
	}
	
	public void refVidas(TextoGrafico b){
		
		this.vidas=b;
		
	}
	public void refFinal(TextoGrafico c){
		
		this.Final=c;
		
	}
	
	
	public void Colision()
	{
		for(int i =0;i<nave.balas.size();i++){
			
			CirculoGrafico bala=(CirculoGrafico)nave.balas.get(i);
			for(int j=0;j <ast.size();j++){
				
				RectanguloGrafico aste= (RectanguloGrafico) ast.get(j);
				Coordenada Corbala= new Coordenada(bala.getX(),bala.getY());
				Coordenada derecha = new Coordenada(aste.getX()+30,aste.getY());
				Coordenada izquierda = new Coordenada(aste.getX()-15,aste.getY());
				Coordenada medio = new Coordenada(aste.getX(),aste.getY());
				
				
				if(Corbala.getX()>izquierda.getX() && Corbala.getX()<derecha.getX()&& Corbala.getY()<medio.getY())
				{
					
					aste.pintar(Color.white);
					bala.pintar(Color.white);
					bala.setY(2000);
					aste.setY(2000);
					nave.balas.remove(bala);
					ast.remove(aste);
					ContadorAsteroides--;
					
				}
				if((medio.getY()>475 && medio.getY()>550) &&(nave.cor1.getX()<medio.getX())&&(nave.cor2.getX()>medio.getX())){
					
				score=	score-5;
				Vidas--;
					String nuevoScore=""+score;
					String nuevaaVidaa=""+Vidas;
					vidas.SetColor(Color.white);
					puntos.SetColor(Color.white);
					
					TextoGrafico Nrvidas=new TextoGrafico(nuevaaVidaa, Color.red,1700,550);
					Nrvidas.setSize(40);
					vidas=Nrvidas;
					
					
					TextoGrafico NrPuntos= new TextoGrafico(nuevoScore, Color.blue, 1700, 850);
					NrPuntos.setSize(40);
					puntos=NrPuntos;
					 
					v.add(vidas);
					v.add(puntos);
					ast.remove(aste);
					aste.setY(2000);
					
					ContadorAsteroides--;
					
				}
				
			}
			
		}
	}
	

	public void iniciar() {
		while (true) {

			try {
				if (!nave.balas.isEmpty()) {
					nave.Ciclo();
				}
				for (int i = 0; i < ast.size(); i++) {

					RectanguloGrafico rect = (RectanguloGrafico) ast.get(i);
					rect.Ciclo();
					if (rect.getY() > 525) {

						int rango = Aleatorio(800, 50);
						rect.setY(0);
						rect.setX(rango);

					}

				}
				if(ContadorAsteroides<5){
					
					int rango= Aleatorio(800, 50);
					Coordenada Inicio =new Coordenada(rango,0);
					RectanguloGrafico nuevo=new RectanguloGrafico(Inicio, 25, 25, Color.green);
					ast.add(nuevo);
					v.add(nuevo);
					nuevo.Ciclo();
					ContadorAsteroides++;
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
