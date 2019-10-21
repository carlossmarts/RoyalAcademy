package datos;

import java.util.List;

public class Opciones {
	private int idOpciones;
	private List<Opcion> lstOpciones;

	public Opciones() {
	
	}

	public Opciones(List<Opcion> lstOpciones) {
		super();
		this.lstOpciones = lstOpciones;
	}

	public List<Opcion> getLstOpciones() {
		return lstOpciones;
	}

	public void setLstOpciones(List<Opcion> lstOpciones) {
		this.lstOpciones = lstOpciones;
	}

	public int getIdOpciones() {
		return idOpciones;
	}

	public void setIdOpciones(int idOpciones) {
		this.idOpciones = idOpciones;
	}
	

}
