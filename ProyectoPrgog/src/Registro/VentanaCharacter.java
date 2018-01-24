/**
 * Ventana en la que administra los personajes que tiene cada usuario(si esque tiene comprados)
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */

package Registro;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VentanaCharacter extends JFrame {

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
	private JLabel lblOrogorn_1;
	private JLabel lblGondolf;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel;
	private JPanel panel_7;
	private JLabel lblVolverMenu;
	private JButton btnNewButton;
	private static Usuario user;
	private static Inventario invent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCharacter window = new VentanaCharacter(user, invent);
					window.tienda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaCharacter(Usuario u, Inventario i) {
		this.user = u;
		this.invent = i;
		Initialize();
	}

	public void Initialize() {
		//sonido moneda
		AudioClip coins;
		coins = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/moneda.wav"));
		//sonido volver a la venta anterior
		AudioClip atras;
		atras = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/atras.wav"));
		//musica de fondo
		AudioClip musicatienda;
		musicatienda = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/musicatienda.wav"));
		musicatienda.play();
		tienda = new JFrame("");
		tienda.setLocation(400, 200);
		tienda.setSize(1000, 600);
		tienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tienda.setResizable(false);
		tienda.getContentPane().setLayout(null);
		tienda.setVisible(true);
		labelDinero = new JLabel("Monedas: " + getMonedas());
		labelDinero.setForeground(Color.ORANGE);
		labelDinero.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		labelDinero.setBounds(674, 0, 238, 78);
		tienda.getContentPane().add(labelDinero);

		iconoMonedas = new JLabel("");
		iconoMonedas.setIcon(new ImageIcon(getClass().getResource("/Recursos/MonedaOro.png")));
		iconoMonedas.setBounds(924, 13, 46, 40);
		tienda.getContentPane().add(iconoMonedas);

		btnCompraArco = new JButton("");
		btnCompraArco.addActionListener(new ActionListener() {
			//metodo para equiparte con el peronaje indicado(si esque no lo tienes equipado y lo tienes comprado)
			public void actionPerformed(ActionEvent e) {
				if (invent.getP2() == 0) {

					JOptionPane.showMessageDialog(null, "No puedes equiparte un personaje que no tienes comprado");

				} else {
					if (user.getEleccion() == 2) {
						JOptionPane.showMessageDialog(null, "Ya lo tenias previamente seleccionado");
					} else {
						JOptionPane.showMessageDialog(null, "Te has equipado con Legolos!!");
						user.setEleccion(2);
					}

				}

			}
		});

		btnCompraArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraArco.setIcon(new ImageIcon(getClass().getResource("/Recursos/arco.png")));
		btnCompraArco.setContentAreaFilled(false);
		btnCompraArco.setOpaque(false);
		btnCompraArco.setBounds(43, 162, 200, 200);
		tienda.getContentPane().add(btnCompraArco);

		btnCompraBaston = new JButton("");
		btnCompraBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraBaston.setIcon(new ImageIcon(getClass().getResource("/Recursos/baston.png")));
		btnCompraBaston.setContentAreaFilled(false);
		btnCompraBaston.setOpaque(false);
		btnCompraBaston.setBounds(697, 162, 200, 200);
		tienda.getContentPane().add(btnCompraBaston);

		btnCompraBaston.addActionListener(new ActionListener() {
			//metodo para equiparte con el peronaje indicado(si esque no lo tienes equipado y lo tienes comprado)
			public void actionPerformed(ActionEvent e) {
				if (invent.getP3() == 0) {

					JOptionPane.showMessageDialog(null, "No puedes equiparte un personaje que no tienes comprado");

				} else {
					if (user.getEleccion() == 3) {
						JOptionPane.showMessageDialog(null, "Ya lo tenias previamente seleccionado");
					} else {
						JOptionPane.showMessageDialog(null, "Te has equipado con Gondolf!!");
						user.setEleccion(3);
					}

				}
				}

		});

		btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenu menu = new VentanaMenu(user, invent);
				
				tienda.setVisible(false);;
				atras.play();
				musicatienda.stop();
			}
		});
		btnSalir.setIcon(new ImageIcon(getClass().getResource("/Recursos/Flecha.png")));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(804, 443, 133, 78);
		tienda.getContentPane().add(btnSalir);

		lblTienda = new JLabel("Personajes");
		lblTienda.setBackground(Color.BLACK);
		lblTienda.setBorder(new LineBorder(new Color(204, 153, 51), 5, true));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setForeground(Color.ORANGE);
		lblTienda.setFont(new Font("Myriad Pro Light", Font.PLAIN, 50));
		lblTienda.setBounds(257, 13, 405, 73);
		tienda.getContentPane().add(lblTienda);

		lblPrecioArco = new JLabel("");
		lblPrecioArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioArco.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioArco.setForeground(Color.ORANGE);
		lblPrecioArco.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioArco.setBounds(43, 361, 200, 54);
		tienda.getContentPane().add(lblPrecioArco);

		lblPrecioBaston = new JLabel("");
		lblPrecioBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioBaston.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioBaston.setForeground(Color.ORANGE);
		lblPrecioBaston.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioBaston.setBounds(697, 361, 200, 54);
		tienda.getContentPane().add(lblPrecioBaston);

		JLabel lblGratis = new JLabel("");
		lblGratis.setBackground(Color.BLUE);
		lblGratis.setHorizontalAlignment(SwingConstants.CENTER);
		lblGratis.setForeground(Color.ORANGE);
		lblGratis.setFont(new Font("Myriad Pro Light", Font.PLAIN, 25));
		lblGratis.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblGratis.setBounds(367, 361, 200, 54);
		tienda.getContentPane().add(lblGratis);

		JLabel lblOrogorn = new JLabel("LEGOLOS");
		lblOrogorn.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrogorn.setForeground(Color.ORANGE);
		lblOrogorn.setFont(new Font("Myriad Pro Light", Font.PLAIN, 25));
		lblOrogorn.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblOrogorn.setBounds(43, 112, 200, 54);
		tienda.getContentPane().add(lblOrogorn);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			//metodo para equiparte con el peronaje indicado(si esque no lo tienes equipado.
			public void actionPerformed(ActionEvent e) {

					if (user.getEleccion() == 1) {
						JOptionPane.showMessageDialog(null, "Ya lo tenias previamente seleccionado");
					} else {
						JOptionPane.showMessageDialog(null, "Te has equipado con Orogorn!!");
						user.setEleccion(1);
					}

			}
		});
		button.setIcon(new ImageIcon(getClass().getResource("/Recursos/dagas.png")));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		button.setBounds(367, 162, 200, 200);
		tienda.getContentPane().add(button);

		lblOrogorn_1 = new JLabel("OROGORN");
		lblOrogorn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrogorn_1.setForeground(Color.ORANGE);
		lblOrogorn_1.setFont(new Font("Myriad Pro Light", Font.PLAIN, 25));
		lblOrogorn_1.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblOrogorn_1.setBounds(367, 112, 200, 54);
		tienda.getContentPane().add(lblOrogorn_1);

		lblGondolf = new JLabel("GONDOLF");
		lblGondolf.setHorizontalAlignment(SwingConstants.CENTER);
		lblGondolf.setForeground(Color.ORANGE);
		lblGondolf.setFont(new Font("Myriad Pro Light", Font.PLAIN, 25));
		lblGondolf.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblGondolf.setBounds(697, 112, 200, 54);
		tienda.getContentPane().add(lblGondolf);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(42, 111, 200, 55);
		tienda.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(367, 112, 200, 55);
		tienda.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(697, 112, 200, 55);
		tienda.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(43, 361, 200, 55);
		tienda.getContentPane().add(panel_3);

		panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(367, 361, 200, 55);
		tienda.getContentPane().add(panel_4);

		panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(697, 361, 200, 55);
		tienda.getContentPane().add(panel_5);

		panel_7 = new JPanel();
		panel_7.setBackground(new Color(184, 134, 11));
		panel_7.setForeground(Color.BLACK);
		panel_7.setBounds(257, 13, 405, 73);
		tienda.getContentPane().add(panel_7);

		lblVolverMenu = new JLabel("Volver Menu");
		lblVolverMenu.setFont(new Font("Myriad Pro Light", Font.PLAIN, 21));
		lblVolverMenu.setForeground(Color.RED);
		lblVolverMenu.setBounds(833, 507, 149, 33);
		tienda.getContentPane().add(lblVolverMenu);
		ImageIcon fot = new ImageIcon(getClass().getResource("/Recursos/masmonedas.png"));
		this.repaint();
		//fondo
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(getClass().getResource("/Recursos/tienday.jpg")));
		background.setBounds(0, 0, 994, 565);
		tienda.getContentPane().add(background);

	}
	//metodo para conseguir las moedas del usuario
	private int getMonedas() {
		try {
			return user.monedas;
		}

		catch (Exception except) {
			return 0;
		}
	}

}