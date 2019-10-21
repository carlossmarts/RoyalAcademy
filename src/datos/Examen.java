package datos;
import java.util.List;
import java.util.ArrayList;

public class Examen {
	private int idExamen;
	private List<Consigna> lstConsignas;
	
	public Examen() {}
	
	public Examen(int idExamen) {
		super();
		this.idExamen = idExamen;
		this.lstConsignas = new ArrayList<>();
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public List<Consigna> getLstConsignas() {
		return lstConsignas;
	}

	public void setLstConsignas(List<Consigna> lstConsignas) {
		this.lstConsignas = lstConsignas;
	}
	
	public String toString() {
		String retorno = "examen: " + idExamen;
		for(Consigna c : lstConsignas) {
			retorno += "\n"+ c.toString();
		}
		return retorno;
	}
	
	
	
	
}
