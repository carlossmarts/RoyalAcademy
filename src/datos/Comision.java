package datos;

import java.util.List;

public class Comision {
	private int idComision;
	private Curso curso;
	private Sede sede;
	private Usuario responsable;
	private List<Inscripcion> lstAlumnos;

	public Comision(int idComision, Curso curso, Sede sede, Usuario responsable, List<Inscripcion> lstAlumnos) {
		super();
		this.idComision = idComision;
		this.curso = curso;
		this.sede = sede;
		this.responsable = responsable;
		this.lstAlumnos = lstAlumnos;
	}

	public Comision() {
		// TODO Auto-generated constructor stub
	}

	public int getIdComision() {
		return idComision;
	}

	public void setIdComision(int idComision) {
		this.idComision = idComision;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}

	public List<Inscripcion> getLstAlumnos() {
		return lstAlumnos;
	}

	public void setLstAlumnos(List<Inscripcion> lstAlumnos) {
		this.lstAlumnos = lstAlumnos;
	}

}
