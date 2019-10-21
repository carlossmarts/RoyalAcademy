package datos;
import java.util.List;
import java.util.ArrayList;

public class Consigna {
	private int idConsigna;
	private TipoConsigna tipoConsigna;
	private List<Pregunta> lstPregunta;
	
	public Consigna(int idConsigna, TipoConsigna tipoConsigna, List<Pregunta> lstPregunta) {
		super();
		this.idConsigna = idConsigna;
		this.tipoConsigna = tipoConsigna;
		this.lstPregunta = new ArrayList<>();
	}
	public Consigna() {}
	public int getIdConsigna() {
		return idConsigna;
	}
	public void setIdConsigna(int idConsigna) {
		this.idConsigna = idConsigna;
	}
	public TipoConsigna getTipoConsigna() {
		return tipoConsigna;
	}
	public void setTipoConsigna(TipoConsigna tipoConsigna) {
		this.tipoConsigna = tipoConsigna;
	}
	public List<Pregunta> getLstPregunta() {
		return lstPregunta;
	}
	public void setLstPregunta(List<Pregunta> lstPregunta) {
		this.lstPregunta = lstPregunta;
	}
	@Override
	public String toString() {
		String retorno =  "Consigna [idConsigna=" + idConsigna + ", tipoConsigna=" + tipoConsigna + "]";
		for (Pregunta p : lstPregunta) {
			retorno += p.toString();
		}
		return retorno;
	}
	
	
	
}
