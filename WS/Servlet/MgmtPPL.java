package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import Req.PplReq;
import Resp.ProvinciaResp;
import datos.Provincia;
import negocio.ProvinciaBL;


public class MgmtPPL extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException{
		Gson gson = new Gson();
		PplReq req = gson.fromJson(request.getParameter("param"), PplReq.class);

		
		switch(req.getCaso()) {
			case "provinciasSinRelacion":
				provinciaMgmt(gson,req,	response);
				break;
		}
	}
	private void provinciaMgmt(Gson gson,PplReq req,HttpServletResponse	response) throws IOException {
		ProvinciaResp resp = new ProvinciaResp();
		try{
			ProvinciaBL bl = new ProvinciaBL();
			List<Provincia> lista =bl.traerListaProvincias(req.getIdPais(), req.getListaIdProvincia());
			for(int p=0;p<lista.size();p++) {
				resp.addPaquetes(lista.get(p));
			}
			resp.setOk();
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
