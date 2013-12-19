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

<spring:message code="label.departamento" var="label_departamento" htmlEscape="false" />
<spring:message code="label.departamento.nombre" var="label_departamento_nombre" htmlEscape="false" />
<spring:message code="label.departamento.abreviatura" var="label_departamento_abreviatura" htmlEscape="false" />
<spring:message code="label.departamento.pais" var="label_departamento_pais" htmlEscape="false" />
<spring:message code="label.departamento.activo" var="label_departamento_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="departamento" class="form-horizontal" id="frmDepartamento">
	<input type="hidden" name="codigo" value="${departamento.codigo}" />
	
	<fieldset>
   		
   		<legend><h3>${label_departamento} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_departamento_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" id="nombre"/>
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_departamento_abreviatura}</label>
    		<div class="controls">
    			<form:input path="abreviatura" class="input-large"/>
    			<form:errors path="abreviatura" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_departamento_pais}</label>
    		<div class="controls">
    			<form:input path="pais.codigo" class="input-large" id="pais"/>
    			<form:errors path="pais.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_departamento_activo}</label>
    		<div class="controls">
    			<form:checkbox path="activo" value="1"/>
    		</div>
   		</div>
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/departamento/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmDepartamento").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	pais: { required: true}
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmDepartamento").submit(); });

});
</script>