package Resp;

import java.util.ArrayList;
import java.util.List;

import datos.Entidad;


public class LoginResp extends Resp{
	private List<Entidad> paquetes;
	public LoginResp() {//constructor
        this.paquetes = new ArrayList<Entidad>();
    }
	
	public List<Entidad> getPaquetes() {
		return paquetes;
	}
	public void addPaquetes(Entidad e) {
		this.paquetes.add(e);
	}
	//En este caso nunca agrego más de un usuario
	/*
	public void addPaquetes(List<Login> lista) {//agrega una lista
		for(int u=0;u<lista.size();u++) {
			this.paquetes.add(lista.get(u));
		}
	}
	*/
}
