package Registro;

import java.awt.EventQueue;

import javax.swing.*;

public class VentanaRanking extends JFrame{
	private JFrame ranking;
	private JTable tabla;
	private String[] ColumnNames = {"Nick", "Score"};
	private String[][] data;
	private static Usuario user;
	private static Inventario invent;
	
	public VentanaRanking(Usuario u, Inventario i) {
		this.user = u;
		this.invent = i;
		Initialize();
	}
	
	public void Initialize(){
		ranking = new JFrame();
		ranking.setBounds(400, 200, 1000, 600);
		ranking.setResizable(false);
		ranking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] arrayNick = BD.selectRankingNick();
		String[] arrayPuntuacion = BD.selectRankingPuntuacion();
		data = new String[10][2];
		int i = 0;
		while (i < 10){
			data[i][0] = arrayNick[i];
			data[i][1] = arrayPuntuacion[i];
			i++;
		}
		tabla = new JTable(data, ColumnNames);
		tabla.setBounds((ranking.getWidth()-60)/2, (ranking.getHeight()-110)/2, 60, 110);
		ranking.getContentPane().add(tabla);
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
