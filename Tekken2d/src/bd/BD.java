package bd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
	private static Connection connect = null;
	private static BD INSTANCE = null;
	
	public BD(){
		try {
		      // Cargamos en ejecución 
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://192.168.1.35/mathDice?"
		              + "user=cook&password=cook01");
		      //Mensaje de conexion realizada
		      System.out.println("Conexion realizada");
	    } catch (Exception e) {
	        System.out.println(e);
	    } 
}
//Metedo Conexion a la Bd
	public static Connection getConexion(){
        if (connect == null){
        	INSTANCE = new BD();
        }
		return connect;
	}	
//Método que permite insertar un usuario en la base de datos
	public boolean insertarUsuario(Usuario u,String pass){
			boolean correcto=true;
			try{
				//Objetos necesarios para la conexion
				ResultSet rs;
				Connection c=BD.getConexion();
				Statement orden;
				//Comenzamos con la conexion
				orden = c.createStatement();
			    String sql = "INSERT INTO tekken (usuario,contrasena,derrotas,victorias) " +
			                   "VALUES ('"+u.getUsuario()+"', '"+u.getContrasena()+"', '"+pass+"')";
			    orden.executeUpdate(sql);
			    }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
				      correcto=false;
			   }catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
				      correcto=false;
			   }
		    return correcto;
	}
	//Método que permite insertar un usuario en la base de datos
	public String selectUsuario(String u){
			boolean correcto=true;
			String pass=null;
			try{
				//Objetos necesarios para la conexion
				ResultSet rs;
				Connection c=BD.getConexion();
				Statement orden;
				//Comenzamos con la conexion
				orden = c.createStatement();
			    String sql = "SELECT contraseña FROM tekken WHERE usuario='"+u+"'";
			    rs = orden.executeQuery(sql);
			    //Cogemos el usuario
			    
			    if(rs.next()) pass=rs.getString("contraseña");
			    }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
				      correcto=false;
			   }catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
				      correcto=false;
			   }
		    return pass;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
