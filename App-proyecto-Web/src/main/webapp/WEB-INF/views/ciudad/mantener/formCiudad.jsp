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

<form:form action="" method="${param.method}" modelAttribute="ciudad" class="form-horizontal" id="frmCiudad">
	<input type="hidden" name="codigo" value="${ciudad.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
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
    			<form:input path="abreviatura" class="input-large" maxlength="3"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_ciudad_departamento}</label>
    		<div class="controls">
    			<form:select path="departamento.codigo" id="dep">
					<option value=""></option>
					<c:forEach items="${departamentos}" var="dep">
						<c:choose>
		                    <c:when test="${dep.codigo == ciudad.departamento.codigo}">
		                        <option value="${dep.codigo}" selected="true">${dep.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${dep.codigo}">${dep.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="departamento.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_ciudad_pais}</label>
    		<div class="controls">
    			<form:select path="pais.codigo" id="pais">
					<option value=""></option>
					<c:forEach items="${paises}" var="pais">
						<c:choose>
		                    <c:when test="${pais.codigo == ciudad.pais.codigo}">
		                        <option value="${pais.codigo}" selected="true">${pais.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${pais.codigo}">${pais.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="pais.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>   		
   	</fieldset>
   	
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<spring:url value="/ciudad" var="crear_url" htmlEscape="true">
			<spring:param name="list"></spring:param>
		</spring:url>
		<a href="${crear_url}"><button class="btn">${button_cancelar}</button></a>
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