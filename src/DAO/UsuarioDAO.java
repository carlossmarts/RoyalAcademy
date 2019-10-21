package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import datos.Usuario;


public class UsuarioDAO {
	
	public Usuario traerUsuario(String mail,String contrasenia) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		Usuario retorno = null;

		String sql = "SELECT u.idUsuario, u.mail, u.contrasenia, u.estado, u.idTipoUsuario, u.fecRegistro "
				+ "from usuario u where u.mail='"+mail+"' and u.contrasenia='"+contrasenia+"'";
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				LocalDate fechaReg = lector.getDate("fecRegistro").toLocalDate();
				retorno = new Usuario(//por constructor
						lector.getInt("idUsuario"),
						lector.getString("mail"),
						lector.getString("contrasenia"),
						lector.getString("estado"),
						lector.getInt("idTipoUsuario"),
						fechaReg
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

	public Usuario traerUsuario(int idUsuario) throws SQLException{

		Connection cnx=null;
		ResultSet lector = null;

		Usuario retorno = null;

		String sql = "SELECT u.idUsuario, u.mail, u.contrasenia, u.estado, u.idTipoUsuario, u.fecRegistro "
				+ "from usuario u where u.idUsuario = " + idUsuario;
		System.out.println(sql);

		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				LocalDate fechaReg = lector.getDate("fecRegistro").toLocalDate();
				retorno = new Usuario(//por constructor
						lector.getInt("idUsuario"),
						lector.getString("mail"),
						lector.getString("contrasenia"),
						lector.getString("estado"),
						lector.getInt("idTipoUsuario"),
						fechaReg
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

	//Solo para implementar excepción
	public boolean existeMail(String mail, int idUsuario) throws SQLException{
				
				Connection cnx=null;
				ResultSet lector = null;
				
				boolean retorno = false;//lo que retorno

				String sql = "select count(*) as retorno from usuario where mail = '" + mail + "' and idUsuario <> " + idUsuario;
				System.out.println(sql);
				
				try{
					cnx = Conexion.getConnection();//open
					lector = cnx.prepareStatement(sql).executeQuery();
					while(lector.next()){
						if(lector.getInt("retorno")!=0) {
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


	public int agregarUsuario(Usuario u) throws SQLException{

		Connection cnx=Conexion.getConnection();//open

		int retorno = 0;
		String sql = "insert into usuario(mail,contrasenia,estado, idTipoUsuario, fecRegistro) values"
				+ "(?, ?,'S',?, ?)";
		//System.out.println(sql);

		PreparedStatement ps = cnx.prepareStatement(sql);
		try{
			ps.setString(1, u.getMail());
			ps.setString(2, u.getContrasenia());
			ps.setInt(3, u.getIdTipoUsuario());
			Date fechaReg = Date.valueOf(u.getFecRegistro());
			ps.setDate(4, fechaReg);
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
		retorno = traerUsuario(u.getMail(), u.getContrasenia()).getIdUsuario();
		return retorno;
	}

	public void eliminarUsuario(int idUsuario) throws SQLException{

		Connection cnx=Conexion.getConnection();//open

		String sql = "delete from usuario where idUsuario = ?";
		//System.out.println(sql);

		PreparedStatement ps = cnx.prepareStatement(sql);
		try{
			ps.setInt(1, idUsuario);
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


/*
public void modificarUsuario(Usuario u) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	cnx.setAutoCommit(false);
	
	String sql = "update usuario set idUsuario = ? where idUsuario = ?";
	//System.out.println(sql);
	
	PreparedStatement ps = cnx.prepareStatement(sql);
	try{
		//guardo el id del usuario
		int id = u.getIdUsuario();
		
		//elimino el usuario existente
		
		eliminarUsuario(id);
		
		//agego el usuario modificado
		int nuevoId = agregarUsuario(u);
		
		//modifico el id
		ps.setInt(1, id);
		ps.setInt(2, nuevoId);
		ps.executeUpdate();
		
		cnx.commit();
		ps.close();
		cnx.close();
	}catch(SQLException ex){
		cnx.rollback();
		throw new SQLException(ex);
	}finally {
		if(cnx!=null) {
			if(ps!=null && !ps.isClosed())ps.close();
			if(!cnx.isClosed()) cnx.close();
		}
	}
}
*/
public void modificarUsuario(Usuario u) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	
	String sql = "update usuario set mail=?,contrasenia=?,estado=?, idTipoUsuario=?, fecRegistro=? where idUsuario = ?";
	//System.out.println(sql);
	
	PreparedStatement ps = cnx.prepareStatement(sql);
	try{
		ps.setString(1, u.getMail());
		ps.setString(2, u.getContrasenia());
		ps.setString(3,u.getEstado());
		ps.setInt(4, u.getIdTipoUsuario());
		ps.setDate(5, Date.valueOf(u.getFecRegistro()));
		ps.setInt(6, u.getIdUsuario());
	
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
