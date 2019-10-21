package datos;

public class Respuesta {
	private int idRespuesta;
	private int idPregunta;
	private String respuesta;
	private int valor;

	public Respuesta(int idRespuesta, int idPregunta, String respuesta, int valor) {
		super();
		this.idRespuesta = idRespuesta;
		this.idPregunta = idPregunta;
		this.respuesta = respuesta;
		this.valor = valor;
	}

	public Respuesta() {
		// TODO Auto-generated constructor stub
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
