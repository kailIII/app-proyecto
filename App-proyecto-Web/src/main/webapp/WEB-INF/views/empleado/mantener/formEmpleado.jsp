<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.insumo" var="label_insumo" htmlEscape="false" />
<spring:message code="label.insumo.nombre" var="label_insumo_nombre" htmlEscape="false" />
<spring:message code="label.insumo.descripcion" var="label_insumo_descripcion" htmlEscape="false" />
<spring:message code="label.insumo.cantidad" var="label_insumo_cantidad" htmlEscape="false" />
<spring:message code="label.insumo.umedida" var="label_insumo_umedida" htmlEscape="false" />
<spring:message code="label.insumo.activo" var="label_insumo_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="insumo" class="form-horizontal" id="frmInsumo">
	<input type="hidden" name="id" value="${insumo.codigo}" />
	<fieldset>
   		<legend><h3>${label_insumo} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_insumo_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_descripcion}</label>
    		<div class="controls">
    			<form:input path="descripcion" class="input-large"/>
    			<form:errors path="descripcion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_umedida}</label>
    		<div class="controls">
    			<form:input path="umedidas.nombre" class="input-small"/>
    			<form:errors path="umedidas.nombre" cssClass="alert alert-error" />
    			<button id="popupUnidadMedida" class="btn btn-success">${button.buscar}</button>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_activo}</label>
    		<div class="controls">
    			<form:checkbox path="activo" class="input-small"/>
    			<form:errors path="activo" cssClass="alert alert-error" />
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