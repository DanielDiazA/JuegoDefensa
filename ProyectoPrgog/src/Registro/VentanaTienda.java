package Registro;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class VentanaTienda extends JFrame {

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
					Usuario u = new Usuario();
					VentanaTienda window = new VentanaTienda(u);
					window.tienda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaTienda(Usuario u) {
		AudioClip click;
		click=java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/click.wav"));
		tienda = new JFrame();
		tienda.getContentPane().setBackground(Color.BLACK);
		tienda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tienda.setBounds(500,200,768, 530);
		tienda.getContentPane().setLayout(null);
		tienda.setVisible(true);
		tienda.setResizable(false);
		tienda.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dani\\Desktop\\icono.png"));
		labelDinero = new JLabel("Monedas: ");
		labelDinero.setForeground(Color.ORANGE);
		labelDinero.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 14));
		labelDinero.setBounds(585, 0, 172, 40);
		tienda.getContentPane().add(labelDinero);

		iconoMonedas = new JLabel("");
		iconoMonedas.setIcon(new ImageIcon("C:\\Users\\Dani\\Desktop\\Recursos\\MonedaOro.png"));
		iconoMonedas.setBounds(710, 0, 40, 40);
		tienda.getContentPane().add(iconoMonedas);

		JButton btnNewButton = new JButton("Equipar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				click.play();
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(43, 406, 200, 40);
		tienda.getContentPane().add(btnNewButton);

		JButton btnEquipar = new JButton("Equipar");
		btnEquipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click.play();
			}
		});
		btnEquipar.setEnabled(false);
		btnEquipar.setBounds(511, 406, 200, 40);
		tienda.getContentPane().add(btnEquipar);

		btnCompraArco = new JButton("");

		btnCompraArco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click.play();
				if (u.getDinero() >= 1000) {
					u.setDinero(u.getDinero() - 1000);

					JOptionPane.showMessageDialog(tienda, "Compra exitosa ");
					btnNewButton.setEnabled(true);
					labelDinero.setText("Monedas:" + u.getDinero());
				}

				else {
					JOptionPane.showMessageDialog(tienda, "No tenes suficientes monedas");
				}
			}
		});

		btnCompraArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraArco
				.setIcon(new ImageIcon("C:\\Users\\Dani\\Desktop\\Recursos\\Arquero.png"));
		btnCompraArco.setContentAreaFilled(false);
		btnCompraArco.setOpaque(false);
		btnCompraArco.setBounds(43, 123, 200, 200);
		tienda.getContentPane().add(btnCompraArco);

		btnCompraBaston = new JButton("");
		btnCompraBaston.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click.play();
				if (u.getDinero() >= 5000) {
					u.setDinero(u.getDinero() - 5000);

					JOptionPane.showMessageDialog(tienda, "Compra exitosa ");
					btnEquipar.setEnabled(true);
					labelDinero.setText("Monedas:" + u.getDinero());
				}

				else {
					JOptionPane.showMessageDialog(tienda, "No tenes suficientes monedas");
				}

			}
		});
		btnCompraBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		btnCompraBaston.setIcon(
				new ImageIcon("C:\\Users\\Dani\\Desktop\\Recursos\\Hechicero.png"));
		btnCompraBaston.setContentAreaFilled(false);
		btnCompraBaston.setOpaque(false);
		btnCompraBaston.setBounds(511, 123, 200, 200);
		tienda.getContentPane().add(btnCompraBaston);

		btnMonedas = new JButton("\u00A1Monedas!");
		btnMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click.play();
				u.setDinero(u.getDinero() + 100);
				labelDinero.setText("Monedas:" + u.getDinero());

			}
		});
		btnMonedas.setFont(new Font("Old English Text MT", Font.PLAIN, 35));
		btnMonedas.setBounds(266, 192, 224, 90);
		tienda.getContentPane().add(btnMonedas);

		btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click.play();
				VentanaMenu menu = new VentanaMenu();
				tienda.dispose();

			}
		});
		btnSalir.setIcon(new ImageIcon("C:\\Users\\Dani\\Desktop\\Recursos\\Flecha.png"));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(24, 23, 77, 33);
		tienda.getContentPane().add(btnSalir);

		lblTienda = new JLabel("TIENDA");
		lblTienda.setBorder(new LineBorder(new Color(204, 153, 51), 5, true));
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setForeground(new Color(0, 0, 0));
		lblTienda.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		lblTienda.setBounds(177, 13, 405, 73);
		tienda.getContentPane().add(lblTienda);

		lblPrecioArco = new JLabel("Monedas: 1000");
		lblPrecioArco.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioArco.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioArco.setForeground(Color.ORANGE);
		lblPrecioArco.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioArco.setBounds(43, 322, 200, 54);
		tienda.getContentPane().add(lblPrecioArco);

		lblPrecioBaston = new JLabel("Monedas: 5000");
		lblPrecioBaston.setBorder(new LineBorder(new Color(204, 153, 51), 3, true));
		lblPrecioBaston.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioBaston.setForeground(Color.ORANGE);
		lblPrecioBaston.setFont(new Font("Old English Text MT", Font.PLAIN, 25));
		lblPrecioBaston.setBounds(511, 322, 200, 54);
		tienda.getContentPane().add(lblPrecioBaston);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\Dani\\Desktop\\Recursos\\Luna.jpg"));
		background.setBounds(0, 0, 752, 415);
		
		tienda.getContentPane().add(background);

	}
}
