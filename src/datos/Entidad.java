package datos;

import java.time.LocalDate;

public class Entidad extends Usuario{
	
	@Override
	public String toString() {
		return super.toString() + "Entidad [apellido=" + apellido + ", nombre=" + nombre + ", documento=" + documento + ", fecNacimiento="
				+ fecNacimiento + ", codGenero=" + codGenero + ", idPais=" + idPais + ", idProvincia=" + idProvincia
				+ ", idLocalidad=" + idLocalidad + ", codigoPostal=" + codigoPostal + ", calle=" + calle + ", numero="
				+ numero + ", departamento=" + departamento + "]";
	}
	private String apellido;
	private String nombre;
	private int documento;
	private LocalDate fecNacimiento;
	private String codGenero;
	private int idPais;
	private int idProvincia;
	private int idLocalidad;
	private String codigoPostal;
	private String calle;
	private int numero;
	private String departamento;
	
	public Entidad() {}
	public Entidad(
			int idUsuario,String mail,String contrasenia,String estado,int idTipoUsuario,LocalDate fecRegistro,
			String apellido,String nombre,int documento,LocalDate fecNacimiento,String codGenero,int idPais,int idProvincia,int idLocalidad,String codigoPostal,String calle,int numero,String departamento
			) {
		super(idUsuario,mail,contrasenia,estado,idTipoUsuario,fecRegistro);
		this.apellido=apellido;
		this.nombre=nombre;
		this.documento=documento;
		this.fecNacimiento=fecNacimiento;
		this.codGenero=codGenero;
		this.idPais=idPais;
		this.idProvincia=idProvincia;
		this.idLocalidad=idLocalidad;
		this.codigoPostal=codigoPostal;
		this.calle=calle;
		this.numero=numero;
		this.departamento=departamento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public LocalDate getFecNacimiento() {
		return fecNacimiento;
	}
	public void setFecNacimiento(LocalDate fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public String getCodGenero() {
		return codGenero;
	}
	public void setCodGenero(String codGenero) {
		this.codGenero = codGenero;
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
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
