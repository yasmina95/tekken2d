package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import main.MainFrame;

public class Usuario {
	//Ventana del juego declaracion
	
	public void Login(){ 
	try {
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		   JOptionPane.showMessageDialog(null, "Conexion realizada");
		  } catch (Exception e) {
		   // TODO: handle exception
		   System.out.println(e.toString());
		  }
		  
		  Connection con=null;
		  
		  try {

		      con = DriverManager.getConnection(
		              "jdbc:mysql://localhost/tekken","tekken","tekken");
		      
		      // Otros y operaciones sobre la base de datos...
		      
		      con.close();

		  } catch (SQLException ex) {

		      // Mantener el control sobre el tipo de error
		      System.out.println("SQLException: " + ex.getMessage());
		  }
}
	public void ingresar(String usr, String cont){
		try {
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			  } catch (Exception e) {
			   // TODO: handle exception
			   System.out.println(e.toString());
			  }
			  
			  Connection con=null;
			  
			  try {

			      con = DriverManager.getConnection(
			              "jdbc:mysql://localhost/tekken","tekken","tekken");
			      
			      // Otros y operaciones sobre la base de datos...
			     Statement s =con.createStatement();
				  
			 	 //Aquí es donde realizamos una consulta para poder comparar los resultados de los parametros y la base de datos
			 	  ResultSet rs=s.executeQuery("SELECT * FROM tekken");
			 	  
			 	 while(rs.next()){
			 	 int valor = rs.getRow();
			 	 //Se el valor de usuario coincide con alguno de los usuarios registrados
			 	 if(rs.getString(valor).equals(usr)){
			 	 valor++;
			 	 
			 	 //Si el valor de la contraseña conincide con la del usuario
			 	 if(rs.getString(valor).equals(cont)){
			 	 //Si todo es correcto, este mensaje aparecerá si se trata de un usuario registrado
			 	 JOptionPane.showMessageDialog(null, "Eres un usuario registrado");
			 	 //ventana del juego
			 	 new MainFrame();
			 	 
			 	 }
			 	 else{
			 	 JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
			 	 }
			 	 break;
			 	 }
			 	 else{
			 	 JOptionPane.showMessageDialog(null, "No eres un usuario registrado");
			 	 }
			 	 break;
			 	 }
			      con.close();

			  } catch (SQLException ex) {

			      // Mantener el control sobre el tipo de error
			      System.out.println("SQLException: " + ex.getMessage());
			  }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Usuario u=new Usuario();
u.Login();
	}

}
