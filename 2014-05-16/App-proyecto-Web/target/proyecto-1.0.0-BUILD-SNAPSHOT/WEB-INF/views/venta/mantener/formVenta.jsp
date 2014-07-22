<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.venta" var="label_venta" htmlEscape="false" />
<spring:message code="label.venta.fecha" var="label_venta_fecha" htmlEscape="false" />
<spring:message code="label.venta.activo" var="label_venta_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="venta" class="form-horizontal" id="frmVenta">
	<input type="hidden" name="codigo" value="${venta.codigo}" />
	<fieldset>
   		
   		<legend><h3>${label_venta} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_venta_fecha}</label>
    		<div class="controls">
    			<form:input path="fecha" class="input-large" />
    			<form:errors path="fecha" cssClass="alert alert-error" />
    		</div>
   		</div>

   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/venta/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmVenta").validate({
 		 	rules: {
 	 		 	fecha: { required: true }
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmVenta").submit(); });
});
</script>