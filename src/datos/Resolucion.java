package datos;

import java.util.List;

public class Resolucion {
	private int idResolucion;
	private FechaDeExamen fechaDeExamen;
	private int dniAlumno;
	private List<Respuesta> lstRespuestas;

	public Resolucion(int idResolucion, FechaDeExamen fechaDeExamen, int dniAlumno, List<Respuesta> lstRespuestas) {
		super();
		this.idResolucion = idResolucion;
		this.fechaDeExamen = fechaDeExamen;
		this.dniAlumno = dniAlumno;
		this.lstRespuestas = lstRespuestas;
	}

	public Resolucion() {
		// TODO Auto-generated constructor stub
	}

	public int getIdResolucion() {
		return idResolucion;
	}

	public void setIdResolucion(int idResolucion) {
		this.idResolucion = idResolucion;
	}

	public FechaDeExamen getFechaDeExamen() {
		return fechaDeExamen;
	}

	public void setFechaDeExamen(FechaDeExamen fechaDeExamen) {
		this.fechaDeExamen = fechaDeExamen;
	}

	public int getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(int dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public List<Respuesta> getLstRespuestas() {
		return lstRespuestas;
	}

	public void setLstRespuestas(List<Respuesta> lstRespuestas) {
		this.lstRespuestas = lstRespuestas;
	}

}
