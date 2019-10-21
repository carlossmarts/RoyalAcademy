package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import datos.TipoPregunta;


public class TipoPreguntaDAO {
	
	public TipoPregunta traerTipoPregunta(int idTipoPregunta) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		TipoPregunta retorno = null;

		String sql = "select texto from TipoPregunta where idTipoPregunta = " + idTipoPregunta;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = new TipoPregunta(//por constructor
						idTipoPregunta,
						lector.getString("texto")
						);
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
	public int traerIdTipoPregunta(String texto) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		int retorno = 0;

		String sql = "select idTipoPregunta from TipoPregunta where texto = '" + texto+"'";
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = lector.getInt("idTipoPregunta");
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
	

	public boolean existeTipo (String texto, int id) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from TipoPregunta where texto = '"+texto+ "' and idTipoPregunta <> " + id;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				int cantidad = lector.getInt("cantidad");
				if (cantidad !=0) {
					retorno=true;
				}
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
	
	public boolean existePregunta (int idTipoPregunta) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from Pregunta where idTipoPregunta = " + idTipoPregunta;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				int cantidad = lector.getInt("cantidad");
				if (cantidad !=0) {
					retorno=true;
				}
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
	
	public int agregarTipoPregunta(TipoPregunta tp) throws SQLException{

		Connection cnx = null;
		PreparedStatement ps = null;
		

		int retorno = 0;
		String sql = "insert into TipoPregunta(texto) values ('" + tp.getTexto() + "')";
		System.out.println(sql);

		
		try{
			cnx=Conexion.getConnection();//open
			ps = cnx.prepareStatement(sql);
			
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
		retorno = traerIdTipoPregunta(tp.getTexto());
		return retorno;
	}

	public void eliminarTipoPregunta(int idTipoPregunta) throws SQLException{

		Connection cnx=Conexion.getConnection();//open

		String sql = "delete from TipoPregunta where idTipoPregunta = ?";
		//System.out.println(sql);

		PreparedStatement ps = cnx.prepareStatement(sql);
		try{
			ps.setInt(1, idTipoPregunta);
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


public void modificarTipoPregunta(TipoPregunta tp) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	
	String sql = "update TipoPregunta set texto = ? where idTipoPregunta = ?";
	//System.out.println(sql);
	
	PreparedStatement ps = cnx.prepareStatement(sql);
	try{
		ps.setString(1, tp.getTexto());
		ps.setInt(2, tp.getIdTipoPregunta());
	
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
