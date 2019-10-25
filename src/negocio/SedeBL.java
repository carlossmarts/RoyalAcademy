package negocio;

import java.sql.SQLException;

import DAO.SedeDAO;
import datos.Sede;

public class SedeBL {

	private final SedeDAO dao = new SedeDAO();

	public Sede traerSede(String calle, int numero) throws Exception {
		Sede retorno = null;
		try {
			retorno = dao.traerSede(calle, numero);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		if (retorno == null) {
			throw new Exception("error, no se encontró sede con direccion: " + calle + " " + numero);
		}
		return retorno;
	}

	public Sede traerSede(int idSede) throws Exception {
		Sede retorno = null;
		try {
			retorno = dao.traerSede(idSede);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		if (retorno == null) {
			throw new Exception("error, no se encontró Sede con esa id: "+ idSede);
		}
		return retorno;
	}

	public int agregarSede(int idSede, int idPais, int idProvincia, int idLocalidad, String codigoPostal, String calle,
			int numero) throws Exception {
		if (dao.existeSede(calle, numero)) {
			throw new Exception("Ya existe una sede con esa direccion");
		}
		Sede sede = new Sede(idSede, idPais, idProvincia, idLocalidad, codigoPostal, calle, numero);
		return dao.agregarSede(sede);
	}
}
