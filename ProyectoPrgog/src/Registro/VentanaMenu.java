package Registro;

import javax.swing.*;

import Modelos.Coordenada;
import Modelos.NaveGrafica;
import Modelos.PanelFG;
import Modelos.RectanguloGrafico;
import Modelos.TextoGrafico;
import Modelos.Ventana;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMenu extends JFrame{
	private JButton btnTienda;
	private JButton btnJugar;
	private JButton btnSalir;
	private JFrame menu;
	
	
	static int vidas=3;
	static int puntos;
	public static int Aleatorio(int Max, int Min) {
		return (int) (Math.random() * (Max - Min));
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu();
					window.menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	
	
	public VentanaMenu() {
		Initialize();
	}
	ArrayList v;
	public void Initialize(){
		menu = new JFrame();
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setResizable(false);
		menu.getContentPane().setLayout(null);
		menu.setBounds(400, 200, 1000, 600);
		
		
		
		btnJugar = new JButton("Jugar");
		btnJugar.setFont(new Font("Bauhaus 93", Font.PLAIN, 60));
		btnJugar.setBounds(277, 197, 400, 117);
		menu.getContentPane().add(btnJugar);
		
		btnTienda = new JButton("Tienda");
		btnTienda.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		btnTienda.setBounds(277, 385, 400, 117);
		menu.getContentPane().add(btnTienda);
		
		btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Flecha.png"));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(677, 384, 85, 41);
		menu.getContentPane().add(btnSalir);

		
		btnTienda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				VentanaTienda tienda = new VentanaTienda();
				menu.setVisible(false);
			}
			
		});
		
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				menu.setVisible(false);				
			}
		});
		
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}
	});
  }


}
	