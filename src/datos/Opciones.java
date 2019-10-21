package datos;
import java.util.List;
import java.util.ArrayList;

public class Opciones extends Pregunta {
	private List<Opcion> lstOpciones;

	

	public Opciones(int idPregunta, String texto, int valorAprobado) {
		super(idPregunta, texto, valorAprobado);
		this.lstOpciones = new ArrayList<>();
	}

	public List<Opcion> getLstOpciones() {
		return lstOpciones;
	}

	public void setLstOpciones(List<Opcion> lstOpciones) {
		this.lstOpciones = lstOpciones;
	}

	@Override
	public String toString() {
		String retorno = super.toString();
		for (Opcion o : lstOpciones) {
			retorno += o.toString();
		}
		return retorno;
	}
	
	
	
	
	

}
