<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.mycompany.proyecto.model.PedidoDetalle" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.pedido" var="label_pedido" htmlEscape="false" />
<spring:message code="label.pedido.fecha" var="label_pedido_fecha" htmlEscape="false" />
<spring:message code="label.pedido.proveedor" var="label_pedido_proveedor" htmlEscape="false" />
<spring:message code="label.pedido.estado" var="label_pedido_estado" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="pedido" class="form-horizontal" id="frmPedidoInsumo">
	<input type="hidden" name="codigo" value="${pedido.codigo}" />
	
	<fieldset>
   		
   		<legend><h3>${label_pedido} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="form-group">
    		<label class="control-label">${label_pedido_fecha}</label>
<!--     		<div class="controls"> -->
    			<form:input path="fecha" class="form-control" placeholder="Introduce la fecha"/>
                <form:errors path="fecha" cssClass="alert alert-error"/>
<!--     		</div> -->
   		</div>
   		
   		<div class="form-group">
    		<label class="control-label">${label_pedido_proveedor}</label>
<!--     		<div class="controls"> -->
    			<form:input path="proveedor.codigo" class="form-control" placeholder="Introduce el Proveedor"/>
    			<form:errors path="proveedor.codigo" cssClass="alert alert-error" />
<!--     		</div> -->
   		</div>
   		
   		<div class="form-group">
    		<label class="control-label">${label_pedido_estado}</label>
<!--     		<div class="controls"> -->
    			<form:input path="estado" class="form-control" placeholder="Introduce el Estado"/>
                <form:errors path="estado" cssClass="alert alert-error"/>
<!--     		</div> -->
   		</div>
   		
   		<div class="control-group form-horizontal">
			<button id="proveedor" class="btn btn-info">Por Proveedor</button>
			<a href="./pedido/listado"><button class="btn">Por Grupo</button></a>
			<a href="./pedido/listado"><button class="btn btn-info">Por Clasificacion</button></a>
			<a href="./pedido/listado"><button class="btn">Por Marca</button></a>
		</div>
 
	   	<c:import 
	   		url="/WEB-INF/views/insumo/listaDetalleInsumos.jsp">
	   	</c:import>
   	
   	</fieldset>
   	
   	
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/pedido/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
	$(document).ready(function () {
	 	$("#frmPedidoInsumo").validate({
	 		 	rules: {
	 	 		 	fecha: { required: true},
	 	 		 	proveedor: { required: true }
	 		 	}
	 	});
	 	
	 	$("#guardar").click(function () { $("#frmPedidoInsumo").submit(); });
	 	
	 	$("#fecha").datepicker({ dateFormat: 'dd/mm/yy'});

	});
	
	$(function () {
	    $("#fecha").datepicker({ dateFormat: 'dd/mm/yy'});
	});
	
	// Traducción al español
	$(function($){
	    $.datepicker.regional['es'] = {
	        closeText: 'Cerrar',
	        prevText: '<Ant',
	        nextText: 'Sig>',
	        currentText: 'Hoy',
	        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio',
	                     'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
	        monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun',
	                          'Jul','Ago','Sep', 'Oct','Nov','Dic'],
	        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles',
	                   'Jueves', 'Viernes', 'Sábado'],
	        dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
	        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
	        weekHeader: 'Sm',
	        dateFormat: 'dd/mm/yy',
	        firstDay: 1,
	        isRTL: false,
	        showMonthAfterYear: false,
	        yearSuffix: ''
	    };
	    $.datepicker.setDefaults($.datepicker.regional['es']);
	});
	
// 	$(function(){Ejemplos del plugins del JQuery Validator
// 	       $('#formInscripcion').validate({
// 	           rules: {
// 	           'nombre': 'required',
// 	           'apellido': 'required',
// 	           'numero_identidad': { required: true, number: true },
// 	           'email': { required: true, email: true },
// 	           'tipo_identidad': 'required',
// 	           'deportes[]': { required: true, minlength: 1 }
// 	           },
// 	       messages: {
// 	           'nombre': 'Debe ingresar el nombre',
// 	           'apellido': 'Debe ingresar el apellido',
// 	           'numero_identidad': { required: 'Debe ingresar el número de documento de identidad', number: 'Debe ingresar un número' },
// 	           'email': { required: 'Debe ingresar un correo electrónico', email: 'Debe ingresar el correo electrónico con el formato correcto. Por ejemplo: u@localhost.com' },
// 	           'tipo_identidad': 'Debe ingresar el número de documento',
// 	           'deportes[]': 'Debe seleccionar mínimo un deporte'
// 	       },
// 	       debug: true,
// 	       /*errorElement: 'div',*/
// 	       //errorContainer: $('#errores'),
// 	       submitHandler: function(form){
// 	           alert('El formulario ha sido validado correctamente!');
// 	       }
// 	    });
// 	});

	function ver() {
		Alert(children);
	}

	var children = $("tr td")[0].innerHTML;
	
</script>