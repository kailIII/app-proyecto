<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.empleado" var="label_empleado" htmlEscape="false" />
<spring:message code="label.empleado.ci" var="label_empleado_ci" htmlEscape="false" />
<spring:message code="label.empleado.nombre" var="label_empleado_nombre" htmlEscape="false" />
<spring:message code="label.empleado.apellido" var="label_empleado_apellido" htmlEscape="false" />
<spring:message code="label.empleado.direccion" var="label_empleado_direccion" htmlEscape="false" />
<spring:message code="label.empleado.barrio" var="label_empleado_barrio" htmlEscape="false" />
<spring:message code="label.empleado.celular" var="label_empleado_celular" htmlEscape="false" />
<spring:message code="label.empleado.telefono" var="label_empleado_telefono" htmlEscape="false" />
<spring:message code="label.empleado.fechaIngreso" var="label_empleado_fechaIngreso" htmlEscape="false" />
<spring:message code="label.empleado.fechaNacimiento" var="label_empleado_fechaNacimiento" htmlEscape="false" />
<spring:message code="label.empleado.email" var="label_empleado_email" htmlEscape="false" />
<spring:message code="label.empleado.obs" var="label_empleado_obs" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="empleado" class="form-horizontal" id="frmEmpleado">
	<input type="hidden" name="codigo" value="${empleado.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_empleado} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_ci}</label>
    		<div class="controls">
    			<form:input path="ci" class="input-large" />
    			<form:errors path="ci" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_apellido}</label>
    		<div class="controls">
    			<form:input path="apellido" class="input-large"/>
    			<form:errors path="apellido" cssClass="alert alert-error" />
    		</div>
   		</div>
		<div class="control-group">
    		<label class="control-label">${label_empleado_direccion}</label>
    		<div class="controls">
    			<form:input path="direccion" class="input-large" />
    			<form:errors path="direccion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_barrio}</label>
    		<div class="controls">
    			<form:input path="barrio" class="input-large" />
    			<form:errors path="barrio" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_celular}</label>
    		<div class="controls">
    			<form:input path="celular" class="input-large" />
    			<form:errors path="celular" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_telefono}</label>
    		<div class="controls">
    			<form:input path="telefono" class="input-large" />
    			<form:errors path="telefono" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_email}</label>
    		<div class="controls">
    			<form:input path="email" class="input-large" />
    			<form:errors path="email" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_fechaNacimiento}</label>
    		<div class="controls">
    			<form:input path="fechaNacimiento" class="input-large" />
    			<form:errors path="fechaNacimiento" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_empleado_fechaIngreso}</label>
    		<div class="controls">
    			<form:input path="fechaIngreso" class="input-large" />
    			<form:errors path="fechaIngreso" cssClass="alert alert-error" />
    		</div>
   		</div>
   	</fieldset>
   	
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/empleado/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmEmpleado").validate({
 		 	rules: {
 	 		 	nombre: { required: true},
 	 		 	apellido: { required: true}
 		 	},
 		 	messages: {
 		 		nombre:'El campo Nombre es obligatorio',
 		 		apellido:'El Campo Apellido es obligatorio'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmEmpleado").submit(); });
});
</script>