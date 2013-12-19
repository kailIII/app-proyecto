<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.insumo" var="label_insumo" htmlEscape="false" />
<spring:message code="label.insumo.nombre" var="label_insumo_nombre" htmlEscape="false" />
<spring:message code="label.insumo.descripcion" var="label_insumo_descripcion" htmlEscape="false" />
<spring:message code="label.insumo.cantidad" var="label_insumo_cantidad" htmlEscape="false" />
<spring:message code="label.insumo.umedida" var="label_insumo_umedida" htmlEscape="false" />
<spring:message code="label.insumo.grupo" var="label_insumo_grupo" htmlEscape="false" />
<spring:message code="label.insumo.clasificacion" var="label_insumo_clasificacion" htmlEscape="false" />
<spring:message code="label.insumo.marca" var="label_insumo_marca" htmlEscape="false" />
<spring:message code="label.insumo.proveedor" var="label_insumo_proveedor" htmlEscape="false" />
<spring:message code="label.insumo.impuesto" var="label_insumo_impuesto" htmlEscape="false" />
<%-- <spring:message code="label.insumo.deposito" var="label_insumo_deposito" htmlEscape="false" /> --%>
<%-- <spring:message code="label.insumo.stockMinimo" var="label_insumo_stockMinimo" htmlEscape="false" /> --%>
<%-- <spring:message code="label.insumo.stock" var="label_insumo_stock" htmlEscape="false" /> --%>
<%-- <spring:message code="label.insumo.precioCosto" var="label_insumo_precioCosto" htmlEscape="false" /> --%>
<spring:message code="label.insumo.activo" var="label_insumo_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="insumo" class="form-horizontal" id="frmInsumo">
	<input type="hidden" name="id" value="${insumo.codigo}" />
	
	<fieldset>
   		
   		<legend><h3>${label_insumo} <small> ${param.sublabel}</small></h3></legend>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_descripcion}</label>
    		<div class="controls">
    			<form:input path="descripcion" class="input-large"/>
    			<form:errors path="descripcion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_umedida}</label>
    		<div class="controls">
    			<form:input path="umedida.codigo" class="input-large"/>
    			<form:errors path="umedida.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_clasificacion}</label>
    		<div class="controls">
    			<form:input path="clasificacion.codigo" class="input-large"/>
    			<form:errors path="clasificacion.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_grupo}</label>
    		<div class="controls">
    			<form:input path="grupo.codigo" class="input-large"/>
    			<form:errors path="grupo.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_marca}</label>
    		<div class="controls">
    			<form:input path="marca.codigo" class="input-large"/>
    			<form:errors path="marca.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_impuesto}</label>
    		<div class="controls">
    			<form:input path="impuesto.codigo" class="input-large"/>
    			<form:errors path="impuesto.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_proveedor}</label>
    		<div class="controls">
    			<form:input path="proveedor.codigo" class="input-large"/>
    			<form:errors path="proveedor.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		
<!--    		<div class="control-group"> -->
<%--     		<label class="control-label">${label_insumo_deposito}</label> --%>
<!--     		<div class="controls"> -->
<%--     			<form:input path="deposito.codigo" class="input-large"/> --%>
<%--     			<form:errors path="deposito.codigo" cssClass="alert alert-error" /> --%>
<!--     		</div> -->
<!--    		</div> -->
   		
<!--    		<div class="control-group"> -->
<%--     		<label class="control-label">${label_insumo_precioCosto}</label> --%>
<!--     		<div class="controls"> -->
<%--     			<form:input path="marca.codigo" class="input-large"/> --%>
<%--     			<form:errors path="marca.codigo" cssClass="alert alert-error" /> --%>
<!--     		</div> -->
<!--    		</div> -->
   		
<!--    		<div class="control-group"> -->
<%--     		<label class="control-label">${label_insumo_stockMinimo}</label> --%>
<!--     		<div class="controls"> -->
<%--     			<form:input path="marca.codigo" class="input-large"/> --%>
<%--     			<form:errors path="marca.codigo" cssClass="alert alert-error" /> --%>
<!--     		</div> -->
<!--    		</div> -->
   		
<!--    		<div class="control-group"> -->
<%--     		<label class="control-label">${label_insumo_stock}</label> --%>
<!--     		<div class="controls"> -->
<%--     			<form:input path="marca.codigo" class="input-large"/> --%>
<%--     			<form:errors path="marca.codigo" cssClass="alert alert-error" /> --%>
<!--     		</div> -->
<!--    		</div> -->
   		
   		<div class="control-group">
    		<label class="control-label">${label_insumo_activo}</label>
    		<div class="controls">
    			<form:checkbox path="activo" value="1"/>
    		</div>
   		</div>
   	</fieldset>
</form:form>


<div class="control-group form-horizontal">
	<div class="controls">
		<button id="guardar" class="btn btn-success">${button_guardar}</button>
		<a href="../listado"><button class="btn">${button_cancelar}</button></a>
		<c:if test="${not empty param.enableRemove}">
			<button id="excluir" class="btn btn-danger">${button_excluir}</button>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function () {
 	$("#frmInsumo").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 }
 		 	}
 	});
 	
 	$("#guardar").click(function () { $("#frmInsumo").submit(); });

});
</script>