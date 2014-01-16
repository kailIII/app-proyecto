<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:message code="button.guardar" var="button_guardar" htmlEscape="false" />
<spring:message code="button.cancelar" var="button_cancelar" htmlEscape="false" />
<spring:message code="button.excluir" var="button_excluir" htmlEscape="false" />

<spring:message code="label.producto" var="label_producto" htmlEscape="false" />
<spring:message code="label.producto.codigoBarra" var="label_producto_codigoBarra" htmlEscape="false" />
<spring:message code="label.producto.tipo" var="label_producto_tipo" htmlEscape="false" />
<spring:message code="label.producto.nombre" var="label_producto_nombre" htmlEscape="false" />
<spring:message code="label.producto.descripcion" var="label_producto_descripcion" htmlEscape="false" />
<spring:message code="label.producto.pcu" var="label_producto_pcu" htmlEscape="false" />
<spring:message code="label.producto.pcp" var="label_producto_pcp" htmlEscape="false" />
<spring:message code="label.producto.umedida" var="label_producto_umedida" htmlEscape="false" />
<spring:message code="label.producto.grupo" var="label_producto_grupo" htmlEscape="false" />
<spring:message code="label.producto.marca" var="label_producto_marca" htmlEscape="false" />
<spring:message code="label.producto.proveedor" var="label_producto_proveedor" htmlEscape="false" />
<spring:message code="label.producto.impuesto" var="label_producto_impuesto" htmlEscape="false" />
<spring:message code="label.producto.activo" var="label_producto_activo" htmlEscape="false" />

<form:form action="" method="${param.method}" modelAttribute="producto" class="form-horizontal" id="frmProducto">
	<input type="hidden" name="codigo" value="${producto.codigo}" />
	<input type="hidden" name="activo" value="1" />
	
	<fieldset>
   		<legend><h3>${label_producto} <small> ${param.sublabel}</small></h3></legend>
   		<div class="control-group">
    		<label class="control-label">${label_producto_tipo}</label>
    		<div class="radio inline">
    			<form:radiobuttons  path="tipo" items="${tipos}" class="radio inline"/>
    			<form:errors path="tipo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_codigoBarra}</label>
    		<div class="controls">
    			<form:input path="codigoBarra" class="input-large" />
    			<form:errors path="codigoBarra" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_nombre}</label>
    		<div class="controls">
    			<form:input path="nombre" class="input-large" />
    			<form:errors path="nombre" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_descripcion}</label>
    		<div class="controls">
    			<form:input path="descripcion" class="input-large"/>
    			<form:errors path="descripcion" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_umedida}</label>
    		<div class="controls">
    			<form:select path="umedida.codigo">
					<option value=""></option>
					<c:forEach items="${umedidas}" var="umedida">
						<c:choose>
		                    <c:when test="${umedida.codigo == producto.umedida.codigo}">
		                        <option value="${umedida.codigo}" selected="true">${umedida.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${umedida.codigo}">${umedida.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="umedida.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_grupo}</label>
    		<div class="controls">
    			<form:select path="grupo.codigo">
					<option value=""></option>
					<c:forEach items="${grupos}" var="grupo">
						<c:choose>
		                    <c:when test="${grupo.codigo == producto.grupo.codigo}">
		                        <option value="${grupo.codigo}" selected="true">${grupo.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${grupo.codigo}">${grupo.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="grupo.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_marca}</label>
    		<div class="controls">
				<form:select path="marca.codigo">
					<option value=""></option>
					<c:forEach items="${marcas}" var="marca">
						<c:choose>
		                    <c:when test="${marca.codigo == producto.marca.codigo}">
		                        <option value="${marca.codigo}" selected="true">${marca.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${marca.codigo}">${marca.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="marca.codigo" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_impuesto}</label>
    		<div class="controls">
    			<form:select path="impuesto.codigo">
					<option value=""></option>
					<c:forEach items="${impuestos}" var="impuesto">
						<c:choose>
		                    <c:when test="${impuesto.codigo == producto.impuesto.codigo}">
		                        <option value="${impuesto.codigo}" selected="true">${impuesto.nombre}</option>
		                    </c:when>
		                    <c:otherwise>
		                        <option value="${impuesto.codigo}">${impuesto.nombre}</option>
		                    </c:otherwise>
	                	</c:choose>
					</c:forEach>
				</form:select>
    			<form:errors path="impuesto.codigo" cssClass="alert alert-error" />
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
    		<label class="control-label">${label_producto_pcu}</label>
    		<div class="controls">
    			<form:input path="pcu" class="input-large" />
    			<form:errors path="pcu" cssClass="alert alert-error" />
    		</div>
   		</div>
   		<div class="control-group">
    		<label class="control-label">${label_producto_pcp}</label>
    		<div class="controls">
    			<form:input path="pcp" class="input-large" />
    			<form:errors path="pcp" cssClass="alert alert-error" />
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

<script type="text/javascript">
$(document).ready(function () {
 	$("#frmProducto").validate({
 		 	rules: {
 	 		 	nombre: { required: true, minlength: 5 },
 	 		 	pcu: {moneda: true },
				pcp: {moneda: true }
 		 	},
 		 	messages: {
 		 		nombre: 'El campo Nombre es obligatorio'
 		 	}
 	});     
 	
 	$("#guardar").click(function () { $("#frmProducto").submit(); });
 	
 	$.validator.addMethod("moneda",
 	    	function(value, element) {
 	    		return this.optional(element) || /^-?(?:\d+|\d{1,3}(?:.\d{3})+)?(?:\,\d+)?$/.test(value);
 	    	}, 'Valor invalido para precios'
 	);

});
</script>