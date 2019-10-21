package Req;

import java.util.ArrayList;
import java.util.List;

import datos.Pais;
import datos.Provincia;

public class FormularioPais {
	private String escena;
	private Pais pais;
	private List<Provincia> listaProvincias;
	public FormularioPais(){
		this.listaProvincias=new ArrayList<Provincia>();
	}
	public FormularioPais(String escena, Pais pais,List<Provincia> listaProvincias){
		this.escena=escena;
		this.pais=pais;
		this.listaProvincias=listaProvincias;;
	}
	public String getEscena() {
		return escena;
	}
	public void setEscena(String escena) {
		this.escena = escena;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}
	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}
	
}
