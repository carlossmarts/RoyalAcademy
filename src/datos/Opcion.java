package datos;

public class Opcion {
	private int idOpcion;
	private String texto;
	private int valor;

	public Opcion() {

	}

	public Opcion(int idOpcion, String texto, int valor) {
		super();
		this.idOpcion = idOpcion;
		this.texto = texto;
		this.valor = valor;
	}

	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
