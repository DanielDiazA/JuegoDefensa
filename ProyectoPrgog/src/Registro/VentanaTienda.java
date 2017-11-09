package grafica;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class VentanaTienda extends JFrame {
	private Integer dinero;
	private JLabel labelDinero;
	private JButton btnCompraArco;
	private JButton btnCompraBaston;
	private JButton btnMonedas;
	private JLabel lblTienda;
	private JLabel lblPrecioArco;
	private JLabel lblPrecioBaston;
	private JLabel iconoMonedas;
	private JButton btnSalir;
	
	public VentanaTienda(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(768, 453);
		getContentPane().setLayout(null);
		
		labelDinero = new JLabel(getDinero());
		labelDinero.setForeground(Color.ORANGE);
		labelDinero.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		labelDinero.setBounds(631, 0, 121, 40);
		getContentPane().add(labelDinero);
		
		iconoMonedas = new JLabel("");
		iconoMonedas.setIcon(new ImageIcon("C:\\Users\\pili\\workspace\\Nuevo Juego\\bin\\fotos\\MonedaOro.png"));
		iconoMonedas.setBounds(592, 0, 40, 40);
		getContentPane().add(iconoMonedas);
		
		btnCompraArco = new JButton("");
		btnCompraArco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int monedas = dinero.intValue();
				if(monedas >= 1000){
					monedas -= 1000;
					dinero = new Integer(monedas);
				}
				
				else {
					System.out.println("No hay suficientes monedas");
				}
			}
		});
		
		btnCompraBaston.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int monedas = dinero.intValue();
				if(monedas >= 5000){
					monedas -= 5000;
					dinero = new Integer(monedas);
				}
				
				else {
					System.out.println("No hay suficientes monedas");
				}
			}
		});
		
		btnCompraArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraArco.setIcon(new ImageIcon("C:\\Users\\pili\\workspace\\Nuevo Juego\\bin\\fotos\\Arquero.png"));
		btnCompraArco.setContentAreaFilled(false);
		btnCompraArco.setOpaque(false);
		btnCompraArco.setBounds(43, 123, 200, 200);
		getContentPane().add(btnCompraArco);
		
		btnCompraBaston = new JButton("");
		btnCompraBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraBaston.setIcon(new ImageIcon("C:\\Users\\pili\\workspace\\Nuevo Juego\\bin\\fotos\\Hechicero.png"));
		btnCompraBaston.setContentAreaFilled(false);
		btnCompraBaston.setOpaque(false);
		btnCompraBaston.setBounds(511, 123, 200, 200);
		getContentPane().add(btnCompraBaston);
		
		btnMonedas = new JButton("\u00A1Monedas!");
		btnMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int monedas = dinero.intValue();
				monedas++;
				dinero = new Integer(monedas);
			}
		});
		btnMonedas.setFont(new Font("Old English Text MT", Font.PLAIN, 35));
		btnMonedas.setBounds(266, 192, 224, 90);
		getContentPane().add(btnMonedas);
		
		btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnSalir.setIcon(new ImageIcon("C:\\Users\\pili\\workspace\\Nuevo Juego\\bin\\fotos\\Flecha.png"));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(675, 382, 77, 33);
		getContentPane().add(btnSalir);
		
		lblTienda = new JLabel("TIENDA");
		lblTienda.setBorder(new LineBorder(new Color(204, 153, 51), 5, true));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setForeground(new Color(0, 0, 0));
		lblTienda.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		lblTienda.setBounds(177, 13, 405, 73);
		getContentPane().add(lblTienda);
		
		lblPrecioArco = new JLabel("Monedas: 1000");
		lblPrecioArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioArco.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioArco.setForeground(Color.ORANGE);
		lblPrecioArco.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioArco.setBounds(43, 322, 200, 54);
		getContentPane().add(lblPrecioArco);
		
		lblPrecioBaston = new JLabel("Monedas: 5000");
		lblPrecioBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioBaston.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioBaston.setForeground(Color.ORANGE);
		lblPrecioBaston.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioBaston.setBounds(511, 322, 200, 54);
		getContentPane().add(lblPrecioBaston);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\pili\\workspace\\Nuevo Juego\\bin\\fotos\\Luna.jpg"));
		background.setBounds(0, 0, 752, 415);
		getContentPane().add(background);
	}
	
	private String getDinero() {
		if (dinero == null){
			return "Monedas: 0";	
		}
		else {
			return "Monedas: " + dinero;
		}
	}

	public static void main(String[] args) {
		VentanaTienda tienda = new VentanaTienda();
		tienda.setVisible(true);
	}
}
