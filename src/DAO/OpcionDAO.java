package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import datos.Opcion;
import datos.Pregunta;
import datos.Usuario;

public class OpcionDAO {
	
	public boolean existeOpcion (int idPregunta, String texto) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from Opcion where idPregunta = "+idPregunta+" and texto = '"+texto+"'";
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				int cantidad = lector.getInt("cantidad");
				if (cantidad !=0) retorno=true;
			}
			lector.close();
			cnx.close();
		}catch(SQLException ex){
			throw new SQLException(ex);
		}finally {
			if(cnx!=null) {
				if(lector!=null && !lector.isClosed())lector.close();
				if(!cnx.isClosed()) cnx.close();
			}
		}
		return retorno;
	}
	
	public Opcion traerOpcion(int idOpcion) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		Opcion retorno = null;

		String sql = "select texto, valor from Opcion where idOpcion ="+idOpcion;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = new Opcion(idOpcion, lector.getString("texto"), lector.getInt("valor"));
			}
			lector.close();
			cnx.close();
		}catch(SQLException ex){
			throw new SQLException(ex);
		}finally {
			if(cnx!=null) {
				if(lector!=null && !lector.isClosed())lector.close();
				if(!cnx.isClosed()) cnx.close();
			}
		}
		return retorno;
	}

	public void agregarOpcion(Opcion o, int idPregunta) throws SQLException{

		Connection cnx = null;
		PreparedStatement ps = null;
		String sql = "insert into Opcion (idPregunta, texto, valor) values (?,?,?)";
		//System.out.println(sql);

		try{
			cnx=Conexion.getConnection();//open
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, idPregunta);
			ps.setString(2, o.getTexto());
			ps.setInt(3, o.getValor());
			
			ps.executeUpdate();
			ps.close();
			cnx.close();
		}catch(SQLException ex){
			throw new SQLException(ex);
		}finally {
			if(cnx!=null) {
				if(ps!=null && !ps.isClosed())ps.close();
				if(!cnx.isClosed()) cnx.close();
			}
		}
	}

	public void eliminarOpcion(int idOpcion) throws SQLException{

		Connection cnx = null;
		PreparedStatement ps = null; 
		String sql = "delete from Opcion where idOpcion = ?";
		//System.out.println(sql);

		
		try{
			cnx=Conexion.getConnection();//open
			ps = cnx.prepareStatement(sql);
			
			ps.setInt(1, idOpcion);
			ps.executeUpdate();
			ps.close();
			cnx.close();
		}catch(SQLException ex){
			throw new SQLException(ex);
		}finally {
			if(cnx!=null) {
				if(ps!=null && !ps.isClosed())ps.close();
				if(!cnx.isClosed()) cnx.close();
			}
		}
	}


public void modificarOpcion(Opcion o) throws SQLException{
	
	Connection cnx=null;
	PreparedStatement ps = null;
	
	String sql = "update Opcion set texto = ?,valor = ? where idOpcion = ?";
	//System.out.println(sql);
	
	try{
		cnx=Conexion.getConnection();//open
		ps = cnx.prepareStatement(sql);
		
		ps.setString(1, o.getTexto());
		ps.setInt(2, o.getValor());
		ps.setInt(3, o.getIdOpcion());
	
		ps.executeUpdate();
		
		ps.close();
		cnx.close();
	}catch(SQLException ex){
		throw new SQLException(ex);
	}finally {
		if(cnx!=null) {
			if(ps!=null && !ps.isClosed())ps.close();
			if(!cnx.isClosed()) cnx.close();
		}
	}
}

}
