package test;

import datos.TipoUsuario;
import datos.Usuario;
import negocio.TipoUsuarioBL;


public class TestABMTipoUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			TipoUsuarioBL bl = new TipoUsuarioBL();
		
	        System.out.println(bl.traerTipoUsuario(1));
	        //System.out.println(bl.traerIdTipoUsuario("docente"));
	        //bl.agregarTipoUsuario(0, "Alumnos");
	        //TipoUsuario t = bl.traerTipoUsuario(4);
	        //System.out.println(bl.traerTipoUsuario(4));
	        //t.setTipoUsuario("Alumno");
	        //bl.actualizarTipoUsuario(t);
	        //bl.eliminarTipoUsuario(3);
			
	        
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
