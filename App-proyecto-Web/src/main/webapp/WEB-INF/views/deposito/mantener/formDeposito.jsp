<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />
<spring:message code="label.deposito" var="label_deposito" htmlEscape="false" />
<spring:message code="label.deposito.nombre" var="label_deposito_nombre" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="deposito" class="form-horizontal" id="frmDeposito">
	<input type="hidden" name="codigo" value="${deposito.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_deposito} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_deposito_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   	</fieldset>
   	
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<spring:url value="/deposito" var="crear_url" htmlEscape="true">
			<spring:param name="list"></spring:param>
		</spring:url>
		<a href="${crear_url}"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmDeposito").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 }
 		 	},
 		 	messages: {
 		 		nombre: 'El campo Nombre es obligatorio'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmDeposito").submit(); });
});
</script>