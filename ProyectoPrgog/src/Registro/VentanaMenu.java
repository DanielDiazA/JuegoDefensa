/**
 * Ventana del menu principal donde elegis que hacer entre las diferentes opciones.
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */
package Registro;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Modelos.Coordenada;
import Modelos.NaveGrafica;
import Modelos.PanelFG;
import Modelos.RectanguloGrafico;
import Modelos.TextoGrafico;
import Modelos.Ventana;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;

public class VentanaMenu extends JFrame {
	private JButton btnTienda;
	private JButton btnJugar;
	private JButton btnSalir;
	private JButton btnvol;
	private JFrame menu;
	private JButton btnRanking;
	private JLabel lblNewLabel;
	private JButton button;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private static Usuario user;
	private static Inventario invent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu(user, invent);
					window.menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaMenu(Usuario u, Inventario i) {
		this.user = u;
		this.invent = i;
		Initialize();
	}

	public void Initialize() {
		//musica fondo
		AudioClip musicafondo;
		musicafondo = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/menu.wav"));
		musicafondo.play();
		//sonido siguiente ventana
		AudioClip pasarventana;
		pasarventana = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/pasarventana.wav"));
		
		//sonido volver a la ventana anterior
		AudioClip atras;
		atras = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/atras.wav"));

		menu = new JFrame();
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setResizable(false);
		menu.getContentPane().setLayout(null);
		menu.setBounds(400, 200, 1000, 600);

		btnJugar = new JButton("Jugar");
		btnJugar.setBackground(UIManager.getColor("Button.shadow"));
		btnJugar.setForeground(new Color(255, 153, 153));
		btnJugar.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 60));
		btnJugar.setBounds(311, 29, 400, 117);

		btnJugar.setOpaque(false);
		btnJugar.setContentAreaFilled(false);
		btnJugar.setBorder(null);

		menu.getContentPane().add(btnJugar);

		btnTienda = new JButton("Tienda");
		btnTienda.setBackground(new Color(0, 0, 0));
		btnTienda.setForeground(new Color(255, 153, 153));
		btnTienda.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 60));
		btnTienda.setBounds(298, 159, 376, 116);
		btnTienda.setContentAreaFilled(false);
		btnTienda.setBorder(new EmptyBorder(0, 0, 0, 0));

		menu.getContentPane().add(btnTienda);

		btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon(getClass().getResource("/Recursos/Flecha.png")));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(836, 488, 85, 41);
		menu.getContentPane().add(btnSalir);

		btnRanking = new JButton("Ranking");
		btnRanking.setForeground(new Color(255, 153, 153));
		btnRanking.addActionListener(new ActionListener() {
			//dirigirte ventana ranking
			public void actionPerformed(ActionEvent e) {
				musicafondo.stop();
				pasarventana.play();
				
				VentanaRanking ranking = new VentanaRanking(user, invent);
				menu.setVisible(false);;
			}
		});
		btnRanking.setBackground(new Color(240, 240, 240));
		btnRanking.setOpaque(false);
		btnRanking.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 60));
		btnRanking.setContentAreaFilled(false);
		btnRanking.setBorder(null);
		btnRanking.setBounds(298, 282, 400, 117);
		menu.getContentPane().add(btnRanking);

		btnTienda.addActionListener(new ActionListener() {
			//Dirigirte ventana tienda
			public void actionPerformed(ActionEvent arg0) {
				musicafondo.stop();
				pasarventana.play();
				VentanaTienda tienda = new VentanaTienda(user, invent);
				menu.setVisible(false);
			}

		});

		class MiHilo extends Thread
		{
		   public void run()
		   {
			   Juego j= new Juego(user, invent);
		   } 
		};
		
		
		
		btnJugar.addActionListener(new ActionListener() {
			//dirigirte al juego
			public void actionPerformed(ActionEvent e) {

				
				MiHilo elHilo = new MiHilo();
				elHilo.start();
				
				pasarventana.play();
				menu.setVisible(false);
				musicafondo.stop();
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VentanaPrincipal vp = new VentanaPrincipal(new Usuario(), new Inventario());
				menu.setVisible(false);
				musicafondo.stop();
				atras.play();
				
				
			}
		});

		// musica ON
		
		JButton lblNewLabel_1 = new JButton("");
		JButton lblNewLabel_2 = new JButton("");
		lblNewLabel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				musicafondo.stop();
				lblNewLabel_2.setVisible(true);
				lblNewLabel_2.setEnabled(true);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1.setEnabled(false);
			}
		});

		lblNewLabel_1.setOpaque(false);
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 60));
		lblNewLabel_1.setContentAreaFilled(false);
		lblNewLabel_1.setBorder(null);

		lblNewLabel_1.setBounds(36, 464, 77, 53);

		ImageIcon fot = new ImageIcon(getClass().getResource("/Recursos/von.png"));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),
				Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(icono);
		this.repaint();
		menu.getContentPane().add(lblNewLabel_1);

		// musica OFF
		lblNewLabel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				musicafondo.play();
			
				lblNewLabel_1.setVisible(true);
				lblNewLabel_1.setEnabled(true);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_2.setEnabled(false);

			}
		});

		lblNewLabel_2.setOpaque(false);
		lblNewLabel_2.setFont(new Font("Bauhaus 93", Font.PLAIN, 60));
		lblNewLabel_2.setContentAreaFilled(false);
		lblNewLabel_2.setBorder(null);

		lblNewLabel_2.setBounds(36, 464, 77, 53);

		ImageIcon fot5 = new ImageIcon(getClass().getResource("/Recursos/voff.png"));
		Icon icono5 = new ImageIcon(fot5.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
				lblNewLabel_2.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel_2.setIcon(icono5);
		this.repaint();
		menu.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_2.setVisible(false);
		
		
		JLabel lbl1 = new JLabel("");
		lbl1.setBounds(298, 159, 376, 117);
		ImageIcon fot2 = new ImageIcon(getClass().getResource("/Recursos/sword1.png"));
		Icon icono2 = new ImageIcon(
				fot2.getImage().getScaledInstance(lbl1.getWidth(), lbl1.getHeight(), Image.SCALE_DEFAULT));
		lbl1.setIcon(icono2);
		this.repaint();
		
		JButton button_1 = new JButton("Personaje");
		button_1.setForeground(new Color(255, 153, 153));
		button_1.addActionListener(new ActionListener() {
			//Dirigirte ventana character
			public void actionPerformed(ActionEvent e) {
				
				VentanaCharacter vc=new VentanaCharacter(user, invent);
				menu.setVisible(false);;
				musicafondo.stop();
				
				
			}
		});
		button_1.setOpaque(false);
		button_1.setFont(new Font("Sitka Heading", Font.BOLD | Font.ITALIC, 60));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBackground(SystemColor.menu);
		button_1.setBounds(311, 412, 400, 117);
		menu.getContentPane().add(button_1);
		menu.getContentPane().add(lbl1);

		JLabel lbl2 = new JLabel("");
		lbl2.setBounds(298, 288, 376, 116);
		ImageIcon fot3 = new ImageIcon(getClass().getResource("/Recursos/sword1.png"));
		Icon icono3 = new ImageIcon(
				fot3.getImage().getScaledInstance(lbl2.getWidth(), lbl2.getHeight(), Image.SCALE_DEFAULT));
		lbl2.setIcon(icono3);
		this.repaint();
		menu.getContentPane().add(lbl2);

		JLabel lbl3 = new JLabel("");
		lbl3.setBounds(298, 29, 389, 116);
		ImageIcon fot4 = new ImageIcon(getClass().getResource("/Recursos/sword1.png"));
		Icon icono4 = new ImageIcon(fot4.getImage().getScaledInstance(lbl3.getWidth(), lbl3.getHeight(), Image.SCALE_DEFAULT));
		lbl3.setIcon(icono4);
		this.repaint();
		menu.getContentPane().add(lbl3);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(287, 413, 398, 116);
		ImageIcon fot7 = new ImageIcon(getClass().getResource("/Recursos/sword1.png"));
		Icon icono7 = new ImageIcon(
				fot7.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_DEFAULT));
		label_2.setIcon(icono7);
		this.repaint();
		
		
		menu.getContentPane().add(label_2);

		
		//fondo
		 JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(getClass().getResource("/Recursos/fondom.jpg")));
		background.setBounds(0, 0, 994, 565);
		menu.getContentPane().add(background); 
		 
		

	}
}