package Registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 200, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		frame.setResizable(false);// Para no maximizar la pantalla,siempre el
									// mismo tamaño
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		JLabel lblImagenPantallaDe = new JLabel("IMAGEN PANTALLA DE LOGIN");
		panel.add(lblImagenPantallaDe);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setForeground(new Color(224, 255, 255));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(37, 59, 56, 16);
		panel_2.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(37, 105, 86, 16);
		panel_2.add(lblContrasea);

		textField = new JTextField();
		textField.setBounds(172, 56, 116, 22);
		panel_2.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(172, 102, 116, 22);
		panel_2.add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(172, 150, 116, 25);
		panel_2.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new VentanaRegistro();
				frame.dispose();

			}
		});
		btnRegistrarse.setBounds(140, 110, 116, 25);
		panel_3.add(btnRegistrarse);

		JLabel lblNoTienesCuenta = new JLabel("No tienes cuenta de (nombre del juego)??Registrate gratis!!");
		lblNoTienesCuenta.setBounds(31, 51, 348, 46);
		panel_3.add(lblNoTienesCuenta);
	}
}
