package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Req.FormularioPais;
import Resp.RespFormularioPais;
import datos.Provincia;
import negocio.PaisBL;
import negocio.ProvinciaBL;


public class MgmtPais extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException{
		Gson gson = new Gson();
		FormularioPais req = gson.fromJson(request.getParameter("param"), FormularioPais.class);

		RespFormularioPais resp = new RespFormularioPais();
		switch(req.getEscena()) {
			case "traer":
				verFormularioPais(resp, req, response);
				break;
			case "alta":
				altaFormularioPais(resp, req, response);
				break;
			case "modif":
				modificarFormularioPais(resp, req, response);
				break;
			case "baja":
				bajaFormularioPais(resp, req, response);
				break;
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(resp));
		out.flush();
	}
	private void altaFormularioPais(RespFormularioPais resp,FormularioPais req,HttpServletResponse	response) throws IOException {
		try{
			PaisBL paisBL = new PaisBL();
			paisBL.crearPais(
					req.getPais().getIdPais(),
					req.getPais().getPais(),
					req.getPais().getEstado(),
					req.getListaProvincias()
					);
			resp.setOk();
		}
		catch (Exception e){
			resp.setNo(e.getMessage());
		}
	}
	private void verFormularioPais(RespFormularioPais resp,FormularioPais req,HttpServletResponse	response) throws IOException {
		try{
			FormularioPais formulario = new FormularioPais();
			PaisBL paisBL = new PaisBL();
			ProvinciaBL provinciaBL = new ProvinciaBL();
			formulario.setPais(paisBL.traerPais(req.getPais().getIdPais()));
			List<Provincia> lista = provinciaBL.traerListaProvinciasPorPais(req.getPais().getIdPais());
			if(lista!=null)formulario.setListaProvincias(lista);
			resp.setPaquetes(formulario);//guardo el formulario en paquetes
			resp.setOk();
		}
		catch (Exception e){
			resp.setNo(e.getMessage());
		}
	}
	private void modificarFormularioPais(RespFormularioPais resp,FormularioPais req,HttpServletResponse	response) throws IOException {
		try{
			//todo...
			resp.setOk();
		}
		catch (Exception e){
			resp.setNo(e.getMessage());
		}
	}
	private void bajaFormularioPais(RespFormularioPais resp,FormularioPais req,HttpServletResponse	response) throws IOException {
		try{
			//todo...
			resp.setOk();
		}
		catch (Exception e){
			resp.setNo(e.getMessage());
		}
	}
}