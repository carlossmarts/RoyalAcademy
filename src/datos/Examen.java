package datos;
import java.util.List;
import java.util.ArrayList;

public class Examen {
	private int idExamen;
	private List<Pregunta> lstPreguntas;
	
	public Examen() {}
	
	public Examen(int idExamen) {
		super();
		this.idExamen = idExamen;
		this.lstPreguntas = new ArrayList<>();
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public List<Pregunta> getLstConsignas() {
		return lstPreguntas;
	}

	public void setLstConsignas(List<Pregunta> lstConsignas) {
		this.lstPreguntas = lstConsignas;
	}
	
	public String toString() {
		String retorno = "examen: " + idExamen + "\nPreguntas:\n";
		for(Pregunta p : lstPreguntas) {
			retorno += "\n"+ p.toString();
		}
		return retorno;
	}
	
	
	
	
}
