package Resp;

import java.util.ArrayList;
import java.util.List;

import datos.Pais;

public class RespListarPais extends Resp{
	private List<Pais> paquetes;
	public RespListarPais() {//constructor
        this.paquetes = new ArrayList<Pais>();
    }
	public List<Pais> getPaquetes() {
		return paquetes;
	}
	public void addPaquetes(Pais pais) {
		this.paquetes.add(pais);
	}
	public void addPaquetes(List<Pais> paquetes) {
		this.paquetes = paquetes;
	}
}
