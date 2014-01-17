<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
	<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
	<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />
	<spring:message code="label.listado" var="label_listado" htmlEscape="false" />
	<spring:message code="label.clientes" var="label_clientes" htmlEscape="false" />
	<spring:message code="label.cliente.tpersona" var="label_cliente_tpersona" htmlEscape="false" />
	<spring:message code="label.cliente.nombre" var="label_cliente_nombre" htmlEscape="false" />
	<spring:message code="label.cliente.apellido" var="label_cliente_apellido" htmlEscape="false" />
	<spring:message code="label.cliente.ci" var="label_cliente_ci" htmlEscape="false" />
	<spring:message code="label.cliente.dv" var="label_cliente_dv" htmlEscape="false" />
	<spring:message code="label.cliente.ruc" var="label_cliente_ruc" htmlEscape="false" />
	<spring:message code="label.cliente.rucdv" var="label_cliente_rucdv" htmlEscape="false" />
	<spring:message code="label.cliente.direccion" var="label_cliente_direccion" htmlEscape="false" />
	<spring:message code="label.cliente.barrio" var="label_cliente_barrio" htmlEscape="false" />
	<spring:message code="label.cliente.ciudad" var="label_cliente_ciudad" htmlEscape="false" />
	<spring:message code="label.cliente.telefono" var="label_cliente_telefono" htmlEscape="false" />
	<spring:message code="label.cliente.celular" var="label_cliente_celular" htmlEscape="false" />
	<spring:message code="label.cliente.email" var="label_cliente_email" htmlEscape="false" />
	<spring:message code="label.cliente.skype" var="label_cliente_skype" htmlEscape="false" />
	<spring:message code="label.cliente.web" var="label_cliente_web" htmlEscape="false" />
	<spring:message code="label.cliente.fax" var="label_cliente_fax" htmlEscape="false" />
	<spring:message code="label.cliente.obs" var="label_cliente_obs" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="cliente" class="form-horizontal" id="frmCliente">
	<input type="hidden" name="codigo" value="${cliente.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_cliente} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_tpersona}</label>
    		<div class="controls">
    			<form:select path="tipoPersona.codigo">
					<option value=""></option>
					<c:forEach items="${tpersonas}" var="tpersona">
						<c:choose>
		                    <c:when test="${tpersona.codigo == cliente.tipoPersona.codigo}">
		                        <option value="${tpersona.codigo}" selected="true">${tpersona.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${tpersona.codigo}">${tpersona.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="tipoPersona.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_ci}</label>
    		<div class="controls">
    			<form:input path="ci" class="input-large"/>
    			<form:errors path="ci" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_dv}</label>
    		<div class="controls">
    			<form:input path="dv" class="input-large"/>
    			<form:errors path="dv" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_ruc}</label>
    		<div class="controls">
    			<form:input path="ruc" class="input-large" />
    			<form:errors path="ruc" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_rucdv}</label>
    		<div class="controls">
    			<form:input path="rucdv" class="input-large"/>
    			<form:errors path="rucdv" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_apellido}</label>
    		<div class="controls">
    			<form:input path="apellido" class="input-large"/>
    			<form:errors path="apellido" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_direccion}</label>
    		<div class="controls">
    			<form:input path="direccion" class="input-large"/>
    			<form:errors path="direccion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_barrio}</label>
    		<div class="controls">
    			<form:input path="barrio" class="input-large"/>
    			<form:errors path="barrio" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_ciudad}</label>
    		<div class="controls">
    			<form:select path="ciudad.codigo">
					<option value=""></option>
					<c:forEach items="${ciudades}" var="ciudad">
						<c:choose>
		                    <c:when test="${ciudad.codigo == cliente.ciudad.codigo}">
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
    		<label class="control-label">${label_cliente_telefono}</label>
    		<div class="controls">
    			<form:input path="telefono" class="input-large"/>
    			<form:errors path="telefono" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_telefono} Nro. 2</label>
    		<div class="controls">
    			<form:input path="telefono2" class="input-large"/>
    			<form:errors path="telefono2" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_fax}</label>
    		<div class="controls">
    			<form:input path="fax" class="input-large"/>
    			<form:errors path="fax" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_celular}</label>
    		<div class="controls">
    			<form:input path="celular" class="input-large"/>
    			<form:errors path="celular" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_celular} Nro. 2</label>
    		<div class="controls">
    			<form:input path="celular2" class="input-large"/>
    			<form:errors path="celular2" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_email}</label>
    		<div class="controls">
    			<form:input path="email" class="input-large"/>
    			<form:errors path="email" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_email} Nro. 2</label>
    		<div class="controls">
    			<form:input path="email2" class="input-large"/>
    			<form:errors path="email2" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_skype}</label>
    		<div class="controls">
    			<form:input path="skype" class="input-large"/>
    			<form:errors path="skype" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_web}</label>
    		<div class="controls">
    			<form:input path="web" class="input-large"/>
    			<form:errors path="web" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_cliente_obs}</label>
    		<div class="controls">
    			<form:textarea path="obs" class="input-large"/>
    			<form:errors path="obs" cssClass="alert alert-error" />
    		</div>
   		</div>
   	</fieldset>
   	
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="/proyecto/cliente/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmCliente").validate({
 		 	rules: {
 	 		 	nombre: { required: true}
 		 	},
 		 	messages: {
 		 		nombre:'El campo Nombre es obligatorio'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmCliente").submit(); });
});
</script>