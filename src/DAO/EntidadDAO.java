package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.PreparedStatement;

import datos.Entidad;
import datos.Usuario;

public class EntidadDAO {
	

	public boolean existeDni(int dni, int idUsuario) throws SQLException{
			
			Connection cnx=null;
			ResultSet lector = null;
			
			boolean retorno = false;//lo que retorno

			String sql = "select count(*) as retorno from entidad where documento = " + dni + " and idUsuario <> " + idUsuario;
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

		
	public Entidad traerEntidad(String mail,String contrasenia) throws SQLException{
		
		Connection cnx=null;
		ResultSet lector = null;
		
		Entidad retorno = null;//lo que retorno

		String sql = "SELECT u.idUsuario, u.mail, u.contrasenia, u.estado, u.idTipoUsuario, u.fecRegistro,"
				+ "e.apellido, e.nombre, e.documento, e.fecNacimiento, e.codGenero, e.idPais, e.idProvincia, e.idLocalidad, e.codigoPostal, e.calle, e.numero, e.departamento "
				+ "from usuario u inner join entidad e on u.idUsuario=e.idUsuario where u.mail='"+mail+"' and u.contrasenia='"+contrasenia+"'";
		//System.out.println(sql);
		
		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				LocalDate fechaReg = lector.getDate("fecRegistro").toLocalDate();
				LocalDate fechaNac = lector.getDate("fecNacimiento").toLocalDate();
				
				retorno = new Entidad(
						lector.getInt("idUsuario"),
						lector.getString("mail"),
						lector.getString("contrasenia"),
						lector.getString("estado"),
						lector.getInt("idTipoUsuario"),
						fechaReg,

						lector.getString("apellido"),
						lector.getString("nombre"),
						lector.getInt("documento"),
						fechaNac,
						lector.getString("codGenero"),
						lector.getInt("idPais"),
						lector.getInt("idProvincia"),
						lector.getInt("idLocalidad"),
						lector.getString("codigoPostal"),
						lector.getString("calle"),
						lector.getInt("numero"),
						lector.getString("departamento")
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
	
	public Entidad traerEntidad(int idUsuario) throws SQLException{
		
		Connection cnx=null;
		ResultSet lector = null;
		
		Entidad retorno = null;//lo que retorno

		String sql = "SELECT u.idUsuario, u.mail, u.contrasenia, u.estado, u.idTipoUsuario, u.fecRegistro,"
				+ "e.apellido, e.nombre, e.documento, e.fecNacimiento, e.codGenero, e.idPais, e.idProvincia, e.idLocalidad, e.codigoPostal, e.calle, e.numero, e.departamento "
				+ "from usuario u inner join entidad e on u.idUsuario=e.idUsuario where u.idUsuario="+ idUsuario;
		System.out.println(sql);
		
		try{
			cnx = Conexion.getConnection();//open
			lector = cnx.prepareStatement(sql).executeQuery();
			while(lector.next()){
				LocalDate fechaReg = lector.getDate("fecRegistro").toLocalDate();
				LocalDate fechaNac = lector.getDate("fecNacimiento").toLocalDate();
				
				retorno = new Entidad(
						lector.getInt("idUsuario"),
						lector.getString("mail"),
						lector.getString("contrasenia"),
						lector.getString("estado"),
						lector.getInt("idTipoUsuario"),
						fechaReg,

						lector.getString("apellido"),
						lector.getString("nombre"),
						lector.getInt("documento"),
						fechaNac,
						lector.getString("codGenero"),
						lector.getInt("idPais"),
						lector.getInt("idProvincia"),
						lector.getInt("idLocalidad"),
						lector.getString("codigoPostal"),
						lector.getString("calle"),
						lector.getInt("numero"),
						lector.getString("departamento")
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
	
	public int agregarEntidad(int idUsuario,String apellido, String nombre, int documento,LocalDate fecNacimiento,String codGenero,int idPais,int idProvincia,int idLocalidad,String codigoPostal,String calle,int numero,String departamento) throws SQLException{
		int retorno = 0;
		
		Connection cnx = null;
		PreparedStatement ps2 = null;
		
		String entidad ="insert into entidad "
					//(1	   ,2		,3		,4			,5			,6		 ,7		 ,8			,9			,10			,11		,12		,13)
				+ "(idUsuario,apellido,nombre,documento,fecNacimiento,codGenero,idPais,idProvincia,idLocalidad,codigoPostal,calle,numero,departamento)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
						
		try{
			cnx = Conexion.getConnection();
			cnx.setAutoCommit(false);
			
			ps2 = cnx.prepareStatement(entidad);
			
			
			Date fechaNac = Date.valueOf(fecNacimiento);
			//setear atributos a preparedStatement
			ps2.setInt(1, idUsuario);
			ps2.setString(2, apellido);
			ps2.setString(3, nombre);
			ps2.setInt(4, documento);
			ps2.setDate(5,fechaNac);
			ps2.setString(6, codGenero);
			ps2.setInt(7, idPais);
			ps2.setInt(8, idProvincia);
			ps2.setInt(9, idLocalidad);
			ps2.setString(10, codigoPostal);
			ps2.setString(11, calle);
			ps2.setInt(12, numero);
			ps2.setString(13, departamento);
		
			//agregar entidad
			ps2.executeUpdate();
			
			cnx.commit();
			ps2.close();
			cnx.close();
		}catch(SQLException ex){
			cnx.rollback();
			throw new SQLException(ex);
		}finally {
			if(cnx!=null) {
				if(ps2!=null && !ps2.isClosed())ps2.close();
				if(!cnx.isClosed()) cnx.close();
			}
		}
		return idUsuario;
	}


public void eliminarEntidad(int idUsuario) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	cnx.setAutoCommit(false);
	String sql = "delete from entidad where idUsuario = ?";
	//System.out.println(sql);
	
	PreparedStatement ps = cnx.prepareStatement(sql);
	try{
		//elimino usuario
		UsuarioDAO udao = new UsuarioDAO();
		udao.eliminarUsuario(idUsuario);
		
		//elimino entidad
		ps.setInt(1, idUsuario);
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
/*
public void modificarEntidad(Entidad e) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	cnx.setAutoCommit(false);
	boolean todoOK = false;
	
	int id = e.getIdUsuario();
	
	String entidad = "update entidad set idUsuario = ? where idUsuario = ?";
	String usuario = "update usuario set idUsuario = ? where idUsuario = ?";
	//System.out.println(sql);
	
	PreparedStatement ps1 = cnx.prepareStatement(entidad);
	PreparedStatement ps2 = cnx.prepareStatement(usuario);
	try{
		//elimino usuario y entidad
		UsuarioDAO udao = new UsuarioDAO();
		udao.eliminarUsuario(id);
		eliminarEntidad(id);
		
		//Agrego nueva entidad
		int nuevoId = agregarEntidad(e);
		
		//modifico id de entidad y usuario
		ps1.setInt(1, id);
		ps1.setInt(2, nuevoId);
		ps1.executeUpdate();
		
		ps2.setInt(1, id);
		ps2.setInt(2, nuevoId);
		ps2.executeUpdate();
		
		//cnx.commit();
		ps1.close();
		ps2.close();
		 todoOK = true;
		//cnx.close();
	}catch(SQLException ex){
		cnx.rollback();
		if (!todoOK) {
			System.out.println("vaniamos bien pero pasaron cosas");
		}
		//throw new SQLException(ex);
	}finally {
		if(todoOK) {
			cnx.commit();
		}
		if(cnx!=null) {
			if(ps1!=null && !ps1.isClosed())ps1.close();
			if(ps2!=null && !ps2.isClosed())ps2.close();
			if(!cnx.isClosed()) cnx.close();
		}
	}
}*/

public void modificarEntidad(Entidad e) throws SQLException{
	
	Connection cnx=Conexion.getConnection();//open
	cnx.setAutoCommit(false);
	boolean todoOK = false;
	
	String usuario = "update usuario set mail=?,contrasenia=?,estado=?, idTipoUsuario=?, fecRegistro=? where idUsuario = ?";
	String entidad = "update entidad set apellido=?,nombre=?,documento=?,fecNacimiento=?,codGenero=?,idPais=?,idProvincia=?,idLocalidad=?,codigoPostal=?,calle=?,numero=?,departamento=? where idUsuario = ?";
	
	//System.out.println(sql);
	
	PreparedStatement ps1 = cnx.prepareStatement(entidad);
	PreparedStatement ps2 = cnx.prepareStatement(usuario);
	try{
		
		//modifico id de entidad y usuario
		//convertir LocalDate a sqlDate
		Date fechaNac = Date.valueOf(e.getFecNacimiento());
		//setear atributos a preparedStatement
		ps1.setString(1, e.getApellido());
		ps1.setString(2, e.getNombre());
		ps1.setInt(3, e.getDocumento());
		ps1.setDate(4,fechaNac);
		ps1.setString(5, e.getCodGenero());
		ps1.setInt(6, e.getIdPais());
		ps1.setInt(7, e.getIdProvincia());
		ps1.setInt(8, e.getIdLocalidad());
		ps1.setString(9, e.getCodigoPostal());
		ps1.setString(10, e.getCalle());
		ps1.setInt(11, e.getNumero());
		ps1.setString(12, e.getDepartamento());
		ps1.setInt(13,e.getIdUsuario());
		
		ps2.setString(1, e.getMail());
		ps2.setString(2, e.getContrasenia());
		ps2.setString(3,e.getEstado());
		ps2.setInt(4, e.getIdTipoUsuario());
		ps2.setDate(5, Date.valueOf(e.getFecRegistro()));
		ps2.setInt(6, e.getIdUsuario());
		
		ps1.executeUpdate();
		ps2.executeUpdate();
		
		//cnx.commit();
		ps1.close();
		ps2.close();
		todoOK = true;
		//cnx.close();
	}catch(SQLException ex){
		cnx.rollback();
		throw new SQLException(ex);
	}finally {
		if(todoOK) {
			cnx.commit();
		}
		if(cnx!=null) {
			if(ps1!=null && !ps1.isClosed())ps1.close();
			if(ps2!=null && !ps2.isClosed())ps2.close();
			if(!cnx.isClosed()) cnx.close();
		}
	}
}
}
