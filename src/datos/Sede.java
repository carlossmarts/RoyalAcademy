package datos;

public class Sede {
	private int idSede;
	private String pais;
	private String provincia;
	private String direccion;

	public Sede() {
		// TODO Auto-generated constructor stub
	}

	public Sede(int idSede, String pais, String provincia, String direccion) {
		super();
		this.idSede = idSede;
		this.pais = pais;
		this.provincia = provincia;
		this.direccion = direccion;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
