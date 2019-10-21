package negocio;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import DAO.Conexion;
import DAO.EntidadDAO;
import DAO.PreguntaDAO;
import datos.Pregunta;
import datos.TipoPregunta;
import datos.Pregunta;

public class PreguntaBL {

	
	public boolean existePregunta(int idPregunta, String texto) {
		PreguntaDAO dao = new PreguntaDAO();
		boolean retorno = false;
		try {
			retorno = dao.existePregunta(idPregunta, texto);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	public boolean existeOpcion(int idPregunta) {
		PreguntaDAO dao = new PreguntaDAO();
		boolean retorno = false;
		try {
			retorno = dao.existeOpcion(idPregunta);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	public boolean existeTipo(int idTipoPregunta) {
		PreguntaDAO dao = new PreguntaDAO();
		boolean retorno = false;
		try {
			retorno = dao.existeTipo(idTipoPregunta);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	public int traerIdPregunta (String texto) {
		PreguntaDAO dao = new PreguntaDAO();
		int retorno = 0;
		try {
			retorno = dao.traerIdPregunta(texto);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}
	
	public Pregunta traerPregunta(int idPregunta) throws Exception {
		Pregunta retorno = null;
		PreguntaDAO odao = new PreguntaDAO();
		try {
			retorno = odao.traerPregunta(idPregunta);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		if(retorno == null) {
			throw new Exception ("error, no se encontró Pregunta con id " + idPregunta);
		}
		return retorno;
	}
	
	public void agregarPregunta (int idPregunta, String texto, int valorAprobado, TipoPregunta tp) throws Exception{
		PreguntaDAO dao = new PreguntaDAO();
		Pregunta p = new Pregunta(idPregunta, texto, valorAprobado, tp);
		if(!existeTipo(tp.getIdTipoPregunta())) {
			throw new Exception("No existe tipo de pregunta");
		}
		
		if (existePregunta(0,  texto)) {
			throw new Exception("ya existe esa Pregunta");
		}
		dao.agregarPregunta(p);
	}
	
	public void eliminarPregunta (int idPregunta) throws Exception{
		if(existeOpcion(idPregunta)) {
			throw new Exception("error, no se puede eliminar porque existe al menos una opcion que depende de esa pregunta");
		}
		PreguntaDAO odao = new PreguntaDAO();
		odao.eliminarPregunta(idPregunta);
	}
	
	public void actualizarPregunta (Pregunta p) throws Exception{
		if(!existeTipo(p.getTipoPregunta().getIdTipoPregunta())) {
			throw new Exception("No existe tipo de pregunta");
		}
		if (existePregunta(p.getIdPregunta(), p.getTexto())) {
			throw new Exception("ya existe esa Pregunta");
		}
		PreguntaDAO dao = new PreguntaDAO();
		dao.modificarPregunta(p);
	}
	
	public Pregunta traerPreguntaYOpciones(int idPregunta) throws Exception{
		PreguntaDAO dao = new PreguntaDAO();
		Pregunta retorno = dao.traerPreguntaYOpciones(idPregunta);
		if (retorno == null) {
			throw new Exception ("error, no existe pregunta con ese id");
		}
		return retorno;
	}
	
	
}
