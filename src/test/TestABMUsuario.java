package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import datos.TipoUsuario;
import datos.Usuario;
import negocio.UsuarioBL;

public class TestABMUsuario {
	public static UsuarioBL ubl= new UsuarioBL();
	
	
	public static void traer() {
		try {
			Usuario u = ubl.traerUsuario(2);
			System.out.println(u.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void agregar() {
		try {
			LocalDate f = LocalDate.now();
			ubl.agregarUsuario(0, "carlos", "pass", "S", 1, f);
			System.out.println("\n Usuario agregado");
			System.out.println(ubl.traerUsuario("carlos", "pass"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void eliminar() {
		System.out.println("\n\n test eliminar usuario\n");
		try {
			Usuario u = ubl.traerUsuario("carlos", "pass");
			System.out.println(u);
			System.out.println("elimino...\n");
			ubl.eliminarUsuario(u.getIdUsuario());
			System.out.println("intentro traerlo\n");
			ubl.traerUsuario("carlos", "pass");
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void actualizar() {
		try {
			System.out.println("test actualizar\n");
			Usuario u = ubl.traerUsuario(2);
			int id = u.getIdUsuario();
			System.out.println(u);
			System.out.println("modifico");
			u.setMail("nuevoMail");
			ubl.actualizarUsuario(u);
			System.out.println("Usuario modificado");
			System.out.println(ubl.traerUsuario(id));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	
	}

}
