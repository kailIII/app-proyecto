<%-- 
     Fragmento com o formulario de preenchimento com os dados da mercadoria.
     Utilizado pela pagina de inclusao e edicao de mercadoria.
     O formulario de mercadorias utiliza o plugin Validation do JQuery, para validar os inputs.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.umedida" var="label_umedida" htmlEscape="false" />
<spring:message code="label.umedida.nombre" var="label_umedida_nombre" htmlEscape="false" />
<spring:message code="label.umedida.abreviatura" var="label_umedida_abreviatura" htmlEscape="false" />
<spring:message code="label.umedida.activo" var="label_insumo_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="umedida" class="form-horizontal" id="frmUmedida">
	<input type="hidden" name="codigo" value="${umedida.codigo}" />
	
	<fieldset>
   		
   		<legend><h3>${label_umedida} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_umedida_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" maxlength="60"/>
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_umedida_abreviatura}</label>
    		<div class="controls">
    			<form:input path="abreviatura" class="input-large" maxlength="3"/>
    			<form:errors path="abreviatura" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_umedida_activo}</label>
    		<div class="controls">
    			<form:checkbox path="activo" class="input-small" id="activo" value="0"/>
<%--     			<form:errors path="activo" cssClass="alert alert-error" /> --%>
    		</div>
   		</div>
   		
   	</fieldset>
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/umedida/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmUmedida").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	abreviatura: { required: true, minlength: 1}
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmUmedida").submit(); });
 	
});
</script>