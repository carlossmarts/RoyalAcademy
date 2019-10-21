package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Opcion;
import datos.Pregunta;
import datos.TipoPregunta;

public class PreguntaDAO {
	
	public boolean existePregunta (int idPregunta, String texto) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from Pregunta where idPregunta <> " + idPregunta+ " and texto = '"+texto+"'";
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
	
	public boolean existePreguntaXExamen (int idPregunta) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from PreguntaXExamen where idPregunta =" + idPregunta;
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
	
	public boolean existeOpcion (int idPregunta) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from Opcion where idPregunta = "+idPregunta;
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
	

	public int traerIdPregunta(String texto) throws SQLException {
		int retorno = 0;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select idPregunta from Pregunta where texto = '"+texto+"'";
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = lector.getInt("idPregunta");
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
	
	
	public boolean existeTipo (int idTipoPregunta) throws SQLException {
		boolean retorno = false;
		Connection cnx=null;
		ResultSet lector = null;

		String sql = "select count(*) as cantidad from TipoPregunta where idTipoPregunta = "+idTipoPregunta;
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
	
	public Pregunta traerPregunta(int idPregunta) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		Pregunta retorno = null;

		String sql = "select p.idPregunta, p.texto , p.valorAprobado, tp.texto as tipoPregunta, tp.idTipoPregunta  "
				+ "from Pregunta p inner join TipoPregunta tp on p.idTipoPregunta = tp.idTipoPregunta "
				+ "where idPregunta = "+idPregunta;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			
			while(lector.next()){
				TipoPregunta tp = new TipoPregunta(lector.getInt("idTipoPregunta"), lector.getString("tipoPregunta"));
				retorno = new Pregunta(lector.getInt("idPregunta"), lector.getString("texto"), lector.getInt("valorAprobado"), tp);
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
	
	

	public void agregarPregunta(Pregunta p) throws SQLException{

		Connection cnx=null;
		PreparedStatement ps = null;

		String sql = "insert into Pregunta (texto, valorAprobado, idTipoPregunta) values (?,?,?)";
		//System.out.println(sql);

		try{
			cnx=Conexion.getConnection();
			ps = cnx.prepareStatement(sql);
			
			ps.setString(1, p.getTexto());
			ps.setInt(2, p.getValorAprobado());
			ps.setInt(3, p.getTipoPregunta().getIdTipoPregunta());
			
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

	public void eliminarPregunta(int idPregunta) throws SQLException{

		Connection cnx=null;

		PreparedStatement ps = null;
		String sql = "delete from Pregunta where idPregunta = ?";
		//System.out.println(sql);

		try{
			
			cnx=Conexion.getConnection(); //open
			ps = cnx.prepareStatement(sql);
			
			ps.setInt(1, idPregunta);
			
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


public void modificarPregunta(Pregunta p) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	
	String sql = "update Pregunta set texto = ?,valorAprobado = ?, idTipoPregunta = ? where idPregunta = ?";
	//System.out.println(sql);
	PreparedStatement ps = cnx.prepareStatement(sql);
	try{
		ps.setString(1, p.getTexto());
		ps.setInt(2, p.getValorAprobado());
		ps.setInt(3, p.getTipoPregunta().getIdTipoPregunta());
		ps.setInt(4, p.getIdPregunta());
	
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

public Pregunta traerPreguntaYOpciones(int idPregunta) throws SQLException{

	Pregunta retorno = null;
	List<Opcion> lstOpciones = new ArrayList<>();
	Connection cnx=null;
	
	ResultSet lector1 = null;
	ResultSet lector2 = null;

	String pregunta = "select p.idPregunta, p.texto , p.valorAprobado, tp.texto as tipoPregunta, tp.idTipoPregunta  "
					+ "from Pregunta p inner join TipoPregunta tp on p.idTipoPregunta = tp.idTipoPregunta "
					+ "where idPregunta = "+idPregunta;
	//System.out.println(sql);
	
	String opciones = "select idOpcion, texto, valor from Opcion where idPregunta = "+ idPregunta;

	
	try{
		cnx = Conexion.getConnection();//open
		
		lector1 = cnx.prepareStatement(pregunta).executeQuery();
		while(lector1.next()){
			TipoPregunta tp = new TipoPregunta(lector1.getInt("idTipoPregunta"), lector1.getString("tipoPregunta"));
			retorno = new Pregunta(lector1.getInt("idPregunta"), lector1.getString("texto"), lector1.getInt("valorAprobado"), tp);
		}
		
		lector2 = cnx.prepareStatement(opciones).executeQuery();
		while(lector2.next()){
			Opcion o = new Opcion(lector2.getInt("idOpcion"), lector2.getString("texto"), lector2.getInt("valor"));
			lstOpciones.add(o);
		}
		retorno.setLstOpciones(lstOpciones);
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


}
