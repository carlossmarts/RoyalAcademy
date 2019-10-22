package test;

import negocio.ExamenBL;
import negocio.OpcionBL;
import negocio.PreguntaBL;
import negocio.ResolucionBL;
import negocio.TipoPreguntaBL;

public class TestResolucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PreguntaBL pbl = new PreguntaBL();
		ExamenBL ebl = new ExamenBL();
		ResolucionBL rbl = new ResolucionBL();
		
		try {
			System.out.println("-------------------------------------------------------------");
			int idExamen1 = ebl.traerIdExamen("Examen 1");
			System.out.println("\n\n"+ebl.traerExamen(idExamen1));
			System.out.println("Preguntas\n");
			for (Integer i : ebl.traerPreguntas(idExamen1)) {
				System.out.println("------------------------------------");
				System.out.println("\n" + pbl.traerPreguntaYOpciones(i));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			/*
			int idResolucion1 = rbl.agregarResolucion(123, 1);
			rbl.agregarRespuesta(idResolucion1, 1, 1);
			rbl.agregarRespuesta(idResolucion1, 5, 2);
			rbl.agregarRespuesta(idResolucion1, 9, 3);
			
			int idResolucion2 = rbl.agregarResolucion(456, 1);
			rbl.agregarRespuesta(idResolucion2, 1, 1);
			rbl.agregarRespuesta(idResolucion2, 6, 2);
			rbl.agregarRespuesta(idResolucion2, 9, 3);
			
			int idResolucion3 = rbl.agregarResolucion(789, 1);
			rbl.agregarRespuesta(idResolucion3, 1, 1);
			rbl.agregarRespuesta(idResolucion3, 6, 2);
			rbl.agregarRespuesta(idResolucion3, 10, 3);
			*/
			System.out.println("nota: " + rbl.calcularNota(rbl.traerResolucion(1, 123)));
			System.out.println("nota: " + rbl.calcularNota(rbl.traerResolucion(1, 456)));
			System.out.println("nota: " + rbl.calcularNota(rbl.traerResolucion(1, 789)));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
