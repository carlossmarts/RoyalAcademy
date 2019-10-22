package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.TipoUsuario;


public class TipoUsuarioDAO {

	public boolean existeTipoUsuario (int idTipoUsuario, String tipoUsuario) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from tipoUsuario where idTipoUsuario <> " + idTipoUsuario+ " and tipoUsuario = '"+tipoUsuario+"'";
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
	
	
	public boolean existeUsuario (int idTipoUsuario) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from usuario where idTipoUsuario = "+idTipoUsuario;
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
	

	public int traerTipoUsuario(String tipoUsuario) throws SQLException {
		int retorno = 0;
		Connection cnx=null;
		ResultSet lector = null;
		String sql = "select idTipoUsuario from tipoUsuario where tipoUsuario =" +tipoUsuario;
		//String sql = "select idTipoUsuario from tipoUsuario where tipoUsuario = '"+tipoUsuario+"'";
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = lector.getInt("tipoUsuario");
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
	
	
	public TipoUsuario traerTipoUsuario(int idTipoUsuario) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		TipoUsuario retorno = null;

		String sql = "select idTipoUsuario, tipoUsuario from tipoUsuario where idTipoUsuario = "+ idTipoUsuario;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = new TipoUsuario(lector.getInt("idTipoUsuario"), lector.getString("tipoUsuario"));
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
	
	

	public void agregarTipoUsuario(TipoUsuario t) throws SQLException{

		Connection cnx=Conexion.getConnection();//open

		String sql = "insert into tipoUsuario (tipoUsuario) values (?)";
		//System.out.println(sql);

		PreparedStatement ps = cnx.prepareStatement(sql);
		try{
			ps.setString(1, t.getTipoUsuario());
						
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

	public void eliminarTipoUsuario(int idTipoUsuario) throws SQLException{

		Connection cnx=null;//open
		PreparedStatement ps = null;
		String sql = "delete from tipoUsuario where idtipoUsuario = ?";
		//System.out.println(sql);

		try{
			cnx=Conexion.getConnection();
			ps = cnx.prepareStatement(sql);
			ps.setInt(1, idTipoUsuario);
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


public void modificarTipoUsuario(TipoUsuario t) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	
	String sql = "update tipoUsuario set tipoUsuario = ?, where idTipoUsuario = ?";
	//System.out.println(sql);
	
	PreparedStatement ps = cnx.prepareStatement(sql);
	try{
		ps.setString(1, t.getTipoUsuario());
		ps.setInt(3, t.getIdTipoUsuario());
	
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
