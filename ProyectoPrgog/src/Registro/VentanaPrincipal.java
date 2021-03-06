/**
 * Ventana del login desde la cual puedes logearte o dirigirte a la ventana de registro si no tienes usuario
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */


package Registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.applet.*;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public static Usuario user;
	public static Inventario invent;

	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();//donde guardamos los users
/**
 * Metodo para a�adir un suario al ArrayList usuarios
 * @param u
 */
	public static void a�adirUser(Usuario u) {

		usuarios.add(u);

	}

	public VentanaPrincipal(Usuario u, Inventario i) {
		this.user = u;
		this.invent = i;
		initialize();
	}

	private void initialize() {
		
		//Musica de fondo
		AudioClip musicafondo;
		musicafondo = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/LOTR.wav"));
		musicafondo.play();
		//sonido al clickar
		AudioClip click;
		click = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/click.wav"));
		
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/icono.png")));
		frame.setBounds(500, 200, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		frame.setResizable(false);// Para no maximizar la pantalla,siempre el
									// mismo tama�o

		frame.setVisible(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBackground(new Color(173, 216, 230));
		panel.setLayout(null);

		JLabel lblPantalla = new JLabel("pantalla");
		lblPantalla.setIcon(new ImageIcon(getClass().getResource("/Recursos/pantallap.png")));
		lblPantalla.setBounds(0, 0, 794, 232);
		panel.add(lblPantalla);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 51, 102));
		panel_2.setForeground(new Color(224, 255, 255));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblUsuario.setBounds(12, 47, 148, 45);
		panel_2.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblContrasea.setBounds(12, 105, 148, 39);
		panel_2.add(lblContrasea);

		textField = new JTextField();
		textField.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		textField.setBounds(153, 47, 232, 42);
		panel_2.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		passwordField.setBounds(153, 102, 232, 42);
		panel_2.add(passwordField);

		JLabel lblLogin = new JLabel("");
		lblLogin.addMouseListener(new MouseAdapter() {
//Comprobamos que el user y la contrase�a son correctas , podemos oguearnos como admins
			public void mouseClicked(MouseEvent e) {
				click.play();
				// String pass = passwordField.getPassword().toString();
				// String contra = BD.selectPass(textField.getText());

				if (textField.getText().isEmpty() || passwordField.getPassword().toString().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Algun campo esta sin rellenar");
				} else {
					char[] pass1 = passwordField.getPassword();
					String passString = new String(pass1);
					if (passString.equals("admin") && textField.getText().equals("admin")) {
						// Usuario user =
						// BD.selectUsuario(textField.getText());
						Usuario usuario = new Usuario("admin", "admin", 66, "admin", 99999, "admin", 1);
						Inventario inventario = new Inventario(usuario.nick, 0, 0, 0);
						new VentanaMenu(usuario, inventario);

						frame.setVisible(false);
						
						musicafondo.stop();

					} else {
						if(usuarios.size()>0){
						for (int i = 0; i < usuarios.size(); i++) {
							
							if (usuarios.get(i).nombre.equals(textField.getText())
									&& usuarios.get(i).contrase�a.equals(passString)) {
								Inventario inv = new Inventario();
								new VentanaMenu(usuarios.get(i), inv);
								musicafondo.stop();
								frame.setVisible(false);
								
							} else {
								JOptionPane.showMessageDialog(frame, "Usuario y/o contrase�a no son correctos");
								}
							}	
							}else{JOptionPane.showMessageDialog(frame, "No hay Usuarios creados");
						}
					}
				}
			}

		});

		lblLogin.setIcon(new ImageIcon(getClass().getResource("/Recursos/login.png")));
		lblLogin.setBounds(149, 145, 256, 74);
		panel_2.add(lblLogin);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 51, 102));
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				click.play();
				musicafondo.stop();

				new VentanaRegistro();
				frame.dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Recursos/registrate.png")));
		lblNewLabel.setBounds(12, 68, 361, 83);
		panel_3.add(lblNewLabel);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal(user, invent);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}