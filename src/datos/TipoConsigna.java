package datos;

public class TipoConsigna {
	private int idTipoConsigna;
	private String texto;

	public TipoConsigna() {
		// TODO Auto-generated constructor stub
	}

	public TipoConsigna(int idTipoConsigna, String texto) {
		super();
		this.idTipoConsigna = idTipoConsigna;
		this.texto = texto;
	}

	public int getIdTipoConsigna() {
		return idTipoConsigna;
	}

	public void setIdTipoConsigna(int idTipoConsigna) {
		this.idTipoConsigna = idTipoConsigna;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
