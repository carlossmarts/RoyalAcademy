package negocio;

import java.sql.SQLException;
import java.util.List;

import DAO.ProvinciaDAO;
import datos.Provincia;

public class ProvinciaBL {
	public List<Provincia> traerListaProvincias(int idPais, List<String> listaIdProvincia) throws Exception {
		List<Provincia> retorno = null;
		try {
			ProvinciaDAO dao=new ProvinciaDAO();
			String filtro = "";
			String coma="";
			for(int t=0;t<listaIdProvincia.size();t++) {
				filtro+=coma+listaIdProvincia.get(t);
				if(t==0)coma=",";
			}
			if(filtro.equals(""))filtro="1=1";
			else filtro="idProvincia not in("+filtro+")";
			retorno =dao.traerListaProvincias(idPais,filtro);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		return retorno;
	}
	public List<Provincia> traerListaProvinciasPorPais(int idPais) throws Exception {
		List<Provincia> retorno = null;
		try {
			ProvinciaDAO dao=new ProvinciaDAO();
			retorno =dao.traerListaProvinciasPorPais(idPais);
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
		return retorno;
	}
}
