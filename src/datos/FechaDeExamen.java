package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FechaDeExamen {

	private int idFechaDeExamen;
	private LocalDate fecha;
	private LocalTime hora;
	private Comision comision;
	private Examen examen;
	private List<Resolucion> lstResueltos;

	public FechaDeExamen() {
		// TODO Auto-generated constructor stub
	}

	public FechaDeExamen(int idFechaDeExamen, LocalDate fecha, LocalTime hora, Comision comision, Examen examen,
			List<Resolucion> lstResueltos) {
		super();
		this.idFechaDeExamen = idFechaDeExamen;
		this.fecha = fecha;
		this.hora = hora;
		this.comision = comision;
		this.examen = examen;
		this.lstResueltos = lstResueltos;
	}

	public int getIdFechaDeExamen() {
		return idFechaDeExamen;
	}

	public void setIdFechaDeExamen(int idFechaDeExamen) {
		this.idFechaDeExamen = idFechaDeExamen;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public List<Resolucion> getLstResueltos() {
		return lstResueltos;
	}

	public void setLstResueltos(List<Resolucion> lstResueltos) {
		this.lstResueltos = lstResueltos;
	}

}
