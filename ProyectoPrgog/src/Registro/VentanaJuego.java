package Registro;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;


public class VentanaJuego extends JFrame{
	private JFrame juego;
	private ArrayList<Arma> armaArray = new ArrayList<>();
	private Protagonista p;
	private ArrayList<Enemigo> enemigoArray = new ArrayList<Enemigo>();
	private JFrame fin;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try{
					VentanaJuego window = new VentanaJuego();
					window.juego.setVisible(true);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public VentanaJuego(){
		Initialize();
		
	}
	
	public void Initialize(){
		juego = new JFrame();
		juego.setBounds(0, 0, 1000, 600);
		p = new Protagonista(juego.getWidth()/2, juego.getHeight(), 1);
		juego.setVisible(true);
		juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		juego.setResizable(false);
		JLabel vidas = new JLabel();
		vidas.setText("Nº de Vidas: "+ p.getPV());
		vidas.setBounds(1000-100, 600-75, 100, 75);
		juego.add(vidas);
		
		
		EventQueue.invokeLater( new Runnable(){
			public void run() {
				int contador = 0;
				if(contador <= 99){
					try {
						crearEnemigos(enemigoArray);
						Thread.sleep(2000);
						int contadorEnemigos = 0;
						if(enemigoArray.get(contadorEnemigos).getPosY() != 100){
							moverEnemigos(enemigoArray);
							contadorEnemigos++;
						}
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				contador++;				
		
				} else {
					fin = new JFrame();
					fin.setResizable(false);
					fin.setTitle("¡Enhorabuena!");
					JTextField texto = new JTextField();
					JButton boton = new JButton("Volver al Menú");
					texto.setText("Has superado el juego.");
					fin.add(texto);
					fin.add(boton);
					fin.setVisible(true);
					boton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							VentanaMenu menu = new VentanaMenu();
							fin.setVisible(false);
							juego.setVisible(false);
						}
					});
				}
				while(true){
					repaint();
				}
					
			}
		});
			
		
		
		juego.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent derecha) {
				while (derecha.getKeyCode() == KeyEvent.VK_RIGHT){
					p.setPosX(moverDerecha(p.getPosX()));
				}
			}
			
			public void keyPressed2(KeyEvent izquierda) {
				while (izquierda.getKeyCode() == KeyEvent.VK_LEFT){
					p.setPosX(moverIzquierda(p.getPosX()));
				}
			}
			
			public void keyPressed3(KeyEvent espacio) {
				if (espacio.getKeyCode() == KeyEvent.VK_SPACE){
					disparar(p.getPosX(), p.getPosY(), armaArray);
				}
			}

			public void keyReleased(KeyEvent e) {}

			public void keyTyped(KeyEvent e) {}
			
		});
	}	
		
	
	
	public int randomizadorEnemigos(){
		return (int) (Math.random() * 2) + 1;
	}
	
	
	public void crearEnemigos(ArrayList<Enemigo> e){
				try{
					if(e.size() < 5){
						int random = randomizadorEnemigos();
						if (random == 1){
							Esqueleto s = new Esqueleto( (int) (Math.random() * 1000)+ 1, 0);
							s.paint(null);
							e.add(s);
							
						}
						if (random == 2){
							Zombie z = new Zombie( (int) (Math.random() * 1000)+ 1, 0);
							z.paint(null);
							e.add(z);
						}
					}
				}
				
				catch(IndexOutOfBoundsException except){}
			}
	
	public int moverDerecha(int PosX){
		PosX += 1;
		return PosX;
	}
	
	public int moverIzquierda(int PosX){
		PosX -= 1;
		return PosX;
	}
	
	
	public void moverEnemigos(ArrayList<Enemigo> e){
		int contador = 0;
		if (contador <= e.size()){
			e.get(contador).moverAbajo(e.get(contador).getPosY());
			contador++;
		}
	}
	
	public boolean consultarPos(ArrayList<Enemigo> e, ArrayList<Arma> arma, int contadorArrayE, int contadorArrayA){
		boolean coincidir = false;	
		coincidir = e.get(contadorArrayE).getPosX() + 10 > arma.get(contadorArrayA).getPosX() && e.get(contadorArrayE).getPosX() - 10 < arma.get(contadorArrayA).getPosX() && e.get(contadorArrayE).getPosY() == arma.get(contadorArrayA).getPosY();
		
		return coincidir;
			
	}
	
	public void desaparecerArma(ArrayList<Arma> armaArray, int contadorArrayA){
		armaArray.set(contadorArrayA, null);
	}
	
	public void desaparecerEnemigo(ArrayList<Enemigo> enemigoArray, int contadorArrayE){
		enemigoArray.set(contadorArrayE, null);
	}
	
	public void disparar(int PosX, int PosY, ArrayList<Arma> armaArray){
		Arma a = new Arma(PosX, PosY);
		armaArray.add(a);
		while (a.getPosY() != 0){
			a.moverArriba(a.getPosY());
			colision();
			
		}
	}
	
	public void colision(){
		int contadorArrayE = 0;
		int contadorArrayA = 0;
		while(contadorArrayE <= enemigoArray.size()){
			while(contadorArrayA <= armaArray.size()){
				if (consultarPos(enemigoArray, armaArray, contadorArrayE, contadorArrayA) == true){
					enemigoArray.get(contadorArrayE).setPV(enemigoArray.get(contadorArrayE).getPV() - p.getDanyo());
					desaparecerArma(armaArray, contadorArrayA);
					if(enemigoArray.get(contadorArrayE).getPV() <= 0){
						desaparecerEnemigo(enemigoArray, contadorArrayE);
					}
				}
			contadorArrayA++;
			}
		contadorArrayE++;	
		}
	}

}
