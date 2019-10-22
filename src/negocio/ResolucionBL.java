package negocio;

import DAO.ResolucionDAO;
import datos.Examen;
import datos.Opcion;
import datos.Pregunta;
import datos.Resolucion;
import datos.Respuesta;

public class ResolucionBL {
	
	private final ResolucionDAO dao = new ResolucionDAO();
	
	public boolean opcionMarcada (int idOpcion, int idResolucion) throws Exception{
		return dao.opcionMarcada(idOpcion, idResolucion);
	}
	
	public int agregarResolucion(int dniAlumno,int idExamen) throws Exception{
		if(dao.existeResolucion(dniAlumno, idExamen)) {
			throw new Exception("error, ya existe una resulucion para ese alummno y examen");
		}
		return dao.agregarResolucion(new Resolucion(0, dniAlumno, idExamen));
	}
	
	public void agregarRespuesta(int idResolucion, int idOpcion, int idPregunta) throws Exception{
		dao.agregarRespuesta(idResolucion, idOpcion, idPregunta);
	}
	
	public Resolucion traerResolucion(int idExamen, int dniAlumno) throws Exception{
		return dao.traerResolucion(idExamen, dniAlumno);
	}
	
	public float calcularNota(Resolucion r) throws Exception{
		ExamenBL ebl = new ExamenBL();
		PreguntaBL pbl = new PreguntaBL();
		
		int cantidadPreguntas = 0;
		int pregAprobadas=0;
		int sumaParcial = 0;
		//Traer preguntas del examen
		for(Integer i : ebl.traerPreguntas(r.getIdExamen())) {
			Pregunta p = pbl.traerPreguntaYOpciones(i);
			cantidadPreguntas ++;
			
			sumaParcial=0;
			//ver el parcial obtenido para cada pregunta
			for (Opcion o : p.getLstOpciones()) {
				//si la opcion fue marcada se suma su valor
				if (opcionMarcada(o.getIdOpcion(), r.getIdResolucion())) {
					sumaParcial += o.getValor();
				}
			}
			if (sumaParcial >= p.getValorAprobado()) pregAprobadas ++;
			sumaParcial=0;
		}
		
		
		
		float nota = (float)pregAprobadas/(float)cantidadPreguntas*100;
		int notaInt = (int) nota;
		nota = (float) notaInt/10;
		if(nota <=2) nota=2;
		return nota;
	}
}
