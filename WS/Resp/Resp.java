package Resp;

public class Resp {
	private boolean estado;
	private String mensaje;
	
	public Resp() {}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public void setOk(String mensaje) {
		this.estado=true;
		this.mensaje = mensaje;
	}
	public void setOk() {
		setOk("OK");
	}
	public void setNo(String mensaje) {
		this.estado=false;
		this.mensaje = mensaje;
	}
	public void setNo() {
		setNo("NO");
	}
}
