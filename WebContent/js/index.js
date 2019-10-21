
window.onload = function () {
	if(controlSesion()){//desktop
		recargarEstaPagina("desktop.html");
	}else{//login(index)
		var btn_entrar=$("#btn_entrar");
		btn_entrar.on("click",function(){
			var mail = $("input[name='mail']");
			var clave=$("input[name='clave']");
			if(mail.val().trim()!="" && clave.val().trim()!=""){
				//console.log("mandamos al servidor");
				var param={
					mail:mail.val(),
					clave:clave.val()
				};
			    var promised = llamarWebService("/RoyalAcademy/GetLogin", "json", true, param);
			    promised.done(function (data) {
			        alert(data.mensaje);
			        if(data.estado){//loginOK
			        	cargarDatosUsuario(data.paquetes[0]);
			        	recargarEstaPagina("desktop.html");
			        }
			    });
			}else{
				alert("Te faltan completar datos");
			}
		});
	}
}