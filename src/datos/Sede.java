package datos;

public class Sede {
	private int idSede;
	private int idPais;
	private int idProvincia;
	private int idLocalidad;
	private String codigoPostal;
	private String calle;
	private int numero;

	public Sede() {
	}

	public Sede(int idSede, int idPais, int idProvincia, int idLocalidad, String codigoPostal, String calle,
			int numero) {
		super();
		this.idSede = idSede;
		this.idPais = idPais;
		this.idProvincia = idProvincia;
		this.idLocalidad = idLocalidad;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numero = numero;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Sede [idSede=" + idSede + ", idPais=" + idPais + ", idProvincia=" + idProvincia + ", idLocalidad="
				+ idLocalidad + ", codigoPostal=" + codigoPostal + ", calle=" + calle + ", numero=" + numero + "]";
	}

}
