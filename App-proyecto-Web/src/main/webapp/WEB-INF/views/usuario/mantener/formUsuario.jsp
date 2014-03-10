<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.usuario" var="label_usuario" htmlEscape="false" />
<spring:message code="label.usuario.nombre" var="label_usuario_nombre" htmlEscape="false" />
<spring:message code="label.usuario.login" var="label_usuario_login" htmlEscape="false" />
<spring:message code="label.usuario.clave" var="label_usuario_clave" htmlEscape="false" />
<spring:message code="label.usuario.repita" var="label_usuario_repita" htmlEscape="false" />
<spring:message code="label.usuario.activo" var="label_usuario_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="usuario" class="form-horizontal" id="frmUsuario">
	<input type="hidden" name="codigo" value="${usuario.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_usuario} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_usuario_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_usuario_login}</label>
    		<div class="controls">
    			<form:input path="login" class="input-large" placeholder="Introduce login"/>
    			<form:errors path="login" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_usuario_clave}</label>
    		<div class="controls">
    			<form:password path="clave" class="input-large" placeholder="Minimo 8 caracteres"/>
    			<form:errors path="clave" cssClass="alert alert-error" />
    		</div>
   		</div>
   	</fieldset>
   	
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/usuario/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmUsuario").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	login: { required: true },
				clave: { required: true, minlength: 5 }
 		 	}, 
 		 	messages: {
 		 		nombre: 'El campo Nombre es obligatorio',
 		 		login: 'El campo Login es obligatorio',
 		 		clave: 'El campo Clave es obligatorio'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmUsuario").submit(); });
});
</script>