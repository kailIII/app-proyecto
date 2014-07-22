<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />
<spring:message code="label.cargo" var="label_cargo" htmlEscape="false" />
<spring:message code="label.cargo.nombre" var="label_cargo_nombre" htmlEscape="false" />
<spring:message code="label.cargo.descripcion" var="label_cargo_descripcion" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="cargo" class="form-horizontal" id="frmCargo">
	<input type="hidden" name="codigo" value="${cargo.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_cargo} <small> ${param.sublabel}</small> </h3> </legend>
   		<div class="control-group">
    		<label class="control-label">${label_cargo_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cargo_descripcion}</label>
    		<div class="controls">
    			<form:input path="descripcion" class="input-large"/>
    		</div>
   		</div>   		
   	</fieldset>
   	
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/cargo/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmCargo").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 }
 		 	}, 
 		 	messages :{
 		 		nombre: 'El campo Nombre es obligatorio'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmCargo").submit(); });
});
</script>