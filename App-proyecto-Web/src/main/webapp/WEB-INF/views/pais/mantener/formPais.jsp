<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.pais" var="label_pais" htmlEscape="false" />
<spring:message code="label.pais.nombre" var="label_pais_nombre" htmlEscape="false" />
<spring:message code="label.pais.abreviatura" var="label_pais_abreviatura" htmlEscape="false" />
<spring:message code="label.pais.activo" var="label_pais_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="pais" class="form-horizontal" id="frmPais">
	<input type="hidden" name="codigo" value="${pais.codigo}" />
	<fieldset>
   		
   		<legend><h3>${label_pais} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_pais_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_pais_abreviatura}</label>
    		<div class="controls">
    			<form:input path="abreviatura" class="input-large"/>
    			<form:errors path="abreviatura" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_pais_activo}</label>
    		<div class="controls">
    			<form:checkbox path="activo" value="1"/>
    		</div>
   		</div>
   		
   	</fieldset>
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/pais/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmPais").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 }
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmPais").submit(); });

});
</script>