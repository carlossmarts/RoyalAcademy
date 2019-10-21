package datos;

public class Provincia {
	private int idProvincia;
	private String provincia;
	
	public Provincia() {}
	public Provincia(int idProvincia,String provincia) {
		this.idProvincia=idProvincia;
		this.provincia=provincia;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		provincia = provincia;
	}
}
