<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.formula" var="label_formula" htmlEscape="false" />
<spring:message code="label.formula.nombre" var="label_formula_nombre" htmlEscape="false" />
<spring:message code="label.formula.descripcion" var="label_formula_descripcion" htmlEscape="false" />
<spring:message code="label.formula.activo" var="label_formula_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="formula" class="form-horizontal" id="frmFormula">
	<input type="hidden" name="codigo" value="${formula.codigo}" />
	
	<fieldset>
   		
   		<legend><h3>${label_formula} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_formula_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" id="nombre"/>
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_formula_descripcion}</label>
    		<div class="controls">
    			<form:textarea path="descripcion" class="input-large"/>
    			<form:errors path="descripcion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_formula_activo}</label>
    		<div class="controls">
    			<form:checkbox path="activo" value="1"/>
    		</div>
   		</div>
   		
   		<br/>
   		
   		<c:import 
	   		url="/WEB-INF/views/insumo/listaDetalleInsumos.jsp">
	   	</c:import>
   		
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/formula/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmFormula").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 }
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmFormula").submit(); });

});
</script>