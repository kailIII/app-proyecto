<%-- 
     Fragmento com o formulario de preenchimento com os dados da mercadoria.
     Utilizado pela pagina de inclusao e edicao de mercadoria.
     O formulario de mercadorias utiliza o plugin Validation do JQuery, para validar os inputs.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
	<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
	<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

	<spring:message code="label.clientes" var="label_clientes" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.cliente.nombre" var="label_cliente_nombre" htmlEscape="false" />
	<spring:message code="label.cliente.apellido" var="label_cliente_apellido" htmlEscape="false" />
	<spring:message code="label.cliente.ci" var="label_cliente_ci" htmlEscape="false" />
	<spring:message code="label.cliente.ruc" var="label_cliente_ruc" htmlEscape="false" />
	<spring:message code="label.cliente.rucdv" var="label_cliente_rucdv" htmlEscape="false" />
	<spring:message code="label.cliente.direccion" var="label_cliente_direccion" htmlEscape="false" />
	<spring:message code="label.cliente.barrio" var="label_cliente_barrio" htmlEscape="false" />
	<spring:message code="label.cliente.telefono" var="label_cliente_telefono" htmlEscape="false" />
	<spring:message code="label.cliente.celular" var="label_cliente_celular" htmlEscape="false" />
	<spring:message code="label.cliente.email" var="label_cliente_email" htmlEscape="false" />
	<spring:message code="label.cliente.fax" var="label_cliente_fax" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="cliente" class="form-horizontal" id="frmCliente">
	<input type="hidden" name="codigo" value="${cliente.codigo}" />
	<fieldset>
   		
   		<legend><h3>${label_cliente} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_cliente_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_cliente_apellido}</label>
    		<div class="controls">
    			<form:input path="apellido" class="input-large"/>
    			<form:errors path="apellido" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_cliente_ruc}</label>
    		<div class="controls">
    			<form:input path="ci" class="input-small" id="cantidad" />
    			<form:errors path="ci" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_cliente_ruc}</label>
    		<div class="controls">
    			<form:input path="ruc" class="input-small" id="cantidad" />
    			<form:errors path="ruc" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_cliente_direccion}</label>
    		<div class="controls">
    			<form:input path="direccion" class="input-small"/>
    			<form:errors path="direccion" cssClass="alert alert-error" />
    		</div>
   		</div>
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/inputs/list"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmCliente").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	ruc: { required: true, number: true },
				direccion: { required: true, minlength: 5 }
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmCliente").submit(); });
});
</script>