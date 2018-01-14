package Registro;

import java.sql.*;


public class BD {
	private static Connection con;
	private static Statement stat;
	private static ResultSet rs;
	
	public static void main(String[] args){
		String sql = "";
		try{
			Class.forName("orgs.sqlit.JDBC");	
			con = DriverManager.getConnection("jdbc:sqlite:test.db");
			stat = con.createStatement();
			
			try{
				sql = "Create table USUARIO("
						+ "NICK String,"
						+ "PASSWORD String,"
						+ "NOMBRE String,"
						+ "APELLIDOS String,"
						+ "EDAD int,"
						+ "MONEDAS int"
						+ ")";
				stat.executeUpdate(sql);
				
				sql = "Create table INVENTARIO("
						+ "NICK String,"
						+ "P1 int,"
						+ "P2 int,"
						+ "P3 int"
						+ ")";
				stat.executeUpdate(sql);
				
			sql = "Create table RANKING("
						+ "NICK String,"
						+ "PUNTUACION int"
						+ ")";
			stat.executeUpdate(sql);
			
				
			}catch(SQLException e){}
			
				sql = "select * from usuario where nick = 'Administrador'";
				rs = stat.executeQuery(sql);
				if(!rs.next()){
					sql = "Insert into USUARIO values ('Administrador', 'Administrador','','','','99999')";
					stat.executeUpdate(sql);
					sql = "Insert into Inventario values ('Administrador', '1', '1', '1')";
					stat.executeUpdate(sql);
				}
	
				rs.close();
				con.close();
				stat.close();

				
		}catch(Exception e){
			System.out.println("ERROR EN SQL: " + sql );
			e.printStackTrace();
		}
		
	}
	
	
	public static String insertarUsuario(String nick, String pass, String nom, String apell, int edad, int monedas){
		PreparedStatement stmt;
		
		try{
			stmt = con.prepareStatement("INSERT INTO USUARIO VALUES(?,?,?,?,?,?)");
			stmt.setString(1, nick);
			stmt.setString(2, pass);
			stmt.setString(3, nom);
			stmt.setString(4, apell);
			stmt.setInt(5, edad);
			stmt.setInt(6,  monedas);
			
//			"Insert into USUARIO values ('"
//					+nick
//					"','"
//					+pass
//					"','"
//					+nom
//					"','"
//					+apell
//					"','"
//					+edad
//					"','"
//					+monedas
//					"')";
			stmt.executeUpdate();
			return "Usuario a�adido";
			
		}catch(Exception e){
			return "Error en la creaci�n de Usuario.";
		}
	}
	
	
	public static String modificarUsuario(String nick, int monedas){
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement("UPDATE USUARIO SET MONEDAS = ?" + "WHERE NICK = ?");
			stmt.setInt(1, monedas);
			stmt.setString(2, nick);
			stmt.executeUpdate();
			return "Usuario actualizado";
			
		}catch(Exception e){
			return "Error de actualizaci�n de Usuario";
		}
	}
	
	public static int selectUsuario(String nick){
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement("SELECT MONEDAS FROM USUARIO" + "WHERE NICK = ?");
			stmt.setString(1, nick);
			rs = stmt.executeQuery();
			int monedas = Integer.parseInt((String) rs.getObject(2));
			return monedas;
			
		}catch(Exception e){
			return 0;
		}
	}
	
	
	public static String insertarInventario(String nick, int p1, int p2, int p3){
		PreparedStatement stmt;
		
		try{
			stmt = con.prepareStatement("INSERT INTO INVENTARIO VALUES (?, ?, ?, ?)");
			stmt.setString(1, nick);
			stmt.setInt(2, p1);
			stmt.setInt(3, p2);
			stmt.setInt(4, p3);
			stmt.executeUpdate();
			
			return "Inventario a�adido.";
			
		}catch(Exception e){
			return "Error en Inventario";
		}
	}
	
	
	public static String modificarInventario(String nick, int p1, int p2, int p3){
		PreparedStatement stmt;
		
		try{
			stmt = con.prepareStatement("UPDATE INVENTARIO SET P1 = ?, SET P2 = ?, SET P3 = ?" + "WHERE NICK = ?");
			stmt.setInt(1, p1);
			stmt.setInt(2, p2);
			stmt.setInt(3, p3);
			stmt.setString(4, nick);
			stmt.executeUpdate();
			
			return "Compra validada";
		}catch(Exception e){
			return "Compra no validada";
		}
	}
	
	
	public static int selectInventarioP1(String nick){
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement("SELECT P1 FROM INVENTARIO" + "WHERE NICK = ?");
			stmt.setString(1, nick);
			rs = stmt.executeQuery();
			int p1 = Integer.parseInt((String) rs.getObject(2));
			return p1;
			
		}catch(Exception e){
			return 0;
		}
	}
	
	public static int selectInventarioP2(String nick){
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement("SELECT P2 FROM INVENTARIO" + "WHERE NICK = ?");
			stmt.setString(1, nick);
			rs = stmt.executeQuery();
			int p2 = Integer.parseInt((String) rs.getObject(3));
			return p2;
			
		}catch(Exception e){
			return 0;
		}
	}
	
	public static int selectInventarioP3(String nick){
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement("SELECT P3 FROM INVENTARIO" + "WHERE NICK = ?");
			stmt.setString(1, nick);
			rs = stmt.executeQuery();
			int p3 = Integer.parseInt((String) rs.getObject(4));
			return p3;
			
		}catch(Exception e){
			return 0;
		}
	}
	
	
	public static String insertarRanking(String nick, int puntuacion){
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement("INSERT INTO RANKING VALUES (?, ?)");
			stmt.setString(1, nick);
			stmt.setInt(2, puntuacion);
			stmt.executeUpdate();
			
			return "Puntuaci�n a�adida";
			
		}catch(Exception e){
			return "Puntuaci�n no a�adida";
		}
	}
	
	public static String modificarRanking(String nick, int puntuacion){
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement("UPDATE RANKING SET PUNTUACION = ?" + "WHERE NICK = ?");
			stmt.setInt(1, puntuacion);
			stmt.setString(2, nick);
			stmt.executeUpdate();
			
			return "Puntuaci�n modificada";
			
		}catch(Exception e){
			return "Puntuaci�n no modificado";
		}
	} 
	
	public static String[] selectRankingNick(){
		PreparedStatement stmt;
		String[] arrayNick = new String[10];
		try {
			stmt = con.prepareStatement("SELECT TOP 10 FROM RANKING" + "ORDER BY PUNTUACION DESC");
			rs = stmt.executeQuery();
			Array a = rs.getArray("NICK");
			arrayNick = (String[]) a.getArray();
			
			return arrayNick;
			
			
		} catch (Exception e) {
			arrayNick = null;
			return arrayNick;
		}
	
	}
	
	public static String[] selectRankingPuntuacion(){
		PreparedStatement stmt;
		String[] arrayPuntuacion = new String[10];
		try{
			stmt = con.prepareStatement("SELECT TOP 10 PUNTUACION FROM RANKING" + "ORDER BY PUNTUACION DESC");
			rs = stmt.executeQuery();
			Array a = rs.getArray("PUNTUACION");
			arrayPuntuacion = (String[]) a.getArray();
			
			return arrayPuntuacion;
			
			
		}catch(Exception e){
			arrayPuntuacion = null;
			return arrayPuntuacion;
		}
	}
	

}
