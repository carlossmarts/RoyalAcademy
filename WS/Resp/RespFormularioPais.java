package Resp;

import Req.FormularioPais;

public class RespFormularioPais extends Resp{
	private FormularioPais paquetes;
	public RespFormularioPais() {}//constructor
	public FormularioPais getPaquetes() {
		return paquetes;
	}
	public void setPaquetes(FormularioPais paquetes) {
		this.paquetes = paquetes;
	}
	
}
