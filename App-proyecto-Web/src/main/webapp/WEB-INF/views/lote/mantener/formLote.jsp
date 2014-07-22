<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />
<spring:message code="label.lote" var="label_lote" htmlEscape="false" />
<spring:message code="label.lote.nombre" var="label_lote_nombre" htmlEscape="false" />
<spring:message code="label.lote.vencimiento" var="label_lote_vencimiento" htmlEscape="false" />
<spring:message code="label.lote.insumo" var="label_lote_insumo" htmlEscape="false" />
<spring:message code="label.lote.activo" var="label_lote_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="lote" class="form-horizontal" id="frmLote">
	<input type="hidden" name="codigo" value="${lote.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_lote} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_lote_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_lote_vencimiento}</label>
    		<div class="controls">
    			<form:input path="vencimiento" class="input-large" />
    			<form:errors path="vencimiento" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_lote_insumo}</label>
    		<div class="controls">
    			<form:select path="producto.codigo" id="producto">
					<option value=""></option>
					<c:forEach items="${productos}" var="producto">
						<c:choose>
		                    <c:when test="${producto.codigo == lote.producto.codigo}">
		                        <option value="${producto.codigo}" selected="true">${producto.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${producto.codigo}">${producto.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="producto.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   	</fieldset>
   	
</form:form>

<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<spring:url value="/lote" var="crear_url" htmlEscape="true">
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
 	$("#frmLote").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	vencimiento: {required: true}
 		 	},
 		 	messages:{
 		 		nombre:'El campo Nombre es obligatorio',
 		 		vencimiento:'El campo Vencimiento es obligatorio'
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmLote").submit(); });
});
</script>