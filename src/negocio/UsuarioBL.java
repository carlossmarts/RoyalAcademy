package negocio;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import DAO.Conexion;
import DAO.EntidadDAO;
import DAO.UsuarioDAO;
import datos.Usuario;

public class UsuarioBL {

	public Usuario traerUsuario(String mail, String contrasenia) throws Exception {
		Usuario retorno = null;
		UsuarioDAO udao = new UsuarioDAO();
		try {
			retorno = udao.traerUsuario(mail,contrasenia);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		if(retorno == null) {
			throw new Exception ("error, no se encontró usuario con mail " + mail);
		}
		return retorno;
	}
	
	public Usuario traerUsuario(int idUsuario) throws Exception {
		Usuario retorno = null;
		UsuarioDAO udao = new UsuarioDAO();
		try {
			retorno = udao.traerUsuario(idUsuario);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		if(retorno == null) {
			throw new Exception ("error, no se encontró usuario con id " + idUsuario);
		}
		return retorno;
	}
	
	public int agregarUsuario (int idUsuario,String mail,String contrasenia,String estado,int idTipoUsuario, LocalDate fecRegistro) throws Exception{
		EntidadDAO edao = new EntidadDAO();
		UsuarioDAO udao = new UsuarioDAO();
		if(udao.existeMail(mail,0)) {
			throw new Exception ("Error, ya existe un usuario con ese mail");
		}
		Usuario u = new Usuario(idUsuario, mail, contrasenia, estado, idTipoUsuario, fecRegistro);
		return udao.agregarUsuario(u);
	}
	
	public void eliminarUsuario (int idUsuario) throws SQLException{
		UsuarioDAO udao = new UsuarioDAO();
		udao.eliminarUsuario(idUsuario);
	}
	
	public void actualizarUsuario (Usuario u) throws Exception{
		UsuarioDAO udao = new UsuarioDAO();
		int id = u.getIdUsuario(); //guardo id
		//validacion de mail
		EntidadDAO edao = new EntidadDAO();
		if(udao.existeMail(u.getMail(), u.getIdUsuario())) {
			throw new Exception ("error, ya existe un usuario con mail " + u.getMail());
		}
		udao.modificarUsuario(u);
	}
	
	
}
