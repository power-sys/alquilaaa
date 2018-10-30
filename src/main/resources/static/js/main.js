        var header = document.getElementById("userbtn");
        var btns = header.getElementsByClassName("btn");
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", function() {
                var current = document.getElementsByClassName("active");
                if (current.length > 0) {
                    current[0].className = current[0].className.replace(" active", "");
                }
                this.className += " active";
            });
        }

        var tipoB = document.getElementById("userbtn");
        var btns = tipoB.getElementsByClassName("tipo");
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", function() {
                var current = document.getElementsByClassName("selected");
                if (current.length > 0) {
                    current[0].className = current[0].className.replace(" selected", "");
                }
                this.className += " selected";
            });
        }

        var expBtn = document.getElementById("expensas");
        var btns = expBtn.getElementsByClassName("monto");
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", function() {
                var current = document.getElementsByClassName("expselected");
                if (current.length > 0) {
                    current[0].className = current[0].className.replace(" expselected", "");
                }
                this.className += " expselected";
            });
        }

 


$("#departamento").click(function(){
	$('#AuxTipo').val("Departamento");
})

$("#casa").click(function(){
	$('#AuxTipo').val("Casa");
})

$("#BtnPublicar").click(function(){
	direccion();
	cantHab();
	infoLegal();
	msgAnuncio();	
})

function direccion(){
	var calle= document.getElementsByName('calle')[0].value;
	var altura= document.getElementsByName('altura')[0].value;
	var piso= document.getElementsByName('piso')[0].value;
	var departamento= document.getElementsByName('departamento')[0].value;
	
	var direccion = calle + " " + altura + " " + piso + " " + departamento;	
	$('#AuxDir').val(direccion);
}

function cantHab(){
	if($('#radio1').is(":checked")){
		var cant = "1 habitacion"
	}else if($('#radio2').is(":checked")){
		var cant = "2 habitaciones"
	}else if($('#radio3').is(":checked")){
		var cant = "3 habitaciones"
	}else{
		var cant = "4 habitaciones"
	}
	$('#AuxDetInm').val($('#ingresartexto').val() + ", " + cant);
	
}

function msgAnuncio(){
	if(document.getElementsByName('calle')[0].value != "" && document.getElementsByName('altura')[0].value != ""
		&& $('#ingresartexto').val() != "" && $('#legal').val() != "" && $('#otrosDetalles').val() != "" 
		&& $('#monto').val() != ""){		
		window.alert("Se registro el anuncio con exito")
	}
}

function infoLegal(){
	if($('#gsi').is(":checked")){
		var detGarante = "con garante"
	}else if($('#gno').is(":checked")){
		var detGarante = "sin garante"
	}
	if($('#csi').is(":checked")){
		var detContrato = "con contrato"
	}else if($('#cno').is(":checked")){
		var detContrato = "sin contrato"
	}
	if($('#dsi').is(":checked")){
		var detDeposito = "con deposito"
	}else if($('#dno').is(":checked")){
		var detDeposito = "sin deposito"
	}
	if($('#gcsi').is(":checked")){
		var detGasCont = "con gastos de contrato"
	}else if($('#gcno').is(":checked")){
		var detGasCont = "sin gastos de contrato"
	}
	if($('#esi').is(":checked")){
		var detEscribano = "con escribano"
	}else if($('#eno').is(":checked")){
		var detEscribano = "sin escribano"
	}
	$('#AuxDetLeg').val(detGarante + ", " + detContrato + ", "
			+ detDeposito + ", " + detGasCont + ", " + detEscribano + ", " + $("#DetLegOtros").val());
		
}


$("#btnExpensas").click(function(){
	$('#valorExpensas').show();
})

$("#btnSinExpensas").click(function(){
	$('#valorExpensas').hide();
})








