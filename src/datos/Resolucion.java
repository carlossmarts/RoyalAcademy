package datos;

import java.util.ArrayList;
import java.util.List;

public class Resolucion {
	private int idResolucion;
	private int dniAlumno;
	private int idExamen;
	private List<Respuesta> respuestas;
	
	public Resolucion(int idResolucion, int dniAlumno, int idExamen) {
		super();
		this.idResolucion = idResolucion;
		this.dniAlumno = dniAlumno;
		this.idExamen = idExamen;
		this.respuestas = new ArrayList<>();
	}
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	public int getIdResolucion() {
		return idResolucion;
	}
	public void setIdResolucion(int idResolucion) {
		this.idResolucion = idResolucion;
	}
	public int getDniAlumno() {
		return dniAlumno;
	}
	public void setDniAlumno(int dniAlumno) {
		this.dniAlumno = dniAlumno;
	}
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	@Override
	public String toString() {
		return "Resolucion [idResolucion=" + idResolucion + ", dniAlumno=" + dniAlumno + ", idExamen="
				+ idExamen + "]";
	}
	
	
	
	
	
	

}
