package datos;

import java.util.List;

public class Examen {
	private int idExamen;
	private List<Consigna> lstConsignas;

	public Examen() {
		// TODO Auto-generated constructor stub
	}

	public Examen(int idExamen, List<Consigna> lstConsignas) {
		super();
		this.idExamen = idExamen;
		this.lstConsignas = lstConsignas;
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

}
