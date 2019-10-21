var ventana="";//indica la ventana en la que estamos actualmetne
var escena="";//indica la escena, se cambia desde los botones del menu o desde las grillas
var idTransaccion=0;

window.onload = function () {
	if(controlSesion()){//desktop
		construirSitio();//funciones del sitio...
		
		construirVista();

	}else{//login(index)
		recargarEstaPagina("index.html");
	}
}

function construirSitio(){
	$("#nombreUsuario").html(localStorage.getItem("nombre")+" "+localStorage.getItem("apellido"));	
	$("#cerrarSesion").on("click",function(){
		logoff();
	});
	
	//construimos las opciones:
	var ptrMenu=$(".col_menu:first");
	var listaMenu=[];
	if(localStorage.getItem("tipoUsuario")==1){//opciones para el profe
		listaMenu.push(construirOpcion("examenes","EXAMENES"));
		listaMenu.push(construirOpcion("preguntas","PREGUNTAS"));
		listaMenu.push(construirOpcion("paises","PAISES"));
	}
	
	//colocamos las opciones en el menu
	ptrMenu.append($("<div class='menu_titulo'>Opciones administrador:</div>"));
	for(var m=0;m<listaMenu.length;m++){
		if(m==0){
			listaMenu[m].addClass("menu_selected");
			ventana=listaMenu[m].data("menu");//es la primera opción, va a estar seleccionada
			escena="lista";//por defecto siempre se abre una lista
		}
		ptrMenu.append(listaMenu[m]);
	}
	ptrMenu.append($("<div class='menu_titulo'>Opciones generales:</div>"));
	ptrMenu.append(construirOpcion("perfil","VER PERFIL"));
	ptrMenu.append(construirOpcion("cerrarsesion","CERRAR SESIÓN"));
}
function construirOpcion(clave,texto){
	var opc=$("<div class='menu_opc' data-menu="+clave+"><div class='menu_texto menu_"+clave+"'><span>"+texto+"</span></div><div class='menu_triangulo'></div></div>");
	opc.on("click",function(){
		var k=$(this).data("menu");
		if(k!=ventana || escena!="lista"){
			ventana=k;
			escena="lista";
			idTransaccion=0;
			//estos botones siempre llevan a listas
			//excepto en el caso de PERFIL o CERRAR SESION (pero no afecta)
			$(".menu_selected:first").removeClass("menu_selected");
			$(this).addClass("menu_selected");
			
			construirVista();//mira la variable global "ventana"
		}
	});
	return opc;
}
function construirVista(){
	var promised = llamarWebService("/RoyalAcademy/herramientas/formulario.html", "html", true);
    promised.done(function (data) {
    	
    	var contenedor=$(".col_cont:first");
    	contenedor.html(data);
    	switch(ventana){//multiplexor de archivos CONTROLADORES
    		case "examenes":
    			if(escena=="lista") examenes_lista();
    			else examenes();
    			break;
    		case "preguntas":
    			if(escena=="lista") preguntas_lista();
    			else preguntas();
    			break;
    		case "paises":
    			if(escena=="lista") paises_lista();
    			else paises();
    			break;
    		case "perfil":
    			perfil();
    			break;
    		case "cerrarsesion":
    			logoff();
    			break;
    	}
    });
}
