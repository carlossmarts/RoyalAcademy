package datos;

import java.util.List;

public class Consigna {
	private int idConsigna;
	private List<Pregunta> lstPreguntas;
	private TipoConsigna tipoConsigna;

	public Consigna(int idConsigna, List<Pregunta> lstPreguntas, TipoConsigna tipoConsigna) {
		super();
		this.idConsigna = idConsigna;
		this.lstPreguntas = lstPreguntas;
		this.tipoConsigna = tipoConsigna;
	}

	public Consigna() {
		// TODO Auto-generated constructor stub
	}

	public int getIdConsigna() {
		return idConsigna;
	}

	public void setIdConsigna(int idConsigna) {
		this.idConsigna = idConsigna;
	}

	public List<Pregunta> getLstPreguntas() {
		return lstPreguntas;
	}

	public void setLstPreguntas(List<Pregunta> lstPreguntas) {
		this.lstPreguntas = lstPreguntas;
	}

	public TipoConsigna getTipoConsigna() {
		return tipoConsigna;
	}

	public void setTipoConsigna(TipoConsigna tipoConsigna) {
		this.tipoConsigna = tipoConsigna;
	}

}
