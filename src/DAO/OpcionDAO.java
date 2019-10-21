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

		String sql = "select p.idPregunta, p.texto as textoPreg, p.valorAprobado, o.texto as textoOp, o.valor "
				+ "from Opcion o inner join Pregunta p "
				+ "on o.idPregunta = p.idPregunta"
				+ " where idOpcion ="+idOpcion;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				Pregunta p = new Pregunta(lector.getInt("idPregunta"), lector.getString("textoPreg"), lector.getInt("valorAprobado"), null);
				retorno = new Opcion(idOpcion, lector.getString("textoOp"), lector.getInt("valor"), p);
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

	public void agregarOpcion(Opcion o) throws SQLException{

		Connection cnx=Conexion.getConnection();//open

		int retorno = 0;
		String sql = "insert into Opcion (idPregunta, texto, valor) values (?,?,?)";
		//System.out.println(sql);

		PreparedStatement ps = cnx.prepareStatement(sql);
		try{
			ps.setInt(1, o.getPregunta().getIdPregunta());
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

		Connection cnx=Conexion.getConnection();//open

		String sql = "delete from Opcion where idOpcion = ?";
		//System.out.println(sql);

		PreparedStatement ps = cnx.prepareStatement(sql);
		try{
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
	
	Connection cnx=Conexion.getConnection();//open
	
	String sql = "update Opcion set texto = ?,valor = ? where idOpcion = ?";
	//System.out.println(sql);
	
	PreparedStatement ps = cnx.prepareStatement(sql);
	try{
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
