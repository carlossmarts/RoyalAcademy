package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Examen;



public class ExamenDAO {
	
	public int traerIdExamen(String codigo) throws SQLException {
		int retorno = 0;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select idExamen from Examen where codigo = '"+codigo+"'";
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = lector.getInt("idExamen");
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
	
	public boolean existeCodigoExamen(String codigo, int idExamen) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from Examen where codigo = '"+codigo+"' and idExamen <> " + idExamen;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				int cantidad = lector.getInt("cantidad");
				if(cantidad !=0) {
					retorno = true;
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
	
	public Examen traerExamen(int idExamen) throws SQLException{

		Connection cnx=null;
		ResultSet lector1 = null;
		ResultSet lector2 = null;
		
		Examen retorno = null;

		String examen = "select codigo from Examen where idExamen = " + idExamen;
		String preguntas = "select idPregunta from PreguntaXExamen where idExamen = " + idExamen;
		System.out.println(preguntas);
		System.out.println(examen);

		try{
			cnx = Conexion.getConnection();//open
			lector1 = cnx.prepareStatement(examen).executeQuery();
			lector2 = cnx.prepareStatement(preguntas).executeQuery();
			while(lector1.next()){
				retorno = new Examen(idExamen, lector1.getString("codigo"));
			}
			List<Integer> preg = new ArrayList<Integer>();
			
			while(lector1.next()){
				int p = lector2.getInt("idPregunta");
				preg.add(p);
			}
			retorno.setLstPreguntas(preg);
			
			lector1.close();
			lector2.close();
			cnx.close();
		}catch(SQLException ex){
			throw new SQLException(ex);
		}finally {
			if(cnx!=null) {
				if(lector1!=null && !lector1.isClosed())lector1.close();
				if(lector2!=null && !lector2.isClosed())lector2.close();
				if(!cnx.isClosed()) cnx.close();
			}
		}
		return retorno;
	}
	
	
	public void agregarExamen(Examen p) throws SQLException{

		Connection cnx=null;
		PreparedStatement ps = null;

		String sql = "insert into Examen (codigo) values ('"+p.getCodigo()+"')";
		//System.out.println(sql);

		try{
			cnx=Conexion.getConnection();
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
	}

	public void eliminarExamen(int idExamen) throws SQLException{

		Connection cnx=null;

		PreparedStatement ps = null;
		String sql = "delete from Examen where idExamen = ?";
		//System.out.println(sql);

		try{
			
			cnx=Conexion.getConnection(); //open
			ps = cnx.prepareStatement(sql);
			
			ps.setInt(1, idExamen);
			
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
	
	public void modificarExamen(Examen p) throws SQLException{
		
		Connection cnx=null;//open
		PreparedStatement ps = null;
		
		String sql = "update Examen set codigo = '"+p.getCodigo()+"' where idExamen = ?";
		//System.out.println(sql);
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
	}

	public void agregarPregunta(int idExamen, int idPregunta) throws SQLException {
		Connection cnx=null;//open
		PreparedStatement ps = null;
		
		String sql = "insert into PreguntaXExamen(idExamen, idPregunta) values ("+idExamen+", "+idPregunta+")";
		//System.out.println(sql);
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
	}

	public List<Integer> traerPreguntas(int idExamen) throws SQLException {
		Connection cnx=null;//open
		ResultSet lector = null;
		List<Integer> retorno = new ArrayList<Integer>();
		
		String sql = "select idPregunta from PreguntaXExamen where idExamen = " + idExamen;
		//System.out.println(sql);
		try{
			cnx=Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()) {
				retorno.add(lector.getInt("idPregunta"));
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

}
