package test;

import java.util.ArrayList;
import java.util.List;

import datos.TipoPregunta;
import negocio.ExamenBL;
import negocio.OpcionBL;
import negocio.PreguntaBL;
import negocio.TipoPreguntaBL;

public class TestABMExamen {

	public static void main(String[] args) {
		try {
			//agrego tipos de pregunta
			TipoPreguntaBL tbl = new TipoPreguntaBL();
			PreguntaBL pbl = new PreguntaBL();
			OpcionBL obl = new OpcionBL();
			ExamenBL ebl = new ExamenBL();
			
			
			tbl.agregarTipoPregunta("multiple coice");
			int idChoice = tbl.traerIdTipoPregunta("multiple coice");
			TipoPregunta choice = tbl.traerTipoPregunta(idChoice);
			
			tbl.agregarTipoPregunta("VoF");
			int idVof = tbl.traerIdTipoPregunta("VoF");
			TipoPregunta vof = tbl.traerTipoPregunta(idVof);
			
			//Crear Examen
		
			List <Integer> preguntas = new ArrayList<Integer>();
			ebl.agregarExamen("Examen 1");
			int idExamen1 = ebl.traerIdExamen("Examen 1");
			
			//Agrego preguntas
			
			
			pbl.agregarPregunta(0, "Pregunta 1", 1, choice);
			int idp1 = pbl.traerIdPregunta("Pregunta 1");
			obl.agregarOpcion(0, "Opcion 1-1", 1, idp1);
			obl.agregarOpcion(0, "Opcion 1-2", -1, idp1);
			obl.agregarOpcion(0, "Opcion 1-3", -1, idp1);
			obl.agregarOpcion(0, "Opcion 1-4", -1, idp1);
			preguntas.add(idp1);
			
			pbl.agregarPregunta(0, "Pregunta 2", 1, choice);
			int idp2 = pbl.traerIdPregunta("Pregunta 2");
			obl.agregarOpcion(0, "Opcion 2-1", 1, idp2);
			obl.agregarOpcion(0, "Opcion 2-2", -1, idp2);
			obl.agregarOpcion(0, "Opcion 2-3", -1, idp2);
			obl.agregarOpcion(0, "Opcion 2-4", -1, idp2);
			preguntas.add(idp2);
			
			pbl.agregarPregunta(0, "Pregunta 3", 1, vof);
			int idp3 = pbl.traerIdPregunta("Pregunta 3");
			obl.agregarOpcion(0, "Verdadero", 1, idp3);
			obl.agregarOpcion(0, "Falso", -1, idp3);
			preguntas.add(idp3);
			
			for (Integer i : preguntas) {
				ebl.agregarPregunta(idExamen1, i);
			}
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
