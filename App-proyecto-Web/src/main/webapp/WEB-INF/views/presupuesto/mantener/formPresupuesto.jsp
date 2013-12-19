<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.presupuesto" var="label_presupuesto" htmlEscape="false" />
<spring:message code="label.presupuesto.fecha" var="label_presupuesto_fecha" htmlEscape="false" />
<spring:message code="label.presupuesto.activo" var="label_presupuesto_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="presupuesto" class="form-horizontal" id="frmPresupuesto">
	<input type="hidden" name="codigo" value="${presupuesto.codigo}" />
	<fieldset>
   		
   		<legend><h3>${label_presupuesto} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_presupuesto_fecha}</label>
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
		<a href="/inputs/list"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmInsumo").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	cantidad: { required: true, number: true },
				precio: { required: true, moneda: true }
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmInsumo").submit(); });

    $.validator.addMethod("moneda",
    	function(value, element) {
    		return this.optional(element) || /^-?(?:\d+|\d{1,3}(?:.\d{3})+)?(?:\,\d+)?$/.test(value);
    	}, 'Valor invalido para moneda');
});
</script>