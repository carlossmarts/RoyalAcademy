package datos;

public class TipoPregunta {
	private int idTipoPregunta;
	private String texto;
	
	public TipoPregunta() {}
	
	public TipoPregunta(int idTipoPregunta, String texto) {
		super();
		this.idTipoPregunta = idTipoPregunta;
		this.texto = texto;
	}

	public int getIdTipoPregunta() {
		return idTipoPregunta;
	}

	public void setIdTipoPregunta(int idTipoPregunta) {
		this.idTipoPregunta = idTipoPregunta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "TipoPregunta [idTipoPregunta=" + idTipoPregunta + ", texto=" + texto + "]";
	}
	
	
	

}
