
function examenes_lista(){

	var formulario=newFormulario("Exámenes");
	
	var info=newBloque("Como funciona","informativo","info");//definicion de una grilla
	agregarInfo(info,"Un <strong>examen</strong> representa un conjunto de <strong>consignas</strong>, ","p1");
	agregarInfo(info,"y cada consigna representa un conjunto de <strong>preguntas</strong> de diversos tipos.","p1");
	agregarBloque(formulario,info);

	var grilla=newBloque("Lista de exámenes:","grillaExamenes","grilla");//definicion de una grilla
	agregarCampoGrilla(grilla,"ID","idExamen",0,true);
	agregarCampoGrilla(grilla,"Nombre Examen","nombre",120,false);
	agregarCampoGrilla(grilla,"Fecha","fecRegistro",80,false);
	agregarCampoGrilla(grilla,"Preguntas","cantPreguntas",80,false);
	agregarCampoGrilla(grilla,"Activo","estado",80,false);
	agregarCampoGrilla(grilla,"Autor","autor",80,false);
	setPermisosABMV(grilla,true,true,true,true);
	agregarBloque(formulario,grilla);
	

	cargarFormulario(formulario);
	
	//ahora le damos el contenido...
	cargarGrilla("grillaExamenes",resp_examenes);
	
}
function examenes(){
	var formulario=newFormulario("Exámenes - "+escena);
	
	var info=newBloque("No implementado","informativo","info");//definicion de una grilla
	agregarInfo(info,"Aun no está implementado...","p1");
	agregarBloque(formulario,info);

	cargarFormulario(formulario);
}
var resp_examenes = [//registros falsos de prueba
	{
		idExamen:1,
		nombre:"Examen 1",
		fecRegistro:"01/10/2019",
		cantPreguntas:8,
		estado:'si',
		autor:"Agustin"
	},
	{
		idExamen:2,
		nombre:"Examen 2",
		fecRegistro:"05/10/2019",
		cantPreguntas:5,
		estado:'si',
		autor:"Matias"
	},
	{
		idExamen:3,
		nombre:"Examen 4",
		fecRegistro:"09/10/2019",
		cantPreguntas:12,
		estado:'si',
		autor:"Melissa"
	}
];

