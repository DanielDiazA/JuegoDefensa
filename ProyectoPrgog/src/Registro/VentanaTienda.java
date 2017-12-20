package Clases;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class VentanaTienda extends JFrame {
	private int monedas;
	private JLabel labelDinero;
	private JButton btnCompraArco;
	private JButton btnCompraBaston;
	private JButton btnMonedas;
	private JLabel lblTienda;
	private JLabel lblPrecioArco;
	private JLabel lblPrecioBaston;
	private JLabel iconoMonedas;
	private JButton btnSalir;
	private JFrame tienda;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTienda window = new VentanaTienda();
					window.tienda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public VentanaTienda(){
		Initialize();
	}
	
	
	public void Initialize(){
		tienda = new JFrame();
		tienda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tienda.setSize(768, 453);
		tienda.setLayout(null);
		tienda.setVisible(true);
		labelDinero = new JLabel("Monedas: " + getMonedas());
		labelDinero.setForeground(Color.ORANGE);
		labelDinero.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		labelDinero.setBounds(631, 0, 121, 40);
		tienda.add(labelDinero);
		
		iconoMonedas = new JLabel("");
		iconoMonedas.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\MonedaOro.png"));
		iconoMonedas.setBounds(592, 0, 40, 40);
		tienda.add(iconoMonedas);
		
		btnCompraArco = new JButton("");
	
		
		btnCompraArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraArco.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Arquero.png"));
		btnCompraArco.setContentAreaFilled(false);
		btnCompraArco.setOpaque(false);
		btnCompraArco.setBounds(43, 123, 200, 200);
		tienda.add(btnCompraArco);
		
		btnCompraBaston = new JButton("");
		btnCompraBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraBaston.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Hechicero.png"));
		btnCompraBaston.setContentAreaFilled(false);
		btnCompraBaston.setOpaque(false);
		btnCompraBaston.setBounds(511, 123, 200, 200);
		tienda.add(btnCompraBaston);
		

		
		btnCompraBaston.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getMonedas() >= 5000){
					monedas -= 5000;
				}
				
				else {
					System.out.println("No hay suficientes monedas");
				}
			}
		});
		
		btnMonedas = new JButton("\u00A1Monedas!");
		btnMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					monedas++;
				}catch(Exception excepcion){
				}
			}
		});
		btnMonedas.setFont(new Font("Old English Text MT", Font.PLAIN, 35));
		btnMonedas.setBounds(266, 192, 224, 90);
		tienda.add(btnMonedas);
		
		btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenu menu = new VentanaMenu();
				tienda.setVisible(false);
				
			}
		});
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Flecha.png"));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(675, 382, 77, 33);
		tienda.add(btnSalir);
		
		lblTienda = new JLabel("TIENDA");
		lblTienda.setBorder(new LineBorder(new Color(204, 153, 51), 5, true));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setForeground(new Color(0, 0, 0));
		lblTienda.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		lblTienda.setBounds(177, 13, 405, 73);
		tienda.add(lblTienda);
		
		lblPrecioArco = new JLabel("Monedas: 1000");
		lblPrecioArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioArco.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioArco.setForeground(Color.ORANGE);
		lblPrecioArco.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioArco.setBounds(43, 322, 200, 54);
		tienda.add(lblPrecioArco);
		
		lblPrecioBaston = new JLabel("Monedas: 5000");
		lblPrecioBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioBaston.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioBaston.setForeground(Color.ORANGE);
		lblPrecioBaston.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioBaston.setBounds(511, 322, 200, 54);
		tienda.add(lblPrecioBaston);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\Jonathan\\workspace\\ProyectoDefender\\src\\Recursos\\Luna.jpg"));
		background.setBounds(0, 0, 752, 415);
		tienda.add(background);
	}
	
	private int getMonedas() {
		try{
			return monedas;
		}
		
		catch(Exception except){
			return 0;
		}
	}

}
