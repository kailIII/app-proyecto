<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.ciudad" var="label_ciudad" htmlEscape="false" />
<spring:message code="label.ciudad.nombre" var="label_ciudad_nombre" htmlEscape="false" />
<spring:message code="label.ciudad.abreviatura" var="label_ciudad_abreviatura" htmlEscape="false" />
<spring:message code="label.ciudad.departamento" var="label_ciudad_departamento" htmlEscape="false" />
<spring:message code="label.ciudad.pais" var="label_ciudad_pais" htmlEscape="false" />
<spring:message code="label.ciudad.activo" var="label_ciudad_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="ciudad" class="form-horizontal" id="frmCiudad">
	<input type="hidden" name="codigo" value="${ciudad.codigo}" />
	<fieldset>
   		
   		<legend><h3>${label_ciudad} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_ciudad_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" id="nombre" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_ciudad_abreviatura}</label>
    		<div class="controls">
    			<form:input path="abreviatura" class="input-large"/>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_ciudad_departamento}</label>
    		<div class="controls">
    			<form:input path="departamento.codigo" class="input-large" id="dep"/>
    			<form:errors path="departamento.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_ciudad_pais}</label>
    		<div class="controls">
    			<form:input path="pais.codigo" class="input-large" id="pais"/>
    			<form:errors path="pais.codigo" cssClass="alert alert-error" />
    			
<%--     			<form:select path="pais"> pendiente --%>
<%--     				<form:option value="-">Seleccione Pais</form:option> --%>
<%--     				<form:options items="${}" itemValue="pais.codigo" itemLabel="pais.nombre"/> --%>
<%--     			</form:select> --%>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_ciudad_activo}</label>
    		<div class="controls">
    			<form:checkbox path="activo" value="1"/>
    		</div>
   		</div>
   		
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/ciudad/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmCiudad").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	dep	  : { required: true },
 	 		 	pais  : { required: true}
 		 	},
 		 	messages: {
 		 		nombre: 'El campo Nombre es obligatorio',
 		 		dep: 'El campo Departamento es obligatorio',
 		 		pais: 'El campo Pais es obligatorio'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmCiudad").submit(); });

});
</script>