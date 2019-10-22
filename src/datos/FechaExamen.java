package datos;

import java.time.LocalDate;


public class FechaExamen {
	private int idFechaExamen;
	private LocalDate fecha;
	private int idExamen;
	
	public FechaExamen(int idFechaExamen, LocalDate fecha, int idExamen) {
		super();
		this.idFechaExamen = idFechaExamen;
		this.fecha = fecha;
		this.idExamen = idExamen;
	}
	public int getIdFechaExamen() {
		return idFechaExamen;
	}
	public void setIdFechaExamen(int idFechaExamen) {
		this.idFechaExamen = idFechaExamen;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}
	@Override
	public String toString() {
		return "FechaExamen [idFechaExamen=" + idFechaExamen + ", fecha=" + fecha + ", idExamen=" + idExamen + "]";
	}
	
	

	
}
