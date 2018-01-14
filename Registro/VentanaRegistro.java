package Registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frmRegistroUsuario;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
					window.frmRegistroUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistro() {
		
		frmRegistroUsuario = new JFrame();
		frmRegistroUsuario.setType(Type.POPUP);
		frmRegistroUsuario.setTitle("Registro Usuario");
		frmRegistroUsuario.setForeground(Color.ORANGE);
		frmRegistroUsuario.setBounds(500, 200, 800, 500);
		frmRegistroUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Dani\\Desktop\\icono.png"));
		frmRegistroUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroUsuario.getContentPane().setLayout(new GridLayout(7, 0, 0, 0));
		frmRegistroUsuario.setResizable(false);// Para no maximizar la
												// pantalla,siempre el mismo
												// tamaño
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		frmRegistroUsuario.setVisible(true);
		frmRegistroUsuario.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblNombre.setBounds(45, 13, 173, 40);
		panel.add(lblNombre);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				
				String nombre = textField_1.getText();
				nombre = nombre.toUpperCase();
				for (int i = 0; i < nombre.length(); i++) {
					if (nombre.charAt(i) < 'A' || nombre.charAt(i) > 'Z') {
						JOptionPane.showMessageDialog(frmRegistroUsuario, "Caracteres no permitidos");
						textField_1.setText(textField_1.getText().substring(0, textField_1.getText().length() - 1));

					}
				}

			}
		});
		textField_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));

		textField = new JTextField();
		textField.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));

		textField.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent arg0) {
				String nombre = textField.getText();
				nombre = nombre.toUpperCase();
				for (int i = 0; i < nombre.length(); i++) {
					if (nombre.charAt(i) < 'A' || nombre.charAt(i) > 'Z') {
						JOptionPane.showMessageDialog(frmRegistroUsuario, "Caracteres no permitidos");
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
						//u.setNombre(nombre);
					}
				}

			}
		});
		textField.setBounds(280, 13, 452, 35);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblApellidos = new JLabel("Apellido");
		lblApellidos.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblApellidos.setBounds(45, 13, 107, 40);
		panel_1.add(lblApellidos);

		textField_1.setEditable(true);

		textField_1.setColumns(10);
		textField_1.setBounds(280, 13, 452, 35);
		panel_1.add(textField_1);

		JPanel panel_2 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Edad");
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblNewLabel.setBounds(45, 23, 114, 16);
		panel_2.add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
			int	k = Integer.parseInt(textField_2.getText()); 
			

				for (int i = 0; i < textField_2.getText().length(); i++) {
					if (Character.isDigit(textField_2.getText().charAt(i)) == false) {
						JOptionPane.showMessageDialog(frmRegistroUsuario, "Caracteres no permitidos");
						textField_2.setText(textField_2.getText().substring(0, textField_2.getText().length() - 1));
					} else {
					if (k>100||k<0) {
						JOptionPane.showMessageDialog(frmRegistroUsuario, "La edad solo puede estar entre 0 y 100 años");
							textField_2.setText(textField_2.getText().substring(0, textField_2.getText().length() - 1));
						}
					}

				}
			}
		});
		textField_2.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		textField_2.setColumns(10);
		textField_2.setBounds(280, 13, 452, 35);
		panel_2.add(textField_2);

		JPanel panel_3 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nick");
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(45, 21, 56, 16);
		panel_3.add(lblNewLabel_1);

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		textField_3.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		textField_3.setColumns(10);
		textField_3.setBounds(280, 14, 452, 35);
		panel_3.add(textField_3);
		
		JPanel panel_4 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblContrasea.setBounds(45, 21, 176, 16);
		panel_4.add(lblContrasea);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(283, 13, 451, 35);
		panel_4.add(passwordField_1);

		JPanel panel_5 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a");
		lblRepetirContrasea.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblRepetirContrasea.setBounds(45, 23, 237, 25);
		panel_5.add(lblRepetirContrasea);

		passwordField = new JPasswordField();
		passwordField.setBounds(283, 13, 451, 35);
		panel_5.add(passwordField);

		JPanel panel_6 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass = passwordField.getPassword().toString();
				String pass2 = passwordField_1.getPassword().toString();

				if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty()
						|| textField_3.getText().isEmpty() || passwordField_1.getPassword().toString().isEmpty()
						|| passwordField.getPassword().toString().isEmpty()) {
					JOptionPane.showMessageDialog(frmRegistroUsuario, "Tienes que rellenar todos los espacios");

				} else {
					if (pass2.equals(pass)) {
						String str = textField_2.getText();
						Usuario user = new Usuario(textField.getText(),textField_1.getText(),Integer.parseInt(str),passwordField_1.getPassword().toString(),0,textField_3.getText(),1);
						Inventario invent = new Inventario(user);
						
						BD.insertarUsuario(user);
						BD.insertarInventario(invent);
						
						
						//Guardar datos del Usuario
//						u.setNombre(textField.getText());
//						u.setEdad(Integer.parseInt(textField_2.getText()));
//						u.setDinero(0);
//						u.setApellido(textField_1.getText());
//						u.setNick(textField_3.getText());
//						u.setContraseña(pass);
						new VentanaPrincipal(user, invent);
						frmRegistroUsuario.setVisible(false);;
					} else {
						JOptionPane.showMessageDialog(frmRegistroUsuario, "Verifica que las contraseñas son iguales");
					}
				}
			}
		});
		btnRegistrarse.setBackground(new Color(154, 205, 50));
		btnRegistrarse.setForeground(new Color(0, 0, 0));
		btnRegistrarse.setFont(new Font("Snap ITC", Font.PLAIN, 26));
		btnRegistrarse.setBounds(126, 13, 258, 40);
		panel_6.add(btnRegistrarse);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario u = new Usuario();
				Inventario i = new Inventario();
				new VentanaPrincipal(u, i);
				frmRegistroUsuario.dispose();

			}
		});
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Snap ITC", Font.PLAIN, 26));
		btnCancelar.setBounds(514, 13, 209, 40);
		panel_6.add(btnCancelar);
		
		panel.setBackground(Color.PINK);
		panel_1.setBackground(Color.PINK);
		panel_2.setBackground(Color.PINK);
		panel_3.setBackground(Color.PINK);
		panel_4.setBackground(Color.PINK);
		panel_5.setBackground(Color.PINK);
		panel_6.setBackground(Color.PINK);
	
	}
}