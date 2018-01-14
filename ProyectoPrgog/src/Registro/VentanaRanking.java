package Registro;

import java.awt.EventQueue;

import javax.swing.*;

public class VentanaRanking extends JFrame{
	private JFrame ranking;
	private JTable tabla;
	private String[] ColumnNames = {"Nick", "Score"};
	
	public VentanaRanking() {
		Initialize();
	}
	
	public void Initialize(){
		ranking.setBounds(400, 200, 1000, 600);
		ranking.setResizable(false);
		ranking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] arrayNick = BD.selectRankingNick();
		String[] arrayPuntuacion = BD.selectRankingPuntuacion();
		Object[][] data = new Object[arrayNick.length][2];
		int i = 0;
		while (i < arrayNick.length){
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
					VentanaRanking window = new VentanaRanking();
					window.ranking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
