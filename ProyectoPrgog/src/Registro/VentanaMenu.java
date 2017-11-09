package grafica;

import javax.swing.*;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame{
	private JButton btnTienda;
	private JButton btnJugar;
	private JButton btnSalir;
	private JLabel background;
	
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		this.setSize(768, 453);
		getContentPane().setBounds(new Rectangle(0, 0, 768, 453));
		
		btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTienda tienda = new VentanaTienda();
				tienda.setVisible(true);
				//menu.setVisible(false);		
			}
		});
		
		btnJugar.setFont(new Font("Old English Text MT", Font.PLAIN, 60));
		btnJugar.setBounds(181, 112, 400, 117);
		getContentPane().add(btnJugar);
		
		btnTienda = new JButton("Tienda");
		btnTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTienda.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
		btnTienda.setBounds(253, 261, 259, 60);
		getContentPane().add(btnTienda);
		
		btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon("C:\\Users\\pili\\workspace\\Nuevo Juego\\bin\\fotos\\Flecha.png"));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(677, 384, 85, 41);
		getContentPane().add(btnSalir);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\pili\\workspace\\Nuevo Juego\\bin\\fotos\\Luna.jpg"));
		background.setBounds(0, 0, 762, 425);
		getContentPane().add(background);

	
		
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
  }

public static void main(String[] args) {
	VentanaMenu menu = new VentanaMenu();
	menu.setVisible(true);
}
}
	
