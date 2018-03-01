package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private String nombreBd= "proyectoreserva";
	private String usuario="root";
	private String password= "";
	private String url= "jdbc:mysql://localhost:3306/"+nombreBd;
	
	Connection conn=null;
	
	public Conexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, usuario, password);
			if(conn!=null){
				System.out.println("Conexion Exitosa a la BD: "+nombreBd);
			}else{
				System.out.println("*****************NO SE PUDO CONECTAR "+nombreBd);
			}
		}
		catch(ClassNotFoundException e){
			System.out.println("Ocurre una ClassNotFound  "+nombreBd);
		} catch (SQLException e) {
			System.out.println("Ocurre una SQL Exception: "+e.getMessage());
			System.out.println("Verifique que Mysql esté encendido...");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void desconectar() {
		conn=null;
	}
}
