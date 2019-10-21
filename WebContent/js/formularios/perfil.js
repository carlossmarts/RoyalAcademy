function perfil(){

	var definicionFormulario={};
	agregarSeccion(definicionFormulario,"infoperfil");
	definicionFormulario.titulo="Perfil";
	
	cargarFormulario(definicionFormulario);
	
	var definicionInfo={};
	agregarInfo(definicionInfo,"...","p1");
	definicionInfo.tituloSeccion="Aun en desarrollo";
	
	cargarInformativo("infoperfil",definicionInfo);

}