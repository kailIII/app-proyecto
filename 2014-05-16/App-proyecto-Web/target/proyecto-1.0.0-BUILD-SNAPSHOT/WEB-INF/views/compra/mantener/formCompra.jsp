<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />
<spring:message code="label.compra" var="label_compra" htmlEscape="false" />
<spring:message code="label.compra.fecha" var="label_compra_fecha" htmlEscape="false" />
<spring:message code="label.compra.fechaDocumento" var="label_compra_fechaDocumento" htmlEscape="false" />
<spring:message code="label.compra.comprobante" var="label_compra_comprobante" htmlEscape="false" />
<spring:message code="label.compra.condicion" var="label_compra_condicion" htmlEscape="false" />
<spring:message code="label.compra.estado" var="label_compra_estado" htmlEscape="false" />
<spring:message code="label.compra.totalExentas" var="label_compra_totalExentas" htmlEscape="false" />
<spring:message code="label.compra.totalGravada05" var="label_compra_totalGravada05" htmlEscape="false" />
<spring:message code="label.compra.totalGravada10" var="label_compra_totalGravada10" htmlEscape="false" />
<spring:message code="label.compra.totalIVA05" var="label_compra_totalIVA05" htmlEscape="false" />
<spring:message code="label.compra.totalIVA10" var="label_compra_totalIVA10" htmlEscape="false" />
<spring:message code="label.compra.totalMonto" var="label_compra_totalMonto" htmlEscape="false" />
<spring:message code="label.compra.obs" var="label_compra_obs" htmlEscape="false" />
<spring:message code="label.proveedor" var="label_proveedor" htmlEscape="false" />
<spring:message code="label.deposito" var="label_deposito" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="compra" class="form-horizontal" id="frmCompra">
	<input type="hidden" name="codigo" value="${compra.codigo}" />
	
	<fieldset>	
   		<legend><h3>${label_compra} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_compra_fecha}</label>
    		<div class="controls">	
    			<form:input path="fechaRegistro" class="input-large"/>
                <form:errors path="fechaRegistro" cssClass="alert alert-error"/>
    		</div>
   		</div>   		
   		<div class="control-group">
    		<label class="control-label">${label_compra_fechaDocumento}</label>
    		<div class="controls">	
    			<form:input path="fechaDocumento" class="input-large"/> 
                <form:errors path="fechaDocumento" cssClass="alert alert-error"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_compra_comprobante}</label>
    		<div class="controls">	
    			<form:input path="comprobanteNumero" class="input-large"/>
                <form:errors path="comprobanteNumero" cssClass="alert alert-error"/>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_compra_condicion}</label>
    		<div class="controls">	
    			<form:input path="condicion" class="input-large"/>
                <form:errors path="condicion" cssClass="alert alert-error"/>
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_proveedor}</label>
    		<div class="controls">
    			<form:select path="proveedor.codigo">
					<option value=""></option>
					<c:forEach items="${proveedores}" var="proveedor">
						<c:choose>
		                    <c:when test="${proveedor.codigo == producto.proveedor.codigo}">
		                        <option value="${proveedor.codigo}" selected="true">${proveedor.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${proveedor.codigo}">${proveedor.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="proveedor.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_compra_estado}</label>
    		<div class="controls">	
    			<form:input path="estado" class="input-large"/>
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_compra_obs}</label>
    		<div class="controls">	
    			<form:input path="obs" class="input-large"/>
    		</div>
   		</div>
   	
	   	<c:import 
	   		url="/WEB-INF/views/insumo/listaDetalleInsumos.jsp">
	   	</c:import>
   		
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="./compra/listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
	$(document).ready(function () {
	 	$("#frmCompra").validate({
	 		 	rules: {
	 	 		 	proveedor: { required: true },
	 	 		 	deposito: { required: true }
	 		 	}
	 	});
	 	
	 	$("#guardar").click(function () { $("#frmCompra").submit(); });
	
	});
	
	$(function () {
	    $("#fechaRegistro").datepicker({ dateFormat: 'yy/mm/dd'});
	});
</script>