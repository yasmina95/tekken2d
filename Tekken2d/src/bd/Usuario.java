package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import main.Juego;

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
			 	 new Juego();
			 	 
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
	public boolean registro(String user, String pass, int v, int d){ 
		PreparedStatement pst=null;
		try {
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			   JOptionPane.showMessageDialog(null, "Procesando registro...");
			  } catch (Exception e) {
			   // TODO: handle exception
			   System.out.println(e.toString());
			  }
			  
			  Connection con=null;
			  
			  try {

			      con = DriverManager.getConnection(
			              "jdbc:mysql://localhost/tekken","tekken","tekken");
			      
			      // Otros y operaciones sobre la base de datos...
			      String consulta="insert into tekken (usuario, contraseña, victorias, derrotas) values(?,?,?,?)";
			      pst=con.prepareStatement(consulta);
			      pst.setString(1, user);
			      pst.setString(2,pass);
			      pst.setInt(3,v);
			      pst.setInt(4,d);
			      
			      if(pst.executeUpdate()==1){
			    	  return true;
			      }
			      con.close();

			  } catch (SQLException ex) {

			      //
			  }finally{
				  try{
					  if(con !=null)con.close();
					  if(pst !=null)pst.close();
				  }catch(Exception e){
					  System.out.println("Error" + e);
					  
				  }
			  }
			  return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Usuario u=new Usuario();

u.registro("abc", "abc", 1,1);
	}

}
