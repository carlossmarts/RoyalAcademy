package negocio;

import java.sql.SQLException;

import DAO.CursoDAO;
import datos.Curso;

public class CursoBL {
	private final CursoDAO dao = new CursoDAO();

	public Curso traerCurso(String descripcion) throws Exception {
		Curso retorno = null;
		try {
			retorno = dao.traerCurso(descripcion);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		if (retorno == null) {
			throw new Exception("error, no se encontró Curso con descripcion: "+ descripcion);
		}
		return retorno;
	}
	public Curso traerCurso(int idCurso) throws Exception {
		Curso retorno = null;
		try {
			retorno = dao.traerCurso(idCurso);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		if (retorno == null) {
			throw new Exception("error, no se encontró Curso con esa id: "+ idCurso);
		}
		return retorno;
	}
	public int agregarCurso(int idCurso, String descripcion) throws Exception {
		if (dao.existeCurso(descripcion)) {
			throw new Exception("Ya existe una Curso con esa descripcion");
		}
		Curso Curso = new Curso(idCurso, descripcion);
		return dao.agregarCurso(Curso);
	}
}
