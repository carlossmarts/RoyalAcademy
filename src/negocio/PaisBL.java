package negocio;

import java.sql.SQLException;
import java.util.List;

import DAO.PaisDAO;
import datos.Pais;
import datos.Provincia;

public class PaisBL {
	public void crearPais(int idPais, String pais, String estado,List<Provincia> listaProvincias) throws SQLException {
		PaisDAO paisDAO= new PaisDAO();
		paisDAO.crearPais(idPais, pais, estado, listaProvincias);
	}
	public Pais traerPais(int idPais) throws Exception {
		Pais retorno = null;
		try {
			PaisDAO dao=new PaisDAO();
			retorno =dao.traerPais(idPais);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		return retorno;
	}
	public List<Pais> traerListaPaises() throws Exception {
		List<Pais> retorno = null;
		try {
			PaisDAO dao = new PaisDAO();
			retorno = dao.traerListaPaises();
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		return retorno;
	}
}
