package test;
import negocio.SedeBL;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SedeBL bl =new SedeBL();
		try {
		bl.agregarSede(1, 1, 1, 1, "1842", "Barbier", 2746);
		System.out.println(bl.traerSede("Barbier", 2746).toString());
		System.out.println(bl.traerSede(1).toString());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
