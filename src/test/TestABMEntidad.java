package test;

import java.time.LocalDate;

import datos.Entidad;
import negocio.EntidadBL;
import negocio.UsuarioBL;

public class TestABMEntidad {
	public static EntidadBL ebl = new EntidadBL();
	public static UsuarioBL ubl = new UsuarioBL();
	
	public static void traer() {
		System.out.println("test traer entidad");
		try {
			System.out.println("\npor id");
			System.out.println(ebl.traerEntidad(2));
			System.out.println("\npor mail y pass");
			System.out.println(ebl.traerEntidad("carlossmarts", "pass"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void agregar() {
		System.out.println("test agregar entidad");
		try {
			System.out.println("\nagregar usuario...");
			int idUsuario = ubl.agregarUsuario(0, "carlossmarts", "pass", "N", 1, LocalDate.now());
			int id = ebl.agregarEntidad(idUsuario, "Martinez", "Carlos", 36161871, LocalDate.of(1991, 03, 28), "NA", 1, 1, 1, "1836", "Mendoza", 119, "");
			System.out.println("\nagregado");
			System.out.println(ebl.traerEntidad(id));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void eliminar() {
		System.out.println("test eliminar entidad");
		try {
			System.out.println("\ntraer...");
			System.out.println(ebl.traerEntidad(3));
			System.out.println("\neliminar...");
			ebl.eliminarEntidad(3);
			System.out.println("\neliminado");
			System.out.println(ebl.traerEntidad(3));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void modificar() {
		System.out.println("test modificar entidad");
		try {
			System.out.println("\ntraer...");
			Entidad e = ebl.traerEntidad(3);
			System.out.println(e);
			System.out.println("\nModifico...");
			e.setDocumento(12345678);
			e.setMail("nuevoMail");
			ebl.modificarEntidad(e);
			System.out.println("\nmodificado");
			System.out.println(ebl.traerEntidad(3));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
