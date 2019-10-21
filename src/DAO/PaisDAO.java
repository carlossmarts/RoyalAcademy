package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.Pais;
import datos.Provincia;

public class PaisDAO {
	public void crearPais(int idPais, String pais, String estado, List<Provincia> listaProvincias) throws SQLException {
		Connection cnx=null;
		ResultSet lector = null;
		
		try{
			cnx = Conexion.getConnection();//open
			String sql1 = "insert into pais(pais,estado) values('"+pais+"','"+estado+"')";//creo el pais
			System.out.println(sql1);
			cnx.prepareStatement(sql1).executeUpdate();
			
			String sql2="select max(idPais) as idPais from pais";//obtengo el último idpais
			lector = cnx.prepareStatement(sql2).executeQuery();
			System.out.println(sql2);
			while(lector.next()){
				idPais =lector.getInt("idPais");
			}
			lector.close();
			for(int p=0;p<listaProvincias.size();p++) {//uso el idPais
				String sql3 = "insert into pais_provincia(idPais,idProvincia) values("+idPais+","+listaProvincias.get(p).getIdProvincia()+")";
				System.out.println(sql3);
				cnx.prepareStatement(sql3).executeUpdate();
			}
			cnx.close();
		}catch(SQLException ex){
			throw new SQLException(ex);
		}finally {
			if(cnx!=null) {
				if(lector!=null && !lector.isClosed())lector.close();
				if(!cnx.isClosed()) cnx.close();
			}
		}
	}
	public Pais traerPais(int idPais) throws SQLException{
		
		Connection cnx=null;
		ResultSet lector = null;
		
		Pais retorno =null;
		
		String sql = "select idPais,pais,estado from pais where idPais=" +idPais;
		System.out.println(sql);
		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				retorno = new Pais(
						lector.getInt("idPais"),
						lector.getString("pais"),
						lector.getString("estado")
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
	public List<Pais> traerListaPaises() throws SQLException{
		List<Pais> lista = new ArrayList<Pais>();
		
		Connection cnx=null;
		ResultSet lector = null;
		
		String sql = "select idPais,pais,estado from pais";
		System.out.println(sql);
		
		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				Pais pais = new Pais(
						lector.getInt("idPais"),
						lector.getString("pais"),
						lector.getString("estado")
				);
				lista.add(pais);
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
		return lista;
	}
}
