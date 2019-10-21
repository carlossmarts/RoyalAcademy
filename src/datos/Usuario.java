package datos;

import java.time.LocalDate;

public class Usuario {
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", mail=" + mail + ", contrasenia=" + contrasenia + ", estado="
				+ estado + ", idTipoUsuario=" + idTipoUsuario + ", fecRegistro=" + fecRegistro + "]";
	}

	private int idUsuario;
	private String mail;
	private String contrasenia;
	private String estado;
	private int idTipoUsuario;
	private LocalDate fecRegistro;
	
	public Usuario() {}
	public Usuario(int idUsuario,String mail,String contrasenia,String estado,int idTipoUsuario,LocalDate fecRegistro) {
		this.idUsuario=idUsuario;
		this.mail=mail;
		this.contrasenia=contrasenia;
		this.estado=estado;
		this.idTipoUsuario=idTipoUsuario;
		this.fecRegistro=fecRegistro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public LocalDate getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(LocalDate fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
}
