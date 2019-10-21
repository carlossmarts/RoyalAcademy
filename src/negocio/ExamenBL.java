package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Conexion;
import DAO.ExamenDAO;
import datos.Examen;

public class ExamenBL {
	
	public final ExamenDAO dao = new ExamenDAO();
	
	public int traerIdExamen(String codigo) throws Exception{
		return dao.traerIdExamen(codigo);
	}
	
	public Examen traerExamen(int idExamen) throws Exception{
		Examen retorno = dao.traerExamen(idExamen);
		if(retorno.getCodigo()==null) {
			throw new Exception("error, no existe examen");
		}
		return retorno;
	}
	
	public boolean existeCodigoExamen(String codigo, int idExamen) throws Exception{
		return dao.existeCodigoExamen(codigo, idExamen);
	}
	
	
	public void agregarExamen(String codigo) throws Exception{
		if(existeCodigoExamen(codigo, 0)) {
			throw new Exception("error, ya existe examen con ese codigo");
		}
		dao.agregarExamen(new Examen(0, codigo));
	}

	public void eliminarExamen(int idExamen) throws SQLException{
		//implementar excepcion por existencia de fecha de examen
		dao.eliminarExamen(idExamen);
	}


	public void modificarExamen(Examen p) throws Exception{
		if(existeCodigoExamen(p.getCodigo(), p.getIdExamen())) {
			throw new Exception("error, ya existe examen con ese codigo");
		}
	}
	
	public void agregarPregunta(int idExamen, int idPregunta) throws SQLException {
		dao.agregarPregunta(idExamen, idPregunta);
	}
	
	public List<Integer> traerPreguntas(int idExamen) throws SQLException {
		return dao.traerPreguntas(idExamen);
	}

}
