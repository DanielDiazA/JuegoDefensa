package Registro;

import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame {
	private JButton btnTienda;
	private JButton btnJugar;
	private JButton btnSalir;
	private JLabel background;
	private JFrame menu;

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
		menu = new JFrame();
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setResizable(false);
		menu.setLayout(null);
		menu.setSize(768, 453);
		menu.setBounds(new Rectangle(0, 0, 768, 453));

		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 menu.setVisible(false);
				Main m= new Main();
				
			}
		});

		btnJugar.setFont(new Font("Old English Text MT", Font.PLAIN, 60));
		btnJugar.setBounds(181, 112, 400, 117);
		menu.add(btnJugar);

		btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTienda.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
		btnTienda.setBounds(253, 261, 259, 60);
		menu.add(btnTienda);

		btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon("/Recursos/ejercitoH.jpg"));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(677, 384, 85, 41);
		menu.add(btnSalir);

		background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\Dani\\Desktop\\Recursos\\Luna.jpg"));
		background.setBounds(0, 0, 762, 425);
		menu.add(background);

		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u = new Usuario();
				VentanaTienda tienda = new VentanaTienda(u);
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
