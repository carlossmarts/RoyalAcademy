function preguntas_lista(){
	
	var definicionFormulario={};
	agregarSeccion(definicionFormulario,"infoPreguntas");
	definicionFormulario.titulo="Preguntas";
	
	cargarFormulario(definicionFormulario);
	
	var definicionInfo={};
	definicionInfo.tituloSeccion="Como funciona";
	agregarInfo(definicionInfo,"Una <strong>pregunta</strong> tiene un texto al que se refiere y <strong>una o varias respuestas</strong>","p1");
	agregarInfo(definicionInfo,"Las respuestas pueden ser de <strong>redacción</strong>, <strong>verdadero o falso</strong>, o <strong>múltiple choice</strong>.","p2");
	
	cargarInformativo("infoPreguntas",definicionInfo);
	
}

function preguntas(){
	
	var definicionFormulario={};
	agregarSeccion(definicionFormulario,"infoPreguntas");
	definicionFormulario.titulo="Pregunta - "+escena;
	
	cargarFormulario(definicionFormulario);
	
	var definicionInfo={};
	definicionInfo.tituloSeccion="Aun no implementado";
	agregarInfo(definicionInfo,"...","p1");
	
	cargarInformativo("infoPreguntas",definicionInfo);
}
