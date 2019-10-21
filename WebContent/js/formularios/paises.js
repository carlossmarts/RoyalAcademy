
function paises_lista(){

	var formulario=newFormulario("Paises");
	var info=newBloque("Como funciona","informativo","info");//definicion de una grilla
	agregarInfo(info,"Cada <strong>pais</strong> contiene una lista de <strong>provincias</strong> ","p1");
	agregarInfo(info,"previamente creadas en su formulario.","p2");
	agregarBloque(formulario,info);

	var grilla=newBloque("Lista de paises:","listaPaises","grilla");//definicion de una grilla
	agregarCampoGrilla(grilla,"ID","idPais",100,true);
	agregarCampoGrilla(grilla,"Pais","pais",120,false);
	agregarCampoGrilla(grilla,"Estado","estado",80,false);
	setPermisosABMV(grilla,true,true,true,true);
	agregarBloque(formulario,grilla);
	
	cargarFormulario(formulario);
	
	//ahora traemos el contenido
	traerListadoPais();
}

function paises(){
	
	var formulario=newFormulario("Paises - "+escena);
	setOpcionFinal(formulario,"Guardar cambios",guardarTrabajoPais,true);
	setOpcionFinal(formulario,"Salir",salirAListaPais,false);
	
	var info=newBloque("Como funciona","informativo","info");//definicion de una grilla
	agregarInfo(info,"Cada <strong>pais</strong> contiene una lista de <strong>provincias</strong> ","p1");
	agregarInfo(info,"previamente creadas en su formulario.","p1");
	agregarBloque(formulario,info);

	var columna1= newColumna(false);
	agregarCampoSimple(columna1,"ID","idPais","input",true,false);
	var columna2= newColumna();
	agregarCampoSimple(columna2,"Pais","pais","input",true,true);
	var columna3= newColumna();
	var select1 = agregarCampoSimple(columna3,"Estado","estado","select",true,true);
	agregarOpcionSelect(select1,'S','Activo',false);
	agregarOpcionSelect(select1,'N','Inactivo',true);
	agregarOpcionSelect(select1,'N','Otra',true);
	
	var fila1=newFila();
	agregarColumna(fila1,columna1);
	agregarColumna(fila1,columna2);
	agregarColumna(fila1,columna3);
	
	var simple=newBloque("Encabezado del pais:","encabezado","simple");//definicion de un bloque simple
	agregarFila(simple,fila1);
	agregarBloque(formulario,simple);
	
	
	var grilla=newBloque("Lista de provincias:","detalle","grilla",getProvinciasSinRelacionar);//definicion de una grilla
	agregarCampoGrilla(grilla,"ID Provincia","idProvincia",100,true);
	agregarCampoGrilla(grilla,"Provincia","provincia",120,false);
	setPermisosABMV(grilla,true,true,false,false);
	agregarBloque(formulario,grilla);
	
	cargarFormulario(formulario);

	//traigo los datos para la escena
	switch(escena){
		case "alta":
			setValores("encabezado","idPais",0);
			break;
		case "baja":
		case "modif":
		case "ver":
			traerFormularioPais();
			break;
	}
}

function traerListadoPais(){
	var param={
			caso:"pais"
	};
	
	var promised = llamarWebService("/RoyalAcademy/getListados", "json", true, param);
    promised.done(function (data) {
    	var resp=data.paquetes;
    	cargarGrilla("listaPaises",resp);
    });
}
function traerFormularioPais(){
	var param={
			escena:"traer",
			pais:{
				idPais:idTransaccion,
				pais:"",
				estado:""
			},
			listaProvincias:[],
	};
    var promised = llamarWebService("/RoyalAcademy/mgmtPais", "json", false, param);
    promised.done(function (data) {
    	if(data.estado){
    		var formulario=data.paquetes;
    		var paisData=formulario.pais;
    		setValores("encabezado","idPpais",paisData.idPais);
        	setValores("encabezado","pais",paisData.pais);
        	setValores("encabezado","estado",paisData.estado);

        	cargarGrilla("detalle",formulario.listaProvincias);
    	}else{
    		alert(data.mensaje);
    	}
    });
}
function getProvinciasSinRelacionar(){
	
	var listaValores = getValores("detalle","idProvincia");
	var idPais = idTransaccion;//getValores("encabezado","idPais");
	
	var param={
			caso:"provinciasSinRelacion",
			listaIdProvincia:listaValores,
			idPais:idPais//verificar que sea un entero, sino usar parseInt(idPais,10)
	};
    var promised = llamarWebService("/RoyalAcademy/getRelacionesPPL", "json", true, param);
    promised.done(function (data) {
        if(data.estado){
        	cargarTarjetaSeleccion("detalle",data.paquetes);
        }else{
        	alert(data.mensaje);
        }
    });
}
function guardarTrabajoPais(){
	var param={
			escena:escena,//alta,baja,modif
			pais:{
				idPais:idTransaccion,//getValores("encabezado","idPais"),
				pais:getValores("encabezado","pais"),
				estado:getValores("encabezado","estado")
			},
			listaProvincias:getRegistros("detalle")
	};
	
    var promised = llamarWebService("/RoyalAcademy/mgmtPais", "json", false, param);
    promised.done(function (data) {
    	console.log(data)
    	if(data.estado){
    		alert("Datos guardados satisfactoriamente :)");
    		volverAlListar();
    	}else{
    		alert(data.mensaje);
    	}
    });
}
function salirAListaPais(){
	volverAlListar();
}
