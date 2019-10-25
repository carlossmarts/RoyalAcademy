package test;
import negocio.CursoBL;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CursoBL bl =new CursoBL();
		try {
		bl.agregarCurso(1, "Diseño Grafico");
		System.out.println(bl.traerCurso("Diseño Grafico").toString());
		System.out.println(bl.traerCurso(1).toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
