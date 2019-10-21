package negocio;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import DAO.Conexion;
import DAO.EntidadDAO;
import DAO.OpcionDAO;
import datos.Opcion;
import datos.Pregunta;

public class OpcionBL {

	
	public boolean existeOpcion(int idPregunta, String texto) {
		OpcionDAO odao = new OpcionDAO();
		boolean retorno = false;
		try {
			retorno = odao.existeOpcion(idPregunta, texto);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	public Opcion traerOpcion(int idOpcion) throws Exception {
		Opcion retorno = null;
		OpcionDAO odao = new OpcionDAO();
		try {
			retorno = odao.traerOpcion(idOpcion);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		if(retorno == null) {
			throw new Exception ("error, no se encontró Opcion con id " + idOpcion);
		}
		return retorno;
	}
	
	public void agregarOpcion (int idOpcion, String texto, int valor, Pregunta pregunta) throws Exception{
		OpcionDAO odao = new OpcionDAO();
		Opcion o = new Opcion(idOpcion, texto, valor, pregunta);
		if (existeOpcion(pregunta.getIdPregunta(), texto)) {
			throw new Exception("ya existe esa opcion para esa pregunta");
		}
		odao.agregarOpcion(o);
	}
	
	public void eliminarOpcion (int idOpcion) throws SQLException{
		OpcionDAO odao = new OpcionDAO();
		odao.eliminarOpcion(idOpcion);
	}
	
	public void actualizarOpcion (Opcion o) throws Exception{
		if (existeOpcion(o.getPregunta().getIdPregunta(), o.getTexto())) {
			throw new Exception("ya existe esa opcion para esa pregunta");
		}
		OpcionDAO odao = new OpcionDAO();
		odao.modificarOpcion(o);
	}
	
	
}
