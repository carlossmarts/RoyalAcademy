package datos;

public class Pais {
	private int idPais;
	private String pais;
	private String estado;
	public Pais() {}
	public Pais(int idPais, String pais, String estado) {
		this.idPais=idPais;
		this.pais=pais;
		this.estado=estado;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
