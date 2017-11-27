package Registro;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;


public class VentanaJuego extends JFrame{
	private JFrame juego;
	private Protagonista p;
	private ArrayList<Enemigo> e = new ArrayList<Enemigo>();
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
		p = new Protagonista(juego.getWidth()/2, juego.getHeight(), 1);
		juego.setVisible(true);
		juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		juego.setBounds(500, 200, 770, 450);
		juego.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dani\\Desktop\\icono.png"));
		juego.setResizable(false);
		int contador = 0;
		if(contador != 100){
			EventQueue.invokeLater( new Runnable(){
				public void run() {
					try {
						crearEnemigos(e);
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			});
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
					disparar(p.getPosX(), p.getPosY());
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
					if(e.size() != 10){
						int random = randomizadorEnemigos();
						if (random == 1){
							e.add(new Esqueleto( (int) (Math.random() * 770)+ 1, (int) (Math.random() * 450)+ 1) );
						}
						if (random == 2){
							e.add(new Zombie( (int) (Math.random() * 770)+ 1, (int) (Math.random() * 450)+ 1) );
						}
					}
				}
				
				catch(IndexOutOfBoundsException except){}
			}
	
	public int moverDerecha(int PosX){
		int PosX2 = PosX + 1;
		return PosX2;
	}
	
	public int moverIzquierda(int PosX){
		int PosX2 = PosX - 1;
		return PosX2;
	}
	
	public int moverArriba(int PosY){
		int PosY2 = PosY - 1;
		return PosY2;
	}
	
	public int moverAbajo(int PosY){
		int PosY2 = PosY + 1;
		return PosY2;
	}
	
	public boolean consultarPos(ArrayList<Enemigo> e, Arma a, int contador){
		boolean coincidir = false;	
		if(contador <= e.size()){
			coincidir = e.get(contador).getPosX() == a.getPosX() && e.get(contador).getPosY() == a.getPosY();
		}
		return coincidir;
			
	}
	
	public void disparar(int PosX, int PosY){
		Arma a = new Arma(PosX, PosY);
		while (a.getPosY() != 0){
			moverArriba(a.getPosY());
			int contador = 0;
			if (consultarPos(e, a, contador) == true){
				e.get(contador).setPV(e.get(contador).getPV() - p.getDanyo());
			}
			contador++;
		}
	}
	

}
