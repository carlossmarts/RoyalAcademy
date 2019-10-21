package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import DAO.Conexion;
import DAO.TipoPreguntaDAO;
import datos.TipoPregunta;

public class TipoPreguntaBL {
	public final TipoPreguntaDAO dao = new TipoPreguntaDAO();

	public TipoPregunta traerTipoPregunta(int idTipoPregunta) throws Exception{
		TipoPregunta retorno = dao.traerTipoPregunta(idTipoPregunta);
		if (retorno == null) {
			throw new Exception("error, no existe tipo de pregunta");
		}
		return retorno;
	}
	public int traerIdTipoPregunta(String texto) throws SQLException{

		int retorno = 0;
		try {
			retorno = dao.traerIdTipoPregunta(texto);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return retorno;
	}
	

	public boolean existeTipo (String texto, int id) throws Exception {
		boolean retorno = false;
		retorno = dao.existeTipo(texto, id);
		return retorno;
	}
	
	public int agregarTipoPregunta(String texto) throws Exception{
		int retorno = 0;
		if (existeTipo(texto, 0)) {
			throw new Exception("error, ya existe tipo de pregunta");
		}
		TipoPregunta tp = new TipoPregunta(0, texto);
		retorno = dao.agregarTipoPregunta(tp);
		
		return retorno;
	}

	public boolean existePregunta (int idTipoPregunta) throws Exception {
		boolean retorno = dao.existePregunta(idTipoPregunta);
		return retorno;
	}
	
	public void eliminarTipoPregunta(int idTipoPregunta) throws Exception{
		if(existePregunta(idTipoPregunta)) {
			throw new Exception("error, no se puede eliminar porque existe al menos una pregunta de este tipo");
		}
		dao.eliminarTipoPregunta(idTipoPregunta);
	}


public void modificarTipoPregunta(TipoPregunta tp) throws Exception{
	
	if (existeTipo(tp.getTexto(), tp.getIdTipoPregunta())) {
		throw new Exception("ya existe tipo de pregunta");
	}
	dao.modificarTipoPregunta(tp);
}
	

}
