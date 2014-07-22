<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.impuesto" var="label_impuesto" htmlEscape="false" />
<spring:message code="label.impuesto.nombre" var="label_impuesto_nombre" htmlEscape="false" />
<spring:message code="label.impuesto.abreviatura" var="label_impuesto_abreviatura" htmlEscape="false" />
<spring:message code="label.impuesto.porcentaje" var="label_impuesto_porcentaje" htmlEscape="false" />
<spring:message code="label.impuesto.activo" var="label_impuesto_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="impuesto" class="form-horizontal" id="frmImpuesto">
	<input type="hidden" name="codigo" value="${impuesto.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_impuesto} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_impuesto_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_impuesto_abreviatura}</label>
    		<div class="controls">
    			<form:input path="abreviatura" class="input-large" maxlength="3"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_impuesto_porcentaje}</label>
    		<div class="controls">
    			<form:input path="porcentaje" class="input-large" id="porcentaje"/>
    			<form:errors path="porcentaje" cssClass="alert alert-error" />
    		</div>
   		</div>		
   	</fieldset>
   	
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/impuesto/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmImpuesto").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	porcentaje: {required: true, number: true}
 		 	}, 
 		 	messages:{
 		 		nombre:'El campo Nombre es obligatorio',
 		 		porcentaje:'Debes indicar el Porcentaje del Impuesto'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmImpuesto").submit(); });

});
</script>