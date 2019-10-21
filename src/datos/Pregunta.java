package datos;

public class Pregunta {
	private int idPregunta;
	private String texto;
	private int valorAprobado;

	public Pregunta() {

	}

	public Pregunta(int idPregunta, String texto, int valorAprobado) {
		super();
		this.idPregunta = idPregunta;
		this.texto = texto;
		this.valorAprobado = valorAprobado;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getValorAprobado() {
		return valorAprobado;
	}

	public void setValorAprobado(int valorAprobado) {
		this.valorAprobado = valorAprobado;
	}

}
