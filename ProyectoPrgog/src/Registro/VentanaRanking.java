/**
 * Ventana en la que aparece el ranking de puntuaciones
 * @author Jonathan Blazquez y Daniel Diaz
 * @version 1.0
 */



package Registro;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class VentanaRanking extends JFrame{
	private JFrame ranking;
	private JTable tabla;
	private String[] ColumnNames = {"Nick", "Score"};
	private String[][] data;
	private static Usuario user;
	private static Inventario invent;
	
	
	
	public static ArrayList<Rank> puntuaciones = new ArrayList<Rank>();//donde se guardan las puntuaciones
	public VentanaRanking(Usuario u, Inventario i) {
		this.user = u;
		this.invent = i;
		getContentPane().setLayout(null);
		Initialize();
	}
	/**
	 * metodo para añadir una nueva puntuacion al ranking
	 * @param r
	 */
	public static void añadirRank(Rank r) {

		puntuaciones.add(r);

	}
	
	
	
	
	
	public void Initialize(){
		//musica de fondo
		AudioClip musicafondo;
		musicafondo = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/musicaRanking.wav"));
		musicafondo.play();
		//usica volver a la ventana anterior
		AudioClip atras;
		atras = java.applet.Applet.newAudioClip(getClass().getResource("/Recursos/atras.wav"));
		
		
		ranking = new JFrame();
		ranking.setBounds(400, 200, 1000, 600);
		ranking.setVisible(true);
		ranking.setResizable(false);
		ranking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JList
		JList lista=new JList();
		lista.setBounds(220, 73, 546, 356);
		DefaultListModel listModel = new DefaultListModel();
		
		for(int i=0; i<puntuaciones.size(); i++) {
			Rank r = puntuaciones.get(i);
		    listModel.addElement(r.getNick()+ "	---------------------------------------------------------"+r.getMuertes()+"--------------------------------------------------"+r.getPuntuacion());
		}
		ranking.getContentPane().setLayout(null);
		
		
//		Rank r = new Rank("DANIEL",30000000,400000);
//		listModel.addElement(r.getNick()+"                                                           "+r.getMuertes()+"                                                 "+r.getPuntuacion());
		
		lista.setModel(listModel); 
		ranking.getContentPane().add(lista);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new LineBorder(new Color(0, 0, 0))));
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(220, 27, 548, 45);
		ranking.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNombre = new JLabel("      Nombre");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBackground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Myriad Pro Light", Font.PLAIN, 20));
		panel.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("       Muertes");
		lblNewLabel.setFont(new Font("Myriad Pro Light", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("            Puntuaci\u00F3n");
		lblNewLabel_1.setFont(new Font("Myriad Pro Light", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		JButton btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenu menu = new VentanaMenu(user, invent);
				ranking.dispose();
				
				///music
				musicafondo.stop();
				
				
			}
		});
		btnSalir.setIcon(new ImageIcon(getClass().getResource("/Recursos/Flecha.png")));
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(new Rectangle(1160, 685, 100, 75));
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(834, 455, 133, 78);
		ranking.getContentPane().add(btnSalir); 
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setForeground(new Color(0, 255, 255));
		lblRanking.setFont(new Font("Arial Black", Font.BOLD, 52));
		lblRanking.setBounds(353, 442, 546, 91);
		ranking.getContentPane().add(lblRanking);
		
		//Para que parpadeee ranking
		class parpadeo extends Thread
		{
		   public void run()
		   {
			   while (true) {
				   lblRanking.setVisible(true);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lblRanking.setVisible(false);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		   } 
		}
		
		parpadeo p = new parpadeo();
		p.start();
		
		JLabel background = new JLabel("");
		background.setForeground(new Color(0, 255, 255));
		background.setIcon(new ImageIcon(getClass().getResource("/Recursos/fondom.jpg")));
		background.setBounds(0, 0, 1000, 565);
		ranking.getContentPane().add(background); 
		
//		String[] arrayNick = BD.selectRankingNick();
//		String[] arrayPuntuacion = BD.selectRankingPuntuacion();
//		data = new String[10][2];
//		int i = 0;
//		while (i < 10){
//			data[i][0] = arrayNick[i];
//			data[i][1] = arrayPuntuacion[i];
//			i++;
//		}
//		tabla = new JTable(data, ColumnNames);
//		tabla.setBounds((ranking.getWidth()-60)/2, (ranking.getHeight()-110)/2, 60, 110);
//		ranking.getContentPane().add(tabla);
	
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRanking window = new VentanaRanking(user, invent);
					window.ranking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}