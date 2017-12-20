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
				
				sql = "Create table TIENDA("
						+ "P1 int,"
						+ "P2 int,"
						+ "P3 int"
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
			return "Usuario añadido";
			
		}catch(Exception e){
			return "Error en Usuario.";
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
			
			return "Inventario añadido.";
			
		}catch(Exception e){
			return "Error en Inventario";
		}
	}
	

}
