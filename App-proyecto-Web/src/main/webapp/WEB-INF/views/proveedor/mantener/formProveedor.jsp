<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />
<spring:message code="label.proveedor" var="label_proveedor" htmlEscape="false" />
<spring:message code="label.proveedor.nombre" var="label_proveedor_nombre" htmlEscape="false" />
<spring:message code="label.proveedor.apellido" var="label_proveedor_apellido" htmlEscape="false" />
<spring:message code="label.proveedor.direccion" var="label_proveedor_direccion" htmlEscape="false" />
<spring:message code="label.proveedor.barrio" var="label_proveedor_barrio" htmlEscape="false" />
<spring:message code="label.proveedor.telefono" var="label_proveedor_telefono" htmlEscape="false" />
<spring:message code="label.proveedor.telefono2" var="label_proveedor_telefono2" htmlEscape="false" />
<spring:message code="label.proveedor.celular" var="label_proveedor_celular" htmlEscape="false" />
<spring:message code="label.proveedor.celular2" var="label_proveedor_celular2" htmlEscape="false" />
<spring:message code="label.proveedor.ci" var="label_proveedor_ci" htmlEscape="false" />
<spring:message code="label.proveedor.ruc" var="label_proveedor_ruc" htmlEscape="false" />
<spring:message code="label.proveedor.representante" var="label_proveedor_representante" htmlEscape="false" />
<spring:message code="label.proveedor.ciudad" var="label_proveedor_ciudad" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="proveedor" class="form-horizontal" id="frmProveedor">
	<input type="hidden" name="codigo" value="${proveedor.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_proveedor} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_ruc}</label>
    		<div class="controls">
    			<form:input path="ruc" class="input-large" />
    			<form:errors path="ruc" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_ci}</label>
    		<div class="controls">
    			<form:input path="ci" class="input-large" />
    			<form:errors path="ci" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" id="nombre"/>
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_apellido}</label>
    		<div class="controls">
    			<form:input path="apellido" class="input-large" id="apellido"/>
    			<form:errors path="apellido" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_representante}</label>
    		<div class="controls">
    			<form:input path="representante" class="input-large" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_celular} Nro. 2</label>
    		<div class="controls">
    			<form:input path="codigo" class="input-large"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_direccion}</label>
    		<div class="controls"> 
    			<form:input path="direccion" class="input-large" />
    			<form:errors path="direccion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_direccion} Nro. 2</label>
    		<div class="controls">
    			<form:input path="direccion2" class="input-large" />
    			<form:errors path="direccion2" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_barrio}</label>
    		<div class="controls">
    			<form:input path="barrio" class="input-large"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_ciudad}</label>
    		<div class="controls">
    			<form:select path="ciudad.codigo">
					<option value=""></option>
					<c:forEach items="${ciudades}" var="ciudad">
						<c:choose>
		                    <c:when test="${ciudad.codigo == proveedor.ciudad.codigo}">
		                        <option value="${ciudad.codigo}" selected="true">${ciudad.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${ciudad.codigo}">${ciudad.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="ciudad.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_telefono}</label>
    		<div class="controls">
    			<form:input path="telefono" class="input-large"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_telefono} Nro. 2</label>
    		<div class="controls">
    			<form:input path="telefono2" class="input-large"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_celular}</label>
    		<div class="controls">
    			<form:input path="celular" class="input-large"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_proveedor_celular} Nro. 2</label>
    		<div class="controls">
    			<form:input path="celular2" class="input-large"/>
    		</div>
   		</div>
   	</fieldset>
   	
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<spring:url value="/proveedor" var="crear_url" htmlEscape="true">
			<spring:param name="form"></spring:param>
		</spring:url>
		<a href="${crear_url}"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmProveedor").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	ciudad: {required: true }
 		 	},
 		 	messages: {
 		 		nombre:'El campo Nombre es obligatorio',
 		 		ciudad: 'El campo Ciudad es obligatorio'
 		 	}
 		
 	});
 	
  	$("#guardar").click(function () { $("#frmProveedor").submit(); });
});
</script>