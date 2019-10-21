package negocio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


import DAO.Conexion;
import DAO.EntidadDAO;
import DAO.UsuarioDAO;
import datos.Entidad;
import datos.Usuario;


public class EntidadBL {
	
	public Entidad traerEntidad(String mail, String contrasenia) throws Exception {
		Entidad retorno = null;
		try {
			EntidadDAO dao=new EntidadDAO();
			retorno =dao.traerEntidad(mail,contrasenia);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		return retorno;
	}
	
	public Entidad traerEntidad(int id) throws Exception {
		Entidad retorno = null;
		try {
			EntidadDAO dao=new EntidadDAO();
			retorno =dao.traerEntidad(id);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		if(retorno == null) {
			throw new Exception("no se encontro entidad");
		}
		return retorno;
	}
	public int agregarEntidad(
			int idUsuario, String apellido,String nombre,int documento,LocalDate fecNacimiento,String codGenero,int idPais,int idProvincia,int idLocalidad,String codigoPostal,String calle,int numero,String departamento
		) throws Exception{
		int retorno = 0;
		EntidadDAO dao = new EntidadDAO();
		try {
			retorno = dao.agregarEntidad(idUsuario, apellido, nombre, documento, fecNacimiento, codGenero, idPais, idProvincia, idLocalidad, codigoPostal, calle, numero, departamento);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		return retorno;
	}
	
	public void eliminarEntidad (int idUsuario) throws SQLException{
		EntidadDAO dao=new EntidadDAO();
		dao.eliminarEntidad(idUsuario);
		
	}
	public void modificarEntidad (Entidad e) throws Exception{
		EntidadDAO edao = new EntidadDAO();
		UsuarioDAO udao = new UsuarioDAO();
		
		if(udao.existeMail(e.getMail(), e.getIdUsuario())) {
			throw new Exception ("Error, ya existe un usuario con mail " + e.getMail());
		}
		if(edao.existeDni(e.getDocumento(), e.getIdUsuario())) {
			throw new Exception ("Error, ya existe un usuario con dni" + e.getDocumento());
		}
		edao.modificarEntidad(e);
	}
}
