package datos;

public class Respuesta {
	private int idRespuesta;
	private int idOpcion;
	private int idPregunta;
	public Respuesta(int idRespuesta, int idOpcion, int idPregunta) {
		super();
		this.idRespuesta = idRespuesta;
		this.idOpcion = idOpcion;
		this.idPregunta = idPregunta;
	}
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public int getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}
	public int getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", idOpcion=" + idOpcion + ", idPregunta=" + idPregunta + "]";
	}
	
	
}
