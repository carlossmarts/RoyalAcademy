package negocio;

import java.sql.SQLException;

import DAO.Conexion;
import DAO.PreguntaDAO;
import DAO.TipoUsuarioDAO;
import datos.TipoUsuario;


public class TipoUsuarioBL {

	public boolean existeTipoUsuario(int idTipoUsuario, String tipoUsuario) {
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		boolean retorno = false;
		try {
			retorno = dao.existeTipoUsuario(idTipoUsuario, tipoUsuario);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	
	public int traerIdTipoUsuario (String tipoUsuario) {
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		int retorno = 0;
		try {
			retorno = dao.traerTipoUsuario(tipoUsuario);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	public TipoUsuario traerTipoUsuario(int idTipoUsuario) throws Exception {
		TipoUsuario retorno = null;
		TipoUsuarioDAO odao = new TipoUsuarioDAO();
		try {
			retorno = odao.traerTipoUsuario(idTipoUsuario);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		if(retorno == null) {
			throw new Exception ("error, no se encontró ese tipo de usuario ese con id " + idTipoUsuario);
		}
		return retorno;
	}
	
	public void agregarTipoUsuario (int idTipoUsuario, String tipoUsuario) throws Exception{
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		TipoUsuario t = new TipoUsuario(idTipoUsuario, tipoUsuario);
		if (existeTipoUsuario(0,tipoUsuario)) {
			throw new Exception("ya existe ese tipo de usuario");
		}
		dao.agregarTipoUsuario(t);;
	}
	
	public boolean existeUsuario(int idTipoUsuario) {
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		boolean retorno = false;
		try {
			retorno = dao.existeUsuario(idTipoUsuario);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
		
	public void eliminarTipoUsuario (int idTipoUsuario) throws Exception{
		if(existeUsuario(idTipoUsuario)) {
			throw new Exception("ERROR, no se puede eliminar porque existe al menos un usuario que depende de esta categoria");
		}
		TipoUsuarioDAO odao = new TipoUsuarioDAO();
		odao.eliminarTipoUsuario(idTipoUsuario);
	}
	
	public void actualizarTipoUsuario (TipoUsuario t) throws Exception{
		if (existeTipoUsuario(t.getIdTipoUsuario(), t.getTipoUsuario())) {
			throw new Exception("ya existe ese TipoUsuario");
		}
		TipoUsuarioDAO dao = new TipoUsuarioDAO();
		dao.modificarTipoUsuario(t);;
	}
	

	
}
