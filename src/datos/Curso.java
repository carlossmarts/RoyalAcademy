package datos;

public class Curso {
	private int idCurso;
	private String descripcion;

	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(int idCurso, String descripcion) {
		super();
		this.idCurso = idCurso;
		this.descripcion = descripcion;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
