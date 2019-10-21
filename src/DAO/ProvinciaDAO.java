package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Provincia;

public class ProvinciaDAO {
	public List<Provincia> traerListaProvincias(int idPais, String filtro) throws SQLException{
		
		Connection cnx=null;
		ResultSet lector = null;
		
		List<Provincia> retorno = new ArrayList<Provincia>();
		
		String sql = "select idProvincia,Provincia from provincia where " +filtro+ 
				" and idProvincia not in(select idProvincia from pais_provincia where idPais="+idPais+")";
		System.out.println(sql);
		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				
				Provincia prov = new Provincia(
						lector.getInt("idProvincia"),
						lector.getString("provincia")
				);
				retorno.add(prov);
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
	public List<Provincia> traerListaProvinciasPorPais(int idPais) throws SQLException{
		
		Connection cnx=null;
		ResultSet lector = null;
		
		List<Provincia> retorno = new ArrayList<Provincia>();
		
		String sql = "select idProvincia,Provincia from provincia where idProvincia in(select idProvincia from pais_provincia where idPais="+idPais+")";
		System.out.println(sql);
		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				
				Provincia prov = new Provincia(
						lector.getInt("idProvincia"),
						lector.getString("provincia")
				);
				retorno.add(prov);
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
