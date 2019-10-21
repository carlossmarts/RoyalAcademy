var listaDefGrillas=[];

function llamarWebService(ws, dataType, asincrono, param) {
    if (typeof dataType == "undefined") dataType = "json";
    if (typeof asincrono == "undefined") asincrono = false;
    if (typeof param == "undefined") param = {};//vacío
    var type = "POST";
    if (dataType == "html"|| dataType == "charset=utf-8") type = "GET";
    if(dataType!="html"){
    	console.log("REQUEST->"+ws+"->");
    	console.log(param);
    }
    return $.ajax({
        type: type,
        url: ws,
        data:{param:JSON.stringify(param)},
        dataType: dataType,
        async: asincrono,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log("ERROR: "+textStatus);
        }
    });
}
function logoff(){
	cargarDatosUsuario();
	recargarEstaPagina("index.html");
}
function controlSesion(){
	return (localStorage.getItem("id") != null);//hay alguien en sesion
}
function recargarEstaPagina(nueva_url) {
    location.href = "/RoyalAcademy/"+nueva_url;
}
function cargarDatosUsuario(usuario) {
    if (usuario != null) {
        localStorage.setItem('id', usuario.idUsuario);
        localStorage.setItem('apellido', usuario.apellido);
        localStorage.setItem('nombre', usuario.nombre);
        localStorage.setItem('mail', usuario.mail);
        localStorage.setItem('tipoUsuario', usuario.idTipoUsuario);
    } else {
        localStorage.removeItem("id");
        localStorage.removeItem("apellido");
        localStorage.removeItem("nombre");
        localStorage.removeItem("mail");
        localStorage.removeItem("tipoUsuario");
    }
}
function agregarCampoGrilla(bloque,etiqueta,atributo,tamanio,esClave){
	var col = {
			atributo:atributo,
			etiqueta:etiqueta,
			tamanio:tamanio,
			campoClave:esClave
	};
	if(bloque.listaColumnas==undefined){
		bloque.tamanioTotal=0;
		bloque.listaColumnas=[];
	}
	bloque.listaColumnas.push(col);
	bloque.tamanioTotal+=tamanio;
}
function agregarBloque(formulario,bloque){

	if(formulario.listaBloques==undefined){
		formulario.listaBloques=[];
	}
	
	formulario.listaBloques.push(bloque);
}

function newColumna(visible){
	if(visible==undefined)visible=true;
	var col_aux = {
		visible:visible,
		listaCampos:[]
	};
	return col_aux;
}
function newFila(){
	var fila_aux = {
		listaColumnas:[]
	};
	return fila_aux;
}
function agregarFila(def,fila){
	if(def.listaFilas==undefined){
		def.listaFilas=[];
	}
	def.listaFilas.push(fila);
}
function agregarColumna(defFila,defCol){
	if(defFila.listaColumnas==undefined){
		defFila.listaColumnas=[];
	}
	defFila.listaColumnas.push(defCol);
}

function agregarCampoSimple(columna,etiqueta,id,tipo,visible,editable){
	var campo_aux={
			id:id,
			etiqueta:etiqueta,
			tipo:tipo,
			visible:visible,
			editable:editable
	};
	if(columna.listaCampos==undefined){
		columna.listaCampos=[];
	}
	columna.listaCampos.push(campo_aux);
	return campo_aux;//retorno un puntero a ese objeto en la lista
}
function cargarFormulario(definicion){
	
	$(".cont_titulo_texto:first span:first").html(definicion.titulo);//cargo el titulo
	var contenedor=$(".cont_pag:first");
	contenedor.html("");//borramos el contenido;
	listaDefGrillas=[];//borramos las definiciones globales de grillas;
	
	for (var f=0;f<definicion.listaBloques.length;f++){
		var bloqueDef=definicion.listaBloques[f];
		var bloque=$("<div class='bloque' data-bloque='"+bloqueDef.id+"' data-tipo='"+bloqueDef.tipo+"'></div>");
		switch(bloqueDef.tipo){
			case "grilla":
				construirGrilla(bloque,bloqueDef);
				break;
			case "info":
				cargarInformativo(bloque,bloqueDef);
				break;
			case "simple":
				cargarBloqueSimple(bloque,bloqueDef);
				break;
		}
		contenedor.append(bloque);
	}
	if(definicion.listaFinalCallback!=undefined){
		var bloqueBotones=$("<div class='bloque bloque_final' data-tipo='finalCallback'></div>");
		for(var cb=0;cb<definicion.listaFinalCallback.length;cb++){
			var dataCB=definicion.listaFinalCallback[cb];
			if(!(dataCB.caracter && escena=="ver") || dataCB.caracter==false){//si el caracter del callback es positivo entonces no se dibuja en escena "ver"
				var btn_aux=$("<div class='btn_callback'>"+dataCB.texto+"</div>");
				btn_aux.on("click",dataCB.callback);
				bloqueBotones.append(btn_aux);
			}
		}
		contenedor.append(bloqueBotones);
	}
}
function getRegistros(idGrilla){
	var listaRegistros_aux=[];
	var definicion=traerDefinicionGrilla(idGrilla);
	
	$(".bloque[data-bloque='"+idGrilla+"'] .grilla:first .g_registros:first .g_reg").each(function(){
		var registro_aux=[];
		listaCampos=$(this).find(".g_cen:first .g_campo");
		var coma="";
		var campo_aux="";
		for(var c=0;c<listaCampos.length;c++){
			campo_aux+=coma+"\""+definicion.listaColumnas[c].atributo+"\":\""+$(listaCampos[c]).text()+"\"";
			if(c==0)coma=",";
		}
		listaRegistros_aux.push(JSON.parse("{"+campo_aux+"}"));
	});
	
	return listaRegistros_aux;
}
function setOpcionFinal(defFormulario,texto,callback,caracter){
	var callback_aux={
			texto:texto,
			callback:callback,
			caracter:caracter
	};
	if(defFormulario.listaFinalCallback==undefined){
		defFormulario.listaFinalCallback=[];
	}
	defFormulario.listaFinalCallback.push(callback_aux);
}
function cargarBloqueSimple(ptrBloque,bloqueDef){
	
	var cont=$("<div class='bloque_cont'><h2>"+bloqueDef.titulo+"</h2></div>");

	var listaFilas=bloqueDef.listaFilas;
	for(var f=0;f<listaFilas.length;f++){
		var fila_aux = $("<div class='s_fila'></div>");
		var listaColumnas=listaFilas[f].listaColumnas;
		for(var c=0;c<listaColumnas.length;c++){
			
			var colVisible="";
			if(listaColumnas[c].visible==false)colVisible=" visible_no";
			var columna_aux = $("<div class='s_columna"+colVisible+"'></div>");
			
			var listaCampos=listaColumnas[c].listaCampos;
			
			for(var ca=0;ca<listaCampos.length;ca++){
				var campo_def=listaCampos[ca];
				var imput=construirImput(campo_def);
				var visible_no="";
				
				if(campo_def.visible==false)visible_no=" visible_no";
				var campo =$("<div class='campo"+visible_no+"' data-campo='"+campo_def.id+"' data-tipo='"+campo_def.tipo+"'><div class='campo_etiqueta'><span>"+campo_def.etiqueta+"</span></div><div class='campo_cont'>"+imput+"</div></div>");
				//console.log(listaCampos);
				columna_aux.append(campo);
			}
			fila_aux.append(columna_aux);
		}
		cont.append(fila_aux);
	}
	ptrBloque.append(cont);
	//console.log(bloqueDef);
}
function resolverEdicion(tipo,editable){
	var permisoEdicion="";
	if(editable==false || escena=="baja" || escena == "ver"){
		switch(tipo){
			case"input":
				permisoEdicion=" readonly";
				break;
			case"select":
				permisoEdicion=" disabled";
				break;
		}
	}
	return permisoEdicion;
}
function volverAlListar(){
	escena="lista";
	idTransaccion=0;
	construirVista();
}
function construirImput(campo){
	var imput="";
	var readonly=resolverEdicion(campo.tipo,campo.editable);
	switch(campo.tipo){
	case "input":
		
		imput="<input type='text' "+readonly+"/>";
		break;
	case "select":
		var opc="";
		for(var o=0;o<campo.listaOpciones.length;o++){
			var defOpcion=campo.listaOpciones[o];
			var selected="";
			if(defOpcion.selected)selected="selected";
			opc+="<option "+selected+" value='"+defOpcion.valor+"'>"+defOpcion.texto+"</option>";
		}
		imput="<select "+readonly+">"+opc+"</select>";
		break;
	}
	return imput;
}
function agregarOpcionSelect(defSelect,valor,texto,selected){
	var opc_aux={
			valor:valor,
			texto:texto,
			selected:selected
	};
	if(defSelect.listaOpciones==undefined){
		defSelect.listaOpciones=[];
	}
	defSelect.listaOpciones.push(opc_aux);
}
function agregarInfo(definicion,texto,codParrafo){
	if(definicion.parrafos==undefined){
		definicion.parrafos=[];
	}
	var existe=false;
	for(var p=0;p<definicion.parrafos.length;p++){
		if(definicion.parrafos[p].codParrafo==codParrafo){
			definicion.parrafos[p].lineas.push(texto);
			existe=true;
			p=definicion.parrafos.length;//salgo del bucle
		}
	}
	if(!existe){
		var parrafo = {
				codParrafo:codParrafo,
				lineas:[texto]
		};
		definicion.parrafos.push(parrafo);
	}
}
function cargarInformativo(ptrBloque,definicion){
	
	var listaParrafos="";
	for(var p=0;p<definicion.parrafos.length;p++){
		var parrafo_aux="<p>";
		for(var l=0;l<definicion.parrafos[p].lineas.length;l++){
			parrafo_aux+=definicion.parrafos[p].lineas[l];
    	}
		parrafo_aux+="</p>";
		listaParrafos+=parrafo_aux;
	}
	ptrBloque.html("<div class='bloque_cont'><h2>"+definicion.titulo+"</h2>"+listaParrafos+"</div>");

}
function setPermisosABMV(bloque,alta,baja,modif,ver){
	bloque.permisos={
		alta:alta,
		baja:baja,
		modif:modif,
		ver:ver
	};
}
function crearOpcionGrilla(accion,texto,callback){
	var opc=$("<div class='g_campo_btn btn_"+accion+"' data-escena='"+accion+"'>"+texto+"</div>");
	
	if(escena=="lista"){
		opc.on("click",function(){
			escena=accion;
			if(escena!="alta"){
				idTransaccion=$(this).closest(".g_reg").data("reg");
				//console.log("VENTANA: "+ventana+", ESCENA: "+escena+", ID: "+idTransaccion);
			}else{
				idTransaccion=0;
				//console.log("VENTANA: "+ventana+", ESCENA: "+escena+", ID: no, será uno nuevo");
			}
			construirVista();//nos envía a otro formulario con la escena y el id de la transacción ya cargado
		});
	}else{
		switch(accion){
			case "alta":
			case "cerrar":
				if(callback==null){
					opc.on("click",function(){
						alert("No hay accion callback asociado a este botón");
					});
				}else{
					opc.on("click",callback);//activa la función que le pasamos por callback
				}
				break;
			case "seleccionar":
				opc.on("click",function(){
					var idGrilla=$(this).closest(".tarjetaSeleccion").data("retorno");
					//alert("Retornamos a "+idGrilla);
					var definicion = traerDefinicionGrilla(idGrilla);
					var resp="";
					var lista_reg_aux=$(this).closest(".g_reg").find(".g_cen:first .g_campo");
					var coma="";
					for(var l=0;l<lista_reg_aux.length;l++){
						resp+=coma+"\""+definicion.listaColumnas[l].atributo+"\":\""+$(lista_reg_aux[l]).text()+"\"";
					if(l==0)coma=",";
					}
					resp=JSON.parse("{"+resp+"}");
					cargarGrilla(idGrilla,[resp]);
					cerrarTarjeta();
				});
				break;
			case "baja":
				opc.on("click",function(){
					var ptrGrilla=$(this).closest(".grilla");
					var ptrRegistros=$(this).closest(".g_registros");
					$(this).closest(".g_reg ").remove();//borro la linea
					ajustarAparienciaGrilla(ptrGrilla,ptrRegistros);

				});
				break;
			}
	}
	return opc;
}
function cargarTarjetaSeleccion(idGrilla,resp){
	var ptrPantalla = $(".pantallaGris:first");
	
	var ptrTarjeta = $("<div class='tarjetaSeleccion' data-retorno=''></div>");
	ptrPantalla.find(".g_center_tarjeta:first").append(ptrTarjeta);

	var definicion=traerDefinicionGrilla(idGrilla);//tenemos la definición de la grilla
	
	construirTarjetaSeleccion(ptrTarjeta,definicion);//le pasamos el ptr de la tarjeta!!
	
	var ptrGrilla=ptrTarjeta.find(".grilla:first");
	var ptrRegistros=ptrGrilla.find(".g_registros:first");
	
	for(var r=0;r<resp.length;r++){
		var dataResp=resp[r];
		ptrRegistros.append(crearLineaRegistroSeleccion(definicion,dataResp));
	}
	ajustarAparienciaGrilla(ptrGrilla,ptrRegistros);
	
	ptrPantalla.addClass("showPantalla");

}
function crearLineaRegistroSeleccion(definicion,dataResp){
	var reg_aux=$("<div class='g_reg' data-reg=0></div>");
	var iz=$("<div class='g_izq'><div class='g_campo'>...</div></div>");
	
	var cen=$("<div class='g_cen'></div>");
	
	for(var d=0;d<definicion.listaColumnas.length;d++){
		var col_aux=definicion.listaColumnas[d];
		cen.append(crearCampo(dataResp[col_aux.atributo],col_aux.tamanio));
		if(col_aux.campoClave) reg_aux.data("reg",dataResp[col_aux.atributo]);
	}
	
	var der=$("<div class='g_der'></div>");
	
	var listaOpciones=[];
	listaOpciones.push(crearOpcionGrilla("seleccionar","Traer"));
	
	for(var o=0;o<listaOpciones.length;o++){
		der.append(listaOpciones[o]);
	}
	reg_aux.append(iz);
	reg_aux.append(cen);
	reg_aux.append(der);
	
	return reg_aux;
}
function construirTarjetaSeleccion(ptrTarjeta,definicion){
	
	var promised = llamarWebService("/RoyalAcademy/herramientas/grilla.html", "html", false);
    promised.done(function (data) {
    	
    	ptrTarjeta.html(data);
    	ptrTarjeta.data("retorno",definicion.id);
    	ptrTarjeta.find("h2:first").html(definicion.titulo);
    	
    	var ptrGrilla=ptrTarjeta.find(".grilla:first");
    	
    	var anchoNro=40;
    	var anchoOpciones=80;
    	
    	var cantOpciones=1;
    	
    	var anchoContenedor=(anchoNro+(anchoOpciones*cantOpciones)+definicion.tamanioTotal);
    	var cont=ptrGrilla.find(".g_cont:first");
    	cont.attr("style","width: "+anchoContenedor+"px !important");
    	
    	var titulos=ptrGrilla.find(".g_titulo_reg:first");
    	
    	var t_centro=titulos.find(".g_cen:first");

    	for(var d=0;d<definicion.listaColumnas.length;d++){
    		var col_aux=definicion.listaColumnas[d];
    		t_centro.append(crearCampo(col_aux.etiqueta,col_aux.tamanio));
    	}
    	
		var t_der=titulos.find(".g_der:first");
		t_der.append(crearOpcionGrilla("cerrar","Cerrar",cerrarTarjeta));

    	ptrGrilla.find(".g_pie:first .g_cant_reg:first").html("Cantidad de registros: 0");
    	
    });
}
function cerrarTarjeta(){
	var ptrPantalla=$(".pantallaGris:first");
	ptrPantalla.removeClass("showPantalla");
	ptrPantalla.find(".g_center_tarjeta:first").html("");
}

function construirGrilla(ptrBloque,definicion){
	
	var promised = llamarWebService("/RoyalAcademy/herramientas/grilla.html", "html", false);
    promised.done(function (data) {
    	
    	listaDefGrillas.push(definicion);
    	
    	ptrBloque.html(data);
    	ptrBloque.find("h2:first").html(definicion.titulo);
    	
    	var ptrGrilla=ptrBloque.find(".grilla:first");
    	
    	var anchoNro=40;
    	var anchoOpciones=80;
    	
    	var cantOpciones=0;
    	if(definicion.permisos.baja)cantOpciones++;
    	if(definicion.permisos.modif)cantOpciones++;
    	if(definicion.permisos.ver)cantOpciones++;
    	
    	var anchoContenedor=(anchoNro+(anchoOpciones*cantOpciones)+definicion.tamanioTotal);
    	var cont=ptrGrilla.find(".g_cont:first");
    	cont.attr("style","width: "+anchoContenedor+"px !important");
    	
    	var titulos=ptrGrilla.find(".g_titulo_reg:first");
    	
    	var t_centro=titulos.find(".g_cen:first");

    	for(var d=0;d<definicion.listaColumnas.length;d++){
    		var col_aux=definicion.listaColumnas[d];
    		t_centro.append(crearCampo(col_aux.etiqueta,col_aux.tamanio));
    	}
    	
    	if(definicion.permisos.alta){
    		if(escena=="lista" || escena=="alta" || escena=="modif"){
    			var t_der=titulos.find(".g_der:first");
    			switch(escena){
    			case "lista":
    				t_der.append(crearOpcionGrilla("alta","Nuevo registro"));
    				break;
    			case "alta":
    			case "modif":
    				t_der.append(crearOpcionGrilla("alta","Agregar registro",definicion.callback));
    				break;
    			}
    		}
    	}
    	ptrGrilla.find(".g_pie:first .g_cant_reg:first").html("Cantidad de registros: 0");
    	
    });
}
function crearCampo(etiqueta,tamanio){
	return $("<div class='g_campo' style='width:"+tamanio+"px;'>"+etiqueta+"</div>");
}
function traerDefinicionGrilla(idGrilla){
	var def_aux=null;
	for(var g=0;g<listaDefGrillas.length;g++){
		if(listaDefGrillas[g].id==idGrilla){
			def_aux=listaDefGrillas[g];
			g=listaDefGrillas.length;//salimos
		}
	}
	return def_aux;
}
function cargarGrilla(idGrilla,resp){
	var definicion=traerDefinicionGrilla(idGrilla);//tenemos la definición de la grilla
	var ptrGrilla=$(".bloque[data-bloque='"+idGrilla+"'] .grilla:first");
	var ptrRegistros=ptrGrilla.find(".g_registros:first");
	
	for(var r=0;r<resp.length;r++){
		var dataResp=resp[r];
		ptrRegistros.append(crearLineaRegistro(definicion,dataResp));
	}
	ajustarAparienciaGrilla(ptrGrilla,ptrRegistros);
}
function ajustarAparienciaGrilla(ptrGrilla,ptrRegistros){
	var cantReg=0;
	var impar=false;
	ptrRegistros.find(".g_reg").each(function(){
		cantReg++;
		
		$(this).find(".g_izq:first .g_campo:first").text(cantReg);
		impar=!impar;
		if(impar)$(this).addClass("reg_impar");
		else $(this).removeClass("reg_impar");
	});
	var altoVentana= 35+(35*cantReg)+2;

	var g_ventana = ptrGrilla.find(".g_ventana:first");
	g_ventana.attr("style","height: "+altoVentana+"px !important");
	
	ptrGrilla.find(".g_pie:first .g_cant_reg:first").html("Cantidad de registros: "+cantReg);
}
function crearLineaRegistro(definicion,dataResp){
	var reg_aux=$("<div class='g_reg' data-reg=0></div>");
	var iz=$("<div class='g_izq'><div class='g_campo'>...</div></div>");
	
	var cen=$("<div class='g_cen'></div>");
	
	for(var d=0;d<definicion.listaColumnas.length;d++){
		var col_aux=definicion.listaColumnas[d];
		cen.append(crearCampo(dataResp[col_aux.atributo],col_aux.tamanio));
		if(col_aux.campoClave) reg_aux.data("reg",dataResp[col_aux.atributo]);
	}
	
	var der=$("<div class='g_der'></div>");
	
	var listaOpciones=[];
	if(definicion.permisos.baja)listaOpciones.push(crearOpcionGrilla("baja","Borrar"));
	if(definicion.permisos.modif)listaOpciones.push(crearOpcionGrilla("modif","Editar"));
	if(definicion.permisos.ver)listaOpciones.push(crearOpcionGrilla("ver","Ver"));
	
	for(var o=0;o<listaOpciones.length;o++){
		der.append(listaOpciones[o]);
	}
	reg_aux.append(iz);
	reg_aux.append(cen);
	reg_aux.append(der);
	
	return reg_aux;
}
function newFormulario(titulo){
	return {titulo:titulo};
}
function newBloque(titulo,id,tipo,callback){
	var bloque={
		id:id,
		tipo:tipo,
		titulo:titulo,
	};
	if((escena=="alta" || escena=="modif") && tipo=="grilla"){
		if(callback==null)bloque.callback=alertaFaltaCallback;
		else bloque.callback=callback;
	}
	return bloque;
}
function alertaFaltaCallback(){
	alert("falta asignar una acción como callback");
}
function setValores(idBloque,idCampo,valor){
	var ptrBloque=$(".bloque[data-bloque='"+idBloque+"']:first");
	if(ptrBloque.data("tipo")=="grilla"){//traigo una lista de valores o una lista vacia
		alert("No deberías intentar modificar los valores de la grilla "+idBloque+", no es del tipo modificable...");
	}else{
		var ptrCampo=ptrBloque.find(".campo[data-campo='"+idCampo+"']:first");
		insertarValorCampo(ptrCampo,valor);
	}
}
function insertarValorCampo(ptrCampo,valor){
	switch(ptrCampo.data("tipo")){
		case "input":
			ptrCampo.find("input:first").val(valor);
			break;
		case "select":
			ptrCampo.find("select:first").val(valor);
			break;
		case "textarea":
			ptrCampo.find("textarea:first").val(valor);
			break;
		case "checkbox":
			//todo: es más complejo
			//ptrCampo.find("input:first").val(valor);
			break;
	}
}
function getValores(idBloque,idCampo){
	var retorno=null;
	var ptrBloque=$(".bloque[data-bloque='"+idBloque+"']:first");
	if(ptrBloque.data("tipo")=="grilla"){//traigo una lista de valores o una lista vacia
		retorno=[];

		var defGrilla=traerDefinicionGrilla(idBloque);
		
		var idGrilla=defGrilla.id;
		var indexCol=0;
		var salir=false;
		for(var c=0;c<defGrilla.listaColumnas.length && salir==false;c++){
			if(defGrilla.listaColumnas[c].atributo==idCampo){
				indexCol=c;//indice de la columna
				salir=true;
			}
		}
		
		ptrBloque.find(".g_registros:first .g_reg").each(function(){
			retorno.push($(this).find(".g_cen:first .g_campo:nth-child("+c+")").text());
		});
	}else{
		var ptrCampo=ptrBloque.find(".campo[data-campo='"+idCampo+"']:first");
		retorno=obtenerValorCampo(ptrCampo);
	}
	return retorno;
}
function obtenerValorCampo(ptrCampo){
	var valor="";
	switch(ptrCampo.data("tipo")){
		case "input":
			console.log(ptrCampo);
			valor=ptrCampo.find("input:first").val();
			break;
		case "select":
			valor=ptrCampo.find("select:first").val();
			break;
		case "textarea":
			valor=ptrCampo.find("textarea:first").val();
			break;
		case "checkbox":
			valor=ptrCampo.find("input:first").val();
			break;
	}
	return valor;
}