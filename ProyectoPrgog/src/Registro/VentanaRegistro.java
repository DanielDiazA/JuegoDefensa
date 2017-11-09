package Registro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;

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
	public JTextField textField_4;
	public JTextField textField_5;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public VentanaRegistro() {

		frmRegistroUsuario = new JFrame();
		frmRegistroUsuario.setType(Type.POPUP);
		frmRegistroUsuario.setTitle("Registro Usuario");
		frmRegistroUsuario.setForeground(Color.ORANGE);
		frmRegistroUsuario.setBounds(500, 200, 800, 500);
		frmRegistroUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroUsuario.getContentPane().setLayout(new GridLayout(7, 0, 0, 0));
		frmRegistroUsuario.setResizable(false);// Para no maximizar la
												// pantalla,siempre el mismo
												// tamaño
		JPanel panel = new JPanel();
		frmRegistroUsuario.setVisible(true);
		frmRegistroUsuario.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblNombre.setBounds(45, 13, 173, 40);
		panel.add(lblNombre);
		textField_1 = new JTextField();
		
		textField = new JTextField();
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String nombre = textField.getText();
				nombre = nombre.toUpperCase();
				for (int i = 0; i < nombre.length(); i++) {
					if (nombre.charAt(i) < 'A' || nombre.charAt(i) > 'Z') {
						JOptionPane.showMessageDialog(frmRegistroUsuario, "Caracteres no permitidos");
						textField.setText(textField.getText().substring(0, textField.getText().length() - 1));

					} else {

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

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(280, 14, 452, 35);
		panel_4.add(textField_4);

		JPanel panel_5 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a");
		lblRepetirContrasea.setFont(new Font("Bauhaus 93", Font.PLAIN, 26));
		lblRepetirContrasea.setBounds(45, 23, 237, 25);
		panel_5.add(lblRepetirContrasea);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(280, 13, 452, 35);
		panel_5.add(textField_5);

		JPanel panel_6 = new JPanel();
		frmRegistroUsuario.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()
						||textField_4.getText().isEmpty()||textField_5.getText().isEmpty()){
					JOptionPane.showMessageDialog(frmRegistroUsuario, "Tienes que rellenar todos los espacios");			
					
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
				new VentanaPrincipal();
				frmRegistroUsuario.dispose();

			}
		});
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Snap ITC", Font.PLAIN, 26));
		btnCancelar.setBounds(514, 13, 209, 40);
		panel_6.add(btnCancelar);
	}

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

}
