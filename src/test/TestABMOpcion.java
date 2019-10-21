package test;

import java.util.List;

import DAO.Conexion;
import DAO.EntidadDAO;
import datos.Opcion;
import datos.Pregunta;
import datos.TipoUsuario;
import datos.Usuario;
import negocio.OpcionBL;
import negocio.UsuarioBL;

public class TestABMOpcion {

	public static void main(String[] args) {
		OpcionBL bl = new OpcionBL();
		try {
			//bl.agregarOpcion(0, "dsa", 1, new Pregunta(1, "asd", 0));
			//Opcion o = bl.traerOpcion(1);
			//System.out.println(o.toString());
			//System.out.println(bl.existeOpcion(1, "asd"));
			//bl.eliminarOpcion(1);
			//Opcion o = bl.traerOpcion(3);
			//o.setTexto("textoNuevo");
			//bl.actualizarOpcion(o);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
