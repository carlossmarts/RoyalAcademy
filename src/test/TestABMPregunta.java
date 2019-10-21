package test;

import datos.Pregunta;
import datos.TipoPregunta;
import negocio.OpcionBL;
import negocio.PreguntaBL;
import negocio.TipoPreguntaBL;

public class TestABMPregunta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PreguntaBL bl = new PreguntaBL();
			OpcionBL obl = new OpcionBL();
			//bl.agregarPregunta(0, "pregunta2", 10);
			//bl.eliminarPregunta(2);
			//obl.agregarOpcion(0, "asd", 1, new Pregunta(3, "", 0));
			//bl.eliminarPregunta(3);
			//Pregunta p = bl.traerPregunta(3);
			//p.setValorAprobado(200);
			//bl.actualizarPregunta(p);
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			PreguntaBL bl = new PreguntaBL();
			OpcionBL obl = new OpcionBL();
			TipoPreguntaBL tbl = new TipoPreguntaBL();
			
			tbl.agregarTipoPregunta("Seleccione la opcion correcta");
			int idTipo = tbl.traerIdTipoPregunta("Seleccione la opcion correcta");
			TipoPregunta tp = tbl.traerTipoPregunta(idTipo);
			System.out.println(tp.getTexto());
			bl.agregarPregunta(0, "Antes de finalizar con el acta de constitución del proyecto, el patrocinador necesitaría conocer los siguientes ítems, excepto:", 6, tp);
			int idp1 = bl.traerIdPregunta("Antes de finalizar con el acta de constitución del proyecto, el patrocinador necesitaría conocer los siguientes ítems, excepto:");
			obl.agregarOpcion(0, " Información histórica y lecciones aprendidas", 0, bl.traerPregunta(idp1));
			obl.agregarOpcion(0, "Activos de proceso de la organización", 1, bl.traerPregunta(idp1));
			obl.agregarOpcion(0, "Cultura organizacional, sistemas de la organización", 0, bl.traerPregunta(idp1));
			obl.agregarOpcion(0, "Enunciado del alcance del proyecto", 0, bl.traerPregunta(idp1));
			
			tbl.agregarTipoPregunta("Indique si la siguiente afirmacion es verdadera o falsa");
			int idTipo2 = tbl.traerIdTipoPregunta("Seleccione la opcion correcta");
			TipoPregunta tp2 = tbl.traerTipoPregunta(idTipo2);
			System.out.println(tp2.getTexto());
			bl.agregarPregunta(0, "El cronograma de cliente debe mostrar hitos y actividades", 1, tp2);
			int idp2 = bl.traerIdPregunta("El cronograma de cliente debe mostrar hitos y actividades");
			obl.agregarOpcion(0, " verdadero", 0, bl.traerPregunta(idp2));
			obl.agregarOpcion(0, "falso", 1, bl.traerPregunta(idp2));
			

			System.out.println("\n------------------------------------------------------------------------------------------------");
			System.out.println(bl.traerPreguntaYOpciones(idp1).toString());
			System.out.println("\n------------------------------------------------------------------------------------------------");
			System.out.println(bl.traerPreguntaYOpciones(idp2).toString());
			
			
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		

	}

}
