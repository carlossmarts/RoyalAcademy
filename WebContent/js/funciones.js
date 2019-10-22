
window.onload = function () {
	
	var btn_entrar=$("#btn_entrar");
	btn_entrar.on("click",function(){
		var mail = $("input[name='mail']");
		var clave=$("input[name='clave']");
		if(mail.val().trim()!="" && clave.val().trim()!=""){
			console.log("mandamos al servidor");
			var param={
				mail:mail.val(),
				clave:clave.val()
			};
		    var promised = llamarWebService("/RoyalAcademy/GetLogin", "json", true, param);
		    promised.done(function (data) {
		        console.log(data);
		        alert(data.mensaje);
		    });
		}else{
			alert("Te faltan completar datos");
		}
	});
}
function llamarWebService(ws, dataType, asincrono, param) {
	console.log(param);
    if (typeof dataType == "undefined") dataType = "json";
    if (typeof asincrono == "undefined") asincrono = false;
    if (typeof param == "undefined") param = {};//vacío
    console.log("REQUEST->"+ws);
    var type = "POST";
    if (dataType == "html") type = "GET";
    return $.ajax({
        type: type,
        url: ws,
        data:{param:JSON.stringify(param)},
        dataType: dataType,
        async: asincrono,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}

