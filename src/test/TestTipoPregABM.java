package test;
import datos.TipoPregunta;
import negocio.TipoPreguntaBL;

public class TestTipoPregABM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TipoPreguntaBL bl = new TipoPreguntaBL();
		try {
			//bl.agregarTipoPregunta("indique si la siguiente afirmacion es verdadera o falsa");
			int id = bl.traerIdTipoPregunta("indique si la siguiente afirmacion es verdadera o falsa");
			//bl.eliminarTipoPregunta(id);
			TipoPregunta tp = bl.traerTipoPregunta(id);
			System.out.println(tp);
			
			System.out.println("modifico");
			tp.setTexto("vof");
			bl.modificarTipoPregunta(tp);
			tp = bl.traerTipoPregunta(id);
			
			System.out.println(tp);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
