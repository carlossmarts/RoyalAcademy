package datos;

public class Inscripcion {
	private int idInscripcion;
	private Usuario alumno;
	private String condicion;

	public Inscripcion() {
		// TODO Auto-generated constructor stub
	}

	public Inscripcion(int idInscripcion, Usuario alumno, String condicion) {
		super();
		this.idInscripcion = idInscripcion;
		this.alumno = alumno;
		this.condicion = condicion;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Usuario getAlumno() {
		return alumno;
	}

	public void setAlumno(Usuario alumno) {
		this.alumno = alumno;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

}
