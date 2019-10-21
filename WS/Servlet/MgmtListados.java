package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Req.ReqListados;
import Resp.RespListarPais;
import datos.Pais;
import negocio.PaisBL;


public class MgmtListados extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException{
		Gson gson = new Gson();
		ReqListados req = gson.fromJson(request.getParameter("param"), ReqListados.class);

		switch(req.getCaso()) {
			case "pais":
				traerListarPais(gson,response);
				break;
		}
	}
	private void traerListarPais(Gson gson,HttpServletResponse	response) throws IOException {
		RespListarPais resp = new RespListarPais();
		try{
			PaisBL bl = new PaisBL();
			List<Pais> lista =bl.traerListaPaises();
			for(int p=0;p<lista.size();p++) {
				resp.addPaquetes(lista.get(p));
			}
			resp.setOk();
		}
		catch (Exception e){
			resp.setNo(e.getMessage());
		}

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(resp));
		out.flush();
	}
}