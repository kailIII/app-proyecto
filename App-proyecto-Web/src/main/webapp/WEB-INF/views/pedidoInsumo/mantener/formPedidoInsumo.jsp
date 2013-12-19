<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    			<form:input path="fecha" class="input-large" id="fecha"/>
                <form:errors path="fecha" cssClass="alert alert-error"/>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_pedido_proveedor}</label>
    		<div class="controls">
    			<form:input path="proveedor.codigo" class="input-large"/>
    			<form:errors path="proveedor.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_pedido_estado}</label>
    		<div class="controls">
    			<form:input path="estado" class="input-large" id="fecha"/>
                <form:errors path="estado" cssClass="alert alert-error"/>
    		</div>
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
		<a href="./pedido/listado"><button class="btn">${button_cancelar}</button></a>
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
	
	 	$(function () {
		    $("#fecha").datepicker({ dateFormat: 'dd/mm/yyyy'});
		});
	    
	});
</script>