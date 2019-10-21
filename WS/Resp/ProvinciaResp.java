package Resp;
import java.util.ArrayList;
import java.util.List;

import datos.Provincia;

public class ProvinciaResp extends Resp{
	private List<Provincia> paquetes;
	public ProvinciaResp() {//constructor
        this.paquetes = new ArrayList<Provincia>();
    }
	public List<Provincia> getPaquetes() {
		return paquetes;
	}
	public void addPaquetes(Provincia e) {
		this.paquetes.add(e);
	}
	public void addPaquetes(List<Provincia> lista) {
		for(int u=0;u<lista.size();u++) {
			this.paquetes.add(lista.get(u));
		}
	}
}
