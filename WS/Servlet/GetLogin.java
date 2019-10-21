package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Req.LoginReq;
import Resp.LoginResp;
import datos.Entidad;
import negocio.EntidadBL;


public class GetLogin extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException{
		Gson gson = new Gson();//objeto que trae funciones de conversión entre clases JAVA y JSON
		LoginReq req = gson.fromJson(request.getParameter("param"), LoginReq.class);
		
		LoginResp resp = new LoginResp();

		try{
			EntidadBL bl=new EntidadBL();
			Entidad e=bl.traerEntidad(req.getMail(),req.getClave());
			if(e!=null) {
				resp.addPaquetes(e);
				resp.setOk("Los datos son correctos. Bienvenido!");
			}else {
				resp.setNo("El usuario no se encuentra registrado :(");
			}
		}
		catch (Exception e){
			resp.setNo(e.getMessage());//Error en general
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(resp));
		out.flush();
	}
}
