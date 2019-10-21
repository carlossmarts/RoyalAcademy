package datos;
import java.util.List;
import java.util.ArrayList;

public class Examen {
	private int idExamen;
	private String codigo;
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	private List<Integer> lstPreguntas;
	
	public Examen() {}
	
	public Examen(int idExamen, String codigo) {
		this.codigo = codigo;
		this.idExamen = idExamen;
		this.lstPreguntas = new ArrayList<>();
	}


	public List<Integer> getLstPreguntas() {
		return lstPreguntas;
	}

	public void setLstPreguntas(List<Integer> lstPreguntas) {
		this.lstPreguntas = lstPreguntas;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	
	public String toString() {
		return "examen: " + idExamen + ", codigo" + codigo;
	}
	
	
	
	
}
