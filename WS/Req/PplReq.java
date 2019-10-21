package Req;

import java.util.ArrayList;
import java.util.List;

public class PplReq {
	private String caso;
	private int idPais;
	private List<String> listaIdProvincia;
	public PplReq(){
		this.listaIdProvincia = new ArrayList<String>();
	}
	public String getCaso() {
		return caso;
	}
	public void setCaso(String caso) {
		this.caso = caso;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public List<String> getListaIdProvincia() {
		return listaIdProvincia;
	}
	public void setListaIdProvincia(List<String> listaIdProvincia) {
		this.listaIdProvincia = listaIdProvincia;
	}
}
