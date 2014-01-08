<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.mycompany.proyecto.model.PedidoDetalle" %>
<%@ page import="java.util.ArrayList"%>


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
   		<div class="control-group">
    		<label class="control-label">${label_pedido_fecha}</label>
    		<div class="controls">
    			<form:input path="fecha" class="input-large" placeholder="Introduce la fecha"/>
                <form:errors path="fecha" cssClass="alert alert-error"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_pedido_proveedor}</label>
    		<div class="controls">
    			<form:input path="proveedor.codigo" class="input-large" placeholder="Introduce el Proveedor"/>
    			<form:errors path="proveedor.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_pedido_estado}</label>
    		<div class="controls">
    			<form:input path="estado" class="input-large" placeholder="Introduce el Estado"/>
                <form:errors path="estado" cssClass="alert alert-error"/>
    		</div>
   		</div>
   	</fieldset>
<!-- 		<table id="table_pedido" class="table table-hover"> -->
<!-- 			<thead> -->
<!-- 				<th>Codigo</th> -->
<!-- 				<th>Descripcion</th> -->
<!-- 				<th>Cantidad</th> -->
<!-- 			</thead> -->
<!-- 			<tbody> -->
			
<!-- 			</tbody> -->
<!-- 		</table> -->
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

<c:import 
	url="/WEB-INF/views/insumo/listaDetalleInsumos.jsp">
</c:import>


<script>	
	$(document).ready(function () {
	 	$("#frmPedidoInsumo").validate({
	 		 	rules: {
	 	 		 	fecha: { required: true},
	 	 		 	proveedor: { required: true }
	 		 	},
	 		 	messages: {
	 		 		fecha:'El campo Fecha es obligatorio',
	 		 		proveedor:'El campo Proveedor es obligatorio'
	 		 	}
	 	});
	 	
	 	$("#guardar").click(function () { $("#frmPedidoInsumo").submit(); });
	 	
	 	$("#fecha").datepicker({ dateFormat: 'dd/mm/yy'});
	});
	
	$(function () {
	    $("#fecha").datepicker({ dateFormat: 'dd/mm/yy'});
	});
	
// 	var lista = []; //vector
	
// 	function addProducto(idP, nombre, cantidadP){
// 		var tr = '<tr>';
// 		tr+='<td>'+idP+'</td>';
// 		tr+='<td>'+nombre+'</td>';
// 		tr+='<td>'+cantidadP+'</td>';
		
// 		lista.push({id:idP, nombre:nombre, cantidad:cantidadP});
// 		$('#table_pedido').append(tr);	
// 	}
	
	function addItemAjaxPost() {
   		// get the form values
		var id = $('#id').val(); //_${m.codigo}
   		var nombre = $('#nombre').val();
		var cantidad = $('#cantidad').val();
		//var boton = '<button id="btnEliminar" title="Quitar Item del Pedido" class="btn btn-danger"onclick="quitarItemAjaxPost()">Quitar</button>';
		
		alert('Valor: ' + id);
		alert('Valor: ' + nombre);
		alert('Valor: ' + cantidad);
		
		//carga la tabla
		//addProducto(id, nombre, cantidad);
		
		$.ajax({
			type: "POST",
			url: "/pedido/addItem",
			data: "id=" + id + "&cantidad=" + cantidad,
			success: function(response){
			// we have the response
			//$('#info').html(response);
			//$('#id').val('');
		    $('#cantidad').val('');
		 },
	     error: function(e){
		 	alert('Error: ' + e);
	     }
		 });
	}
	
	function quitarItemAjaxPost() {
   		// get the form values
		var id = $('#id').val(); //_${m.codigo}
   		//var nombre = $('#nombre').val();
		var cantidad = $('#cantidad').val();
		//var boton = '<button id="btnEliminar" title="Quitar Item del Pedido" class="btn btn-danger"onclick="quitarItemAjaxPost()">Quitar</button>';
		
		alert('Valor: ' + id);
// 		alert('Valor: ' + nombre);
 		alert('Valor: ' + cantidad);
		
		//eliminar de la tabla, PENDIENTE
		//eliminarProducto(id, nombre, cantidad, boton);
		
		$.ajax({
			type: "POST",
			url: "/pedido/quitarItem",
			data: "id=" + id + "&cantidad=" + cantidad,
			success: function(response){
			// we have the response
			//$('#info').html(response);
			//$('#id').val('');
		    $('#cantidad').val('');
		 },
	     error: function(e){
		 	alert('Error: ' + e);
	     }
		 });
	}
	
	function eliminarProducto(idP, nombre, cantidadP, boton){
		var tr = '<tr>';
		tr+='<td>'+idP+'</td>';
		tr+='<td>'+nombre+'</td>';
		tr+='<td>'+cantidadP+'</td>';
		tr+='<td>'+boton+'</td>';
		
		lista.push({id:idP, nombre:nombre, cantidad:cantidadP, boton:boton});
		
		$('#table_pedido').append(tr);	
	}
</script>