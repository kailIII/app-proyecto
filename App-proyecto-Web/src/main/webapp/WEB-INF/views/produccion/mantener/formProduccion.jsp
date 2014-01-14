<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.produccion" var="label_produccion" htmlEscape="false" />
<spring:message code="label.produccion.fechaE" var="label_produccion_fechaE" htmlEscape="false" />
<spring:message code="label.produccion.fechaP" var="label_produccion_fechaP" htmlEscape="false" />
<spring:message code="label.produccion.emitido" var="label_produccion_emitido" htmlEscape="false" />
<spring:message code="label.produccion.confirmado" var="label_produccion_confirmado" htmlEscape="false" />
<spring:message code="label.produccion.formula" var="label_produccion_formula" htmlEscape="false" />


<form:form action="" method="${param.method}" modelAttribute="produccion" class="form-horizontal" id="frmProduccion">
	<input type="hidden" name="codigo" value="${produccion.codigo}" />
	<fieldset>
   		<legend><h3>${label_produccion} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_produccion_fechaE}</label>
    		<div class="controls">
    			<form:input path="fechaEmision" class="input-large" id="fecha"/>
                <form:errors path="fechaEmision" cssClass="alert alert-error"/>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_produccion_formula}</label>
    		<div class="controls">
    			<form:input path="formula" class="input-large"/>
    			<form:errors path="formula" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/produccion/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmProduccion").validate({
 		 	rules: {
 	 		 	fecha: { required: true },
 	 		 	formula: { required: true}
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmProduccion").submit(); });

	$(function () {
	    $("#fecha").datepicker({ dateFormat: 'dd/mm/yy'});
	});
});
</script>