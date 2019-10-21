package datos;

public class TipoUsuario {
	private int idTipoUsuario;
	private String tipoUsuario;

	public TipoUsuario(int idTipoUsuario, String tipoUsuario) {
		super();
		this.idTipoUsuario = idTipoUsuario;
		this.tipoUsuario = tipoUsuario;
	}

	public TipoUsuario() {
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
