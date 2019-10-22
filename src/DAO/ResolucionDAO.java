package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Resolucion;
import datos.Respuesta;


public class ResolucionDAO {
	
	public boolean existeResolucion (int dniAlumno, int idExamen)throws SQLException{
		Connection cnx=null;
		ResultSet lector = null;
		boolean retorno = false;
		
		String sql = "select count(*) as cantidad from Resolucion"
				+ " where idExamen = " + idExamen + " and dniAlumno = "+ dniAlumno;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				int cantidad = lector.getInt("cantidad");
				if(cantidad!=0) {
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
	
	public boolean opcionMarcada(int idOpcion, int idResolucion) throws SQLException {
		Connection cnx=null;
		ResultSet lector = null;
		boolean retorno = false;
		
		String sql = "select count(*) as cantidad from Respuesta"
				+ " where idResolucion = " + idResolucion + " and idOpcion = "+ idOpcion;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				int cantidad = lector.getInt("cantidad");
				if(cantidad!=0) {
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
		
	public int traerIdResolucion(int idExamen, int dniAlumno ) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		int retorno = 0;

		String sql = "select idResolucion from Resolucion "
				+ "where idExamen = " + idExamen +" and dniAlumno = " + dniAlumno;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = lector.getInt("idResolucion");
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
	
	public Resolucion traerResolucion (int idExamen, int dniAlumno) throws SQLException {
		Resolucion retorno = null;
		Connection cnx = null;
		ResultSet lector1 = null;
		ResultSet lector2 = null;
		
		String resolucion = "select idResolucion from Resolucion "
				+ "where idExamen = "+idExamen+" and dniAlumno = "+ dniAlumno;
		String respuestas = "select idRespuesta, idOpcion, idPregunta from Respuesta "
				+ "where idResolucion = ";
		
		try{
			cnx = Conexion.getConnection();//open
			lector1 = cnx.prepareStatement(resolucion).executeQuery();
			int idRes = 0;
			while(lector1.next()){
				idRes = lector1.getInt("idResolucion");
				retorno = new Resolucion(idRes, dniAlumno, idExamen);
			}
			
			lector2 = cnx.prepareStatement(respuestas+idRes).executeQuery();
			List<Respuesta> lstRespuestas = new ArrayList<Respuesta>();
			while (lector2.next()) {
				Respuesta r = new Respuesta(lector2.getInt("idRespuesta"), lector2.getInt("idOpcion"), lector2.getInt("idPregunta"));
				lstRespuestas.add(r);
			}
			retorno.setRespuestas(lstRespuestas);
		
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
	
	
	public int agregarResolucion(Resolucion r) throws SQLException{
		Connection cnx = null;
		PreparedStatement ps = null;
		
		int retorno = 0;
		int idExamen = r.getIdExamen();
		int dniAlumno = r.getDniAlumno();
		
		String sql = "insert into Resolucion (idExamen, dniAlumno)"
				+ "values (" + idExamen + "," + dniAlumno + ")";
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
		retorno = traerIdResolucion(idExamen, dniAlumno);
		return retorno;
	}
	
	public void agregarRespuesta(int idResolucion, int idOpcion, int idPregunta) throws SQLException{
		Connection cnx = null;
		PreparedStatement ps = null;
		
		String sql = "insert into Respuesta (idResolucion, idOpcion, idPregunta)"
				+ "values ("+idResolucion+","+idOpcion+","+idPregunta+")";
		
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
		//retorno = traerIdResolucion(idExamen, dniAlumno);
		//return retorno;
	}
	
	
}
