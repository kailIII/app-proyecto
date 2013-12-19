<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.recepcion.fecha" var="label_recepcion_fecha" htmlEscape="false" />
<spring:message code="label.recepcion.proveedor" var="label_recepcion_proveedor" htmlEscape="false" />
<spring:message code="label.recepcion.empleado" var="label_recepcion_empleado" htmlEscape="false" />

<spring:message code="label.insumo.codigo" var="label_insumo_codigo" htmlEscape="false" />
<spring:message code="label.insumo.nombre" var="label_insumo_nombre" htmlEscape="false" />
<spring:message code="label.insumo.umedida" var="label_insumo_umedida" htmlEscape="false" />
<spring:message code="label.insumo.cantidad" var="label_insumo_cantidad" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="recepcion" class="form-horizontal" id="frmRecepcion">
	<input type="hidden" name="id" value="${recepcion.codigo}" /> 
	<fieldset>
   		
   		<legend><h3>${label_recepcion} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_recepcion_fecha}</label>
    		<div class="controls">	
    			<form:input path="fecha" class="input-large" id="fecha"/>
                <span class="help-inline">
                	<form:errors path="fecha" cssClass="alert alert-error"/>
                </span>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_recepcion_proveedor}</label>
    		<div class="controls">
    			<form:input path="proveedor" class="input-large"/>
    			<form:errors path="proveedor" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_recepcion_empleado}</label>
    		<div class="controls">
    			<form:input path="empleado" class="input-small" id="cantidad" />
    			<form:errors path="empleado" cssClass="alert alert-error" />
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
	 	$("#frmRecepcionInsumo").validate({
	 		 	rules: {
	 	 		 	proveedor: { required: true },
	 	 		 	empleado: { required: true }
	 		 	}
	 	});
	 	
	 	$("#guardar").click(function () { $("#frmRecepcionInsumo").submit(); });
	
	});
	
	$(function () {
	    $("#fecha").datepicker({dateFormat: 'dd/mm/yyyy'});
	});
</script>